package com.lisa.bookclub.controllers;

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

import com.lisa.bookclub.models.Book;
import com.lisa.bookclub.models.LoginUser;
import com.lisa.bookclub.models.User;
import com.lisa.bookclub.services.BookService;
import com.lisa.bookclub.services.UserService;

@Controller
public class MainController {

	@Autowired
	private UserService userService;

	@Autowired
	private BookService bookService;
	
	/////////////START LOGIN REGISTRATION/////////////////
	
	//////////// REGISTER POST ROUTE ///////////////
    
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
	    return "redirect:/books";
	}

	
	//////////// LOGIN POST ROUTE ///////////////

	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin,BindingResult result, Model model, HttpSession session) {
	    // Add once service is implemented:
	    User user = userService.login(newLogin, result);
	
	    if(result.hasErrors()) {
	    	model.addAttribute("newUser", new User());
	        return "login.jsp";
	    }
	
	    // No errors! 
	    // TO-DO Later: Store their ID from the DB in session, 
	    // in other words, log them in.
	    session.setAttribute("user_id", user.getId());
	    return "redirect:/books";
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
		return "redirect:/books";
	}
	
	/////////////END LOGIN REGISTRATION/////////////////
	
	
	
	
	
	//////////// DASHBOARD ROUTE ///////////////
    
    @GetMapping("/books")
    public String dashboard(HttpSession session, Model model) {
    	if(session.getAttribute("user_id") == null) {
    		return "redirect:/";
    	}
    	Long userId = (Long) session.getAttribute("user_id");
    	User userLogin=userService.findUser(userId);
    	model.addAttribute("userLogin",userLogin);
    	model.addAttribute("allBooks", bookService.allBooks());
    	
    	return "dashboard.jsp";
    	}
  
    
    
    ///////////NEW BOOK////////////
    
    /////////// FORM /////////////
    @GetMapping("/books/new")
    public String bookForm(@ModelAttribute("addBook") Book book, HttpSession session, Model model) {
        if(session.getAttribute("user_id") == null) {
        	return "redirect:/";
        }
        Long userId = (Long) session.getAttribute("user_id");
        User userLogin = userService.findUser(userId);
        model.addAttribute("userLogin", userLogin);
        return "newItem.jsp";
    }
    
    /////////// SUBMIT FORM /////////////	
	@PostMapping("/books/create")
	public String createBook(@Valid @ModelAttribute("addBook") Book newBook, BindingResult result, HttpSession session) {

	    if(result.hasErrors()) {
	        return "newItem.jsp";
	    }
		Long userId = (Long) session.getAttribute("user_id");
	    newBook.setModifier(userService.findUser(userId));

	    bookService.createBook(newBook);
	    return "redirect:/books";
	}
	
	//////////////SHOW ONE BOOK////////////////
	@GetMapping("/books/{id}")
	public String showBook(@PathVariable("id") Long id, @ModelAttribute("showBook") Book book, Model model, HttpSession session, BindingResult result) {
		if(session.getAttribute("user_id")==null) {
			return "redirect:/";
		}
		Long userId = (Long) session.getAttribute("user_id");
		model.addAttribute("userLogin", userService.findUser(userId));
		model.addAttribute("showBook", bookService.findBook(id));
		return "showItem.jsp";
		
	}
	
	///////////////EDIT BOOK/////////////////////
	
    @GetMapping("/books/{id}/edits")
    public String editForm(@PathVariable("id") Long id, @ModelAttribute("editBook") Book book, HttpSession session, Model model) {
        if(session.getAttribute("user_id") == null) {
        	return "redirect:/";
        }
        Long userId = (Long) session.getAttribute("user_id");
        User userLogin = userService.findUser(userId);
        model.addAttribute("userLogin", userLogin);
        model.addAttribute("editBook", bookService.findBook(id));
        return "editItem.jsp";
    }
	
	@PostMapping("/books/{id}/edit")
	public String editBook(@PathVariable("id") Long id, @Valid @ModelAttribute("editBook") Book editBook, BindingResult result, Model model, HttpSession session, @ModelAttribute("modifier") User user) {

	    if(result.hasErrors()) {
//	    	Long userId = (Long) session.getAttribute("user_id");
//	        User userLogin = userService.findUser(userId);
//	        model.addAttribute("userLogin", userLogin);
//	        
	        return "editItem.jsp";
	    }
	    editBook.setModifier(user);
		bookService.updateBook(editBook);
		return "redirect:/books";
	}
	
	/////////////////DELETE BOOK//////////////////////
	@GetMapping("/delete/book/{id}")
	public String deleteBook(@PathVariable("id") Long id) {
		bookService.deleteBook(id);
		return "redirect:/books";
	}
	
	
}
