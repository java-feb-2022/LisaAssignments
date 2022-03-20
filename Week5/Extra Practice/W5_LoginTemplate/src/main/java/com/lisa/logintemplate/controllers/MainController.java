package com.lisa.logintemplate.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.lisa.logintemplate.models.LoginUser;
import com.lisa.logintemplate.models.User;
import com.lisa.logintemplate.services.UserService;

@Controller
public class MainController {

	@Autowired
	private UserService userService;

	
    @GetMapping("/")
    public String login(Model model) {
        // Bind empty User and LoginUser objects to the JSP
        // to capture the form input
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
        return "login.jsp";
    }
    
    @GetMapping("/dashboard")
    public String dashboard(HttpSession session, Model model) {
    	if(session.getAttribute("user_id") == null) {
    		return "redirect:/";
    	}
    	Long userId = (Long) session.getAttribute("user_id");
    	User userLogin=userService.findUser(userId);
    	model.addAttribute("userLogin",userLogin);
    	return "dashboard.jsp";
    }
	
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model, HttpSession session) {
	    userService.register(newUser,  result);
	    // TO-DO Later -- call a register method in the service 
	    // to do some extra validations and create a new user!
	    
	    if(result.hasErrors()) {
	        // Be sure to send in the empty LoginUser before re-rendering the page.
	        model.addAttribute("newLogin", new LoginUser()); // very similar to login @ModelAttribute("newUser")
	        return "login.jsp";
	    }
	    
	    // No errors! 
	    // TO-DO Later: Store their ID from the DB in session, 
	    // in other words, log them in.
	    session.setAttribute("user_id", newUser.getId());
	    return "redirect:/dashboard";
	}
	
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin,BindingResult result, Model model, HttpSession session, @ModelAttribute("newUser") User newUser) {
	    // Add once service is implemented:
	    userService.login(newLogin, result);
	
	    if(result.hasErrors()) {
	    	
	        return "login.jsp";
	    }
	
	    // No errors! 
	    // TO-DO Later: Store their ID from the DB in session, 
	    // in other words, log them in.
	
	    return "redirect:/dashboard";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("/delete/user/{id}")
	public String delete(@PathVariable("id") Long id) {
		userService.deleteUser(id);
		return "redirect:/dashboard";
	}
}
