package com.lisa.jstlloopsandyou.controllers;
	
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import java.util.ArrayList;

@Controller
public class HomeController {

    @RequestMapping("/dojos")
    public String index(Model model) {
        
    	ArrayList<String> dojos = new ArrayList<String>();
        
    	dojos.add("Burbank");
        dojos.add("Chicago");
        dojos.add("Bellevue");
        model.addAttribute("dojosFromMyController", dojos);
        
        return "index.jsp";
		
	}
}
