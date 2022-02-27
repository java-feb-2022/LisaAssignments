package com.lisa.displaydate.controllers;
	
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

import java.util.Date;
import java.text.SimpleDateFormat;

@Controller
public class HomeController {
	@RequestMapping("/")
	private String index() {
		return "index.jsp";
		
	}
	
	@RequestMapping("/date")
	private String date(Model model) {
		String pattern = "EEEEEEE, 'the' dd ' of ' MMMMMM";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
			
		String date = simpleDateFormat.format(new Date());
		model.addAttribute("date", date);
		return "date.jsp";
		}
	
	@RequestMapping("/time")
	private String time(Model model) {
		String pattern = "hh:mm a";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
			
		String time = simpleDateFormat.format(new Date());
		model.addAttribute("time", time);
		return "time.jsp";
	}
}
