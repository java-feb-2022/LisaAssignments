package com.lisa.bookclub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lisa.bookclub.models.Book;
import com.lisa.bookclub.repositories.BookRepo;

@Service
public class BookService {
	
	@Autowired
	private BookRepo bookRepo;
	
	
	 // returns all the books
    public List<Book> allBooks() {
        return bookRepo.findAll();
    }
    // creates a book
    public Book createBook(Book newBook) {
        return bookRepo.save(newBook);
    }
    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepo.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    
    // updates the book
    public Book updateBook(Book updatedBook) {
    	return bookRepo.save(updatedBook);
    }
    
    public void deleteBook(Long id) {
    	Optional<Book> deleteBookAction = bookRepo.findById(id);
    	if(deleteBookAction.isPresent()) {
    		bookRepo.deleteById(id);
    	} 
    	else {
    		System.out.println("Failed to delete");
    	}
    }
}
