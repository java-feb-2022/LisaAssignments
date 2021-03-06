package com.lisa.mvc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.lisa.mvc.models.Book;
import com.lisa.mvc.services.BookService;

@Controller //Controller will return a jsp page
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@RequestMapping("/api/books")
	public String index(Model model) {
		List<Book> books = bookService.allBooks();
		model.addAttribute("allBooks",books);
		return "index.jsp";
 }
 
//	@RequestMapping(value="/api/books", method=RequestMethod.POST)
// public Book create(@RequestParam(value="title") String title, @RequestParam(value="description") String desc, @RequestParam(value="language") String lang, @RequestParam(value="pages") Integer numOfPages) {
//     Book book = new Book(title, desc, lang, numOfPages);
//     return bookService.createBook(book);
// }
 
 @RequestMapping("/api/books/{id}")
 public String show(Model model, @PathVariable("id") Long id) {
     Book book = bookService.findBook(id);
     model.addAttribute("showBook",book);
     
     return "show.jsp";
 }
//
// @RequestMapping(value="/api/books/{id}", method=RequestMethod.PUT)
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
// @RequestMapping(value="/api/books/{id}", method=RequestMethod.PUT)
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
 
 
// @RequestMapping(value="/api/books/{id}", method=RequestMethod.DELETE)
// public void destroy(@PathVariable("id") Long id) {
//     bookService.deleteBook(id); 
// }
}
