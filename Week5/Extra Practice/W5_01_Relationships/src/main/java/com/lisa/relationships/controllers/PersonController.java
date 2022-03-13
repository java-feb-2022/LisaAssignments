package com.lisa.relationships.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.lisa.relationships.models.License;
import com.lisa.relationships.models.Person;
import com.lisa.relationships.services.LicenseService;
import com.lisa.relationships.services.PersonService;

@Controller //Controller will return a jsp page
public class PersonController {
	
	@Autowired
	PersonService personService;
	
	@Autowired
	LicenseService licenseService;
	
	@GetMapping("/")
	public String home() {
		return "redirect:/persons";
	}
	
	@GetMapping("/persons")
	public String indexPerson(Model model, @ModelAttribute("person") Person person) {
		List<Person> persons = personService.allPersons();
		model.addAttribute("allPersons",persons);
		return "index.jsp";
	}
	
	@PostMapping("/persons")
	public String createPerson(
			@Valid @ModelAttribute("person") Person person, BindingResult result) {
		if (result.hasErrors()) {
			return "index.jsp";
			} else {
				personService.createPerson(person);
				return "redirect:/licenses";				
			}
	}

	@GetMapping("/licenses")
	public String indexLicense(Model model, @ModelAttribute("license") License license) {
		List<Person> persons = personService.allPersons();
		model.addAttribute("allPersons",persons);
		return "license.jsp";
	}
	
	@PostMapping("/licenses")
	public String createLicense(
			@Valid @ModelAttribute("license") License license, BindingResult result) {
		if (result.hasErrors()) {
			return "index.jsp";
			} else {
				licenseService.createLicense(license);
				return "redirect:/persons";				
			}
	}
	
	 @GetMapping("/persons/{id}")
	 public String show(Model model, @PathVariable("id") Long id) {
		 Person someAwesomePerson= personService.findPerson(id);
		 model.addAttribute("showPerson",someAwesomePerson);
		 return "show.jsp";
	 }
	 
    @GetMapping("/persons/edit/{id}")
	 public String edit(Model model, @PathVariable("id") Long id) {
		 Person person = personService.findPerson(id);
		 model.addAttribute("editPerson",person);
        return "edit.jsp";
    }
    
    @PutMapping("/persons/{id}")
    public String update(
    		@Valid @ModelAttribute("editPerson") Person person, BindingResult result) {
        if (result.hasErrors()) {
            return "edit.jsp";
        } else {
            personService.updatePerson(person);
            return "redirect:/persons";
        }
    }
 
    @DeleteMapping(value="/persons/delete/{id}")
    public String destroy(@PathVariable("id") Long id) {
    	personService.deletePerson(id);
    	return "redirect:/persons";
    }
}
