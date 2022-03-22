package com.lisa.bookclub.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lisa.bookclub.models.Book;


// All the business logic  - writing codes to interact with your database.
@Repository
public interface BookRepo extends CrudRepository<Book, Long>{
	
	List<Book> findAll();
	
}
