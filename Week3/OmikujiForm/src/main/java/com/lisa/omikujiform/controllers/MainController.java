package com.lisa.omikujiform.controllers;
	
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;

@Controller
public class MainController {
	
	@RequestMapping("/")
	public String index() {
		return "redirect:/omikuji";
	}
	
	@RequestMapping(value="/omikuji")
	public String indexReal() {
		return "index.jsp";
	}
	
	@RequestMapping(value="/processForm", method=RequestMethod.POST)
	public String processForm(
		@PathVariable(value="randNumber") int randNumber,
		@PathVariable(value="cityName") String cityName,
		@PathVariable(value="personName") String personName,
		@PathVariable(value="hobby") String hobby,
		@PathVariable(value="livingThing") String livingThing,
		@PathVariable(value="somethingNice") String somethingNice,
		HttpSession session) {
		String formResults=String.format(
				"words %s %s %s %s %s", randNumber, cityName, personName, hobby, somethingNice
				);
		session.setAttribute("formResultFinal",formResults);
		return "redirect:/omikuji/display";
	}
	
	@RequestMapping("/omikuji/display")
	public String display(HttpSession session, Model model) {

		String displayResult = (String) session.getAttribute("formResultFinal");
		model.addAttribute("result",displayResult);
		return "display.jsp";
	}
}