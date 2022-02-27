package com.lisa.counter.controllers;
	
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;


@RequestMapping("/your_server")
@Controller
public class HomeController {
	
	@RequestMapping("")
	public String index(HttpSession session) {
		
		if (session.getAttribute("count") == null) {
			Integer currentCount = (Integer) session.getAttribute("count"); 
			session.setAttribute("count", currentCount=0);
			
	        return "index.jsp";
		}
		else {
			Integer currentCount = (Integer) session.getAttribute("count"); 
			session.setAttribute("count", currentCount + 1);
	        return "index.jsp";
		}
	}

	@RequestMapping("/counter")
	public String showCount(HttpSession session, Model model) {

		Integer currentCount = (Integer) session.getAttribute("count");
		model.addAttribute("countToShow", currentCount);
		return "counter.jsp";
	}

}
