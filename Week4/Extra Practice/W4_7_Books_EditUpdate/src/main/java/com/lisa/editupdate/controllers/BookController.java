package com.lisa.editupdate.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.lisa.editupdate.models.Book;
import com.lisa.editupdate.services.BookService;

@Controller //Controller will return a jsp page
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@GetMapping("/books")
	public String index(Model model) {
		List<Book> books = bookService.allBooks();
		model.addAttribute("allBooks",books);
		return "index.jsp";
	}
	
	@GetMapping("/books/new")
	public String newBook(@ModelAttribute("book") Book book) {
		return "new.jsp";
	}
 
	@PostMapping("/books")
	public String create(
			@Valid @ModelAttribute("book") Book book, BindingResult result) {			
		if (result.hasErrors()) {
			return "new.jsp";
			} else {
				bookService.createBook(book);
				return "redirect:/books";				
			}
	}
 
	 @GetMapping("/books/{id}")
	 public String show(Model model, @PathVariable("id") Long id) {
		 Book book = bookService.findBook(id);
		 model.addAttribute("showBook",book);
		 return "show.jsp";
	 }
	 
    @GetMapping("/books/{id}/edit")
	 public String edit(Model model, @PathVariable("id") Long id) {
		 Book book = bookService.findBook(id);
		 model.addAttribute("editBook",book);
        return "edit.jsp";
    }
    
    @PutMapping("/books/{id}")
    public String update(@Valid @ModelAttribute("book") Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "/books/edit.jsp";
        } else {
            bookService.updateBook(book);
            return "redirect:/books";
        }
    }
 
// @RequestMapping(value="/books/{id}", method=RequestMethod.DELETE)
// public void destroy(@PathVariable("id") Long id) {
//     bookService.deleteBook(id); 
// }
}
