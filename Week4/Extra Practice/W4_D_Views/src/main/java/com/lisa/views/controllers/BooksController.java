package com.lisa.views.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.lisa.views.models.Book;
import com.lisa.views.services.BookService;

@Controller
public class BooksController {

//	@Autowired
//	BookService bookService;
	
	private final BookService bookService;
	public BooksController(BookService bookService){
	    this.bookService = bookService;
	}
	@RequestMapping("/api/books")
	public List<Book> index() {
	    return bookService.allBooks();
	}
	 
	@RequestMapping(value="/api/books", method=RequestMethod.POST)
	public Book create(@RequestParam(value="title") String title, @RequestParam(value="description") String desc, @RequestParam(value="language") String lang, @RequestParam(value="pages") Integer numOfPages) {
	    Book book = new Book(title, desc, lang, numOfPages);
	    return bookService.createBook(book);
	}
	 
	@RequestMapping("/api/books/{bookId}")
	public String index (Model model, @PathVariable("bookId") Long bookId) {
		Book book = bookService.findBook(bookId);
		model.addAttribute("book",book);
		return "index.jsp";
	}
	
	@RequestMapping(value="/api/books/{id}", method=RequestMethod.PUT)
	public Book update(@PathVariable("id") Long id, @RequestParam(value="title") String title, @RequestParam(value="description") String desc, @RequestParam(value="language") String lang, @RequestParam(value="pages") Integer numOfPages) {
	 
	Book updatedBook = bookService.findBook(id);
	 
	// calling a method from you Book class
	 	updatedBook.setTitle(title);
	 	updatedBook.setDescription(desc);
	 	updatedBook.setLanguage(lang);
	 	updatedBook.setNumberOfPages(numOfPages);
	 
	 	Book book = bookService.updateBook(updatedBook);
			return book;
	 }
 
 
 // COOL METHOD BONDING TIME WITH SIERRA
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
 
 
	@RequestMapping(value="/api/books/{id}", method=RequestMethod.DELETE)
	public void destroy(@PathVariable("id") Long id) {
	    bookService.deleteBook(id); 
	}
}
