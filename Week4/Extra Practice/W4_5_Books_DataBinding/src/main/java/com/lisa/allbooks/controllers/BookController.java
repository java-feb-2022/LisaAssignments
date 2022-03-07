package com.lisa.allbooks.controllers;

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

import com.lisa.allbooks.models.Book;
import com.lisa.allbooks.services.BookService;

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
 
	// NEW CREATE METHOD
	@PostMapping("/books")
	public String create(
			@Valid @ModelAttribute("book") Book book, BindingResult result) {			
//			@RequestParam(value="title") String title, 
//			@RequestParam(value="description") String desc, 
//			@RequestParam(value="language") String lang, 
//			@RequestParam(value="pages") Integer numOfPages) {
//		Book book = new Book(title, desc, lang, numOfPages);
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
//
// @RequestMapping(value="/books/{id}", method=RequestMethod.PUT)
// public Book update(@PathVariable("id") Long id, @RequestParam(value="title") String title, @RequestParam(value="description") String desc, @RequestParam(value="language") String lang, @RequestParam(value="pages") Integer numOfPages) {
//	 
//	 Book updatedBook = bookService.findBook(id);
//	 
//	 // calling a method from you Book class
//	 updatedBook.setTitle(title);
//	 updatedBook.setDescription(desc);
//	 updatedBook.setLanguage(lang);
//	 updatedBook.setNumberOfPages(numOfPages);
//
//	 Book book = bookService.updateBook(updatedBook);
//	 return book;
// }
 
 
 // COOL METHOD BONDING TIME WITH SIERRA (less calls to database)
// @RequestMapping(value="/books/{id}", method=RequestMethod.PUT)
// public Book update(@PathVariable("id") Long id, @RequestParam(value="title") String title, @RequestParam(value="description") String desc, @RequestParam(value="language") String lang, @RequestParam(value="pages") Integer numOfPages) {
//	 
//	 // setting up to query - describing the row you want to update
//	 Book updatedBook = new Book(title, desc, lang, numOfPages);
//	 
//	 // calling the setID method on the book
//	 updatedBook.setId(id);
//
//	 Book book = bookService.updateBook(updatedBook);
//	 return book;
// }
// 
 
 
// @RequestMapping(value="/books/{id}", method=RequestMethod.DELETE)
// public void destroy(@PathVariable("id") Long id) {
//     bookService.deleteBook(id); 
// }
}
