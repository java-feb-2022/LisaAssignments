package com.lisa.examtemplate.controllers;

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

import com.lisa.examtemplate.models.LoginUser;
import com.lisa.examtemplate.models.Project;
import com.lisa.examtemplate.models.User;
import com.lisa.examtemplate.services.ProjectService;
import com.lisa.examtemplate.services.UserService;

@Controller
public class MainController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private HttpSession session;

	/////////////START LOGIN REGISTRATION/////////////////
		
	//////////// REGISTER USER ///////////////
	
	@GetMapping("/")
	public String login(Model model) {
	model.addAttribute("newUser", new User());
	model.addAttribute("newLogin", new LoginUser());
	return "login.jsp";
	}
	
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model, HttpSession session) {
	userService.register(newUser,  result);
	
	if(result.hasErrors()) {
	    model.addAttribute("newLogin", new LoginUser()); 
	    return "login.jsp";
	}	    
	session.setAttribute("user_id", newUser.getId());
	return "redirect:/dashboard";
	}
	
	
	//////////// LOGIN POST ROUTE ///////////////
	
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin,BindingResult result, Model model, HttpSession session) {
	User user = userService.login(newLogin, result);
	
	if(result.hasErrors()) {
		model.addAttribute("newUser", new User());
	    return "login.jsp";
	}
	
	session.setAttribute("user_id", user.getId());
	return "redirect:/dashboard";
	}
	
	
	//////////// LOGOUT GET ROUTE ///////////////
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
	session.invalidate();
	return "redirect:/";
	}
	
	//////////// DELETE GET ROUTE ///////////////
	
	@GetMapping("/delete/user/{id}")
	public String delete(@PathVariable("id") Long id) {
	userService.deleteUser(id);
	return "redirect:/dashboard";
	}
	
	/////////////END LOGIN REGISTRATION/////////////////
	
	
	//////////// DASHBOARD ROUTE ///////////////
    
    @GetMapping("/dashboard")
    public String dashboard(HttpSession session, Model model) {
    	if(session.getAttribute("user_id") == null) {
    		return "redirect:/";
    	}
    	Long userId = (Long) session.getAttribute("user_id");
    	User userLogin=userService.findUserById(userId);
    	model.addAttribute("userLogin",userLogin);
    	model.addAttribute("allProjects", projectService.allProjects());
    	
    	return "dashboard.jsp";
    	}
	
    /////////////END DASHBOARD ///////////////////////
    
    
	/////////////NEW PROJECT////////////
	//    
	///////////// FORM /////////////
	@GetMapping("/projects/new")
	public String projectForm(@ModelAttribute("addProject") Project project, HttpSession session, Model model) {
	  if(session.getAttribute("user_id") == null) {
	  	return "redirect:/";
	  }
	  Long userId = (Long) session.getAttribute("user_id");
	  User userLogin = userService.findUserById(userId);
	  model.addAttribute("userLogin", userLogin);
	  return "newItem.jsp";
	}
	
	/////////// SUBMIT FORM /////////////	
	@PostMapping("/projects/create")
	public String createProject(@Valid @ModelAttribute("addProject") Project newProject, BindingResult result, HttpSession session) {
	
	  if(result.hasErrors()) {
	      return "newItem.jsp";
	  }
//	  Long userId = (Long) session.getAttribute("user_id");
//	  newProject.setModifier(userService.findUserById(userId));
	
	  projectService.createProject(newProject);
	  return "redirect:/dashboard";
	}
	
	////////////////SHOW ONE BOOK////////////////
	@GetMapping("/projects/{id}")
	public String showProject(@PathVariable("id") Long id, @ModelAttribute("showProject") Project project, Model model, HttpSession session) {
		if(session.getAttribute("user_id")==null) {
			return "redirect:/";
		}
		Long userId = (Long) session.getAttribute("user_id");
		model.addAttribute("userLogin", userService.findUserById(userId));
		model.addAttribute("showProject", projectService.findProjectById(id));
		return "showItem.jsp";
		
	}
	
	/////////////////EDIT BOOK/////////////////////
	
	@GetMapping("/projects/{id}/edits")
	public String editForm(@PathVariable("id") Long id, @ModelAttribute("editProject") Project project, HttpSession session, Model model) {
	  if(session.getAttribute("user_id") == null) {
	  	return "redirect:/";
	  }
	  Long userId = (Long) session.getAttribute("user_id");
	  User userLogin = userService.findUserById(userId);
	  model.addAttribute("userLogin", userLogin);
	  model.addAttribute("editProject", projectService.findProjectById(id));
	  return "editItem.jsp";
	}
	
	@PostMapping("/projects/{id}/edit")
	public String editProject(@PathVariable("id") Long id, @Valid @ModelAttribute("editProject") Project editProject, BindingResult result, Model model, HttpSession session, @ModelAttribute("modifier") User user) {
	
	  if(result.hasErrors()) {	
	      return "editItem.jsp";
	  }
//	  editProject.setModifier(user);
		projectService.updateProject(editProject);
		return "redirect:/dashboard";
	}
	
	///////////////////DELETE BOOK//////////////////////
	@GetMapping("/delete/project/{id}")
	public String deleteProject(@PathVariable("id") Long id) {
		if(session.getAttribute("userLogin")!=null) {
		projectService.deleteProject(id);
		return "redirect:/dashboard";
	} else {
		return "redirect:/";
	}}

    
	///////////////////////// LIKE / DISLIKE //////////////////////////////////
		
	/////////////////  LIKE  //////////////////////////
	@GetMapping("/project/like/{id}")
	public String likeProject(@PathVariable("id") Long id) {
		Project project=projectService.findProjectById(id);
		User user=(User)session.getAttribute("userLogin");
		User userLike=userService.findUserById(user.getId());
		projectService.likeProject(project, userLike);
		return "redirect:/dashboard";
	}

	/////////////////  DISLIKE  //////////////////////////
	@GetMapping("/project/dislike/{id}")
	public String dislikeProject(@PathVariable("id") Long id) {
		Project project=projectService.findProjectById(id);
		User user=(User)session.getAttribute("userLogin");
		User userDislike=userService.findUserById(user.getId());
		projectService.dislikeProject(project, userDislike);
		return "redirect:/dashboard";
	}

    
}