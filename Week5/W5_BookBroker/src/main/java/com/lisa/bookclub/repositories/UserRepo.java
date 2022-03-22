package com.lisa.bookclub.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lisa.bookclub.models.User;


// All the business logic  - writing codes to interact with your database.
@Repository
public interface UserRepo extends CrudRepository<User, Long>{
	
	List<User> findAll();
	
//	Optional<User> findByEmail(String email);
	
	
	boolean existsByEmail(String email);

	User findByEmail(String email);
	
	//we do not need to make a respository for the LoginUser since we only want to save instances of User to the database
}
