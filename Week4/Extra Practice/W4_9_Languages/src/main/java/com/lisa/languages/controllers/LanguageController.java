package com.lisa.languages.controllers;

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

import com.lisa.languages.models.Language;
import com.lisa.languages.services.LanguageService;

@Controller //Controller will return a jsp page
public class LanguageController {
	
	@Autowired
	LanguageService languageService;
	
	
	@GetMapping("/")
	public String home() {
		return "redirect:/languages";
	}
	
	@GetMapping("/languages")
	public String index(Model model, @ModelAttribute("language") Language language) {
		List<Language> languages = languageService.allLanguages();
		model.addAttribute("allLanguages",languages);
		return "index.jsp";
	}
	
	@PostMapping("/languages")
	public String create(
			@Valid @ModelAttribute("language") Language language, BindingResult result) {
		if (result.hasErrors()) {
			return "index.jsp";
			} else {
				languageService.createLanguage(language);
				return "redirect:/languages";				
			}
	}
 
	 @GetMapping("/languages/{id}")
	 public String show(Model model, @PathVariable("id") Long id) {
		 Language language = languageService.findLanguage(id);
		 model.addAttribute("showLanguage",language);
		 return "show.jsp";
	 }
	 
    @GetMapping("/languages/edit/{id}")
	 public String edit(Model model, @PathVariable("id") Long id) {
		 Language language = languageService.findLanguage(id);
		 model.addAttribute("editLanguage",language);
        return "edit.jsp";
    }
    
    @PutMapping("/languages/{id}")
    public String update(
    		@Valid @ModelAttribute("editLanguage") Language language, BindingResult result) {
        if (result.hasErrors()) {
            return "edit.jsp";
        } else {
            languageService.updateLanguage(language);
            return "redirect:/languages";
        }
    }
 
    @DeleteMapping(value="/languages/delete/{id}")
    public String destroy(@PathVariable("id") Long id) {
    	languageService.deleteLanguage(id);
    	return "redirect:/languages";
    }
}
