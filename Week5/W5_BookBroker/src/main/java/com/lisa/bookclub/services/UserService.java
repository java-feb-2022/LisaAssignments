package com.lisa.bookclub.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.lisa.bookclub.models.LoginUser;
import com.lisa.bookclub.models.User;
import com.lisa.bookclub.repositories.UserRepo;

@Service
public class UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	
    // TO-DO: Write register and login methods!
	public User register(User newUser, BindingResult result) {
        // TO-DO - Reject values or register if no errors:
        
        // Reject if email is taken (present in database)
        if(userRepo.findByEmail(newUser.getEmail())!=null) {
            result.rejectValue("email", "unique", "This email is already used");
        }
        // Reject if password doesn't match confirmation
        if(!newUser.getPassword().equals(newUser.getConfirm())) {
            result.rejectValue("password", "Mismatch", "Password does not match");
        }
        // Return null if result has errors
        if(result.hasErrors()) {
            return null;
        }
        // Hash and set password, save user to database
        String hashed= BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
        newUser.setPassword(hashed);
        userRepo.save(newUser);
        return null;
    }
    public User login(LoginUser newLogin, BindingResult result) {
        // TO-DO: Additional validations!
        // Find user by email, reject if not present
        User user = userRepo.findByEmail(newLogin.getEmail());
        if(user==null) {
            result.rejectValue("email", "missingEmail", "Email not found");
            return null;
        } 
        else {
            if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
                result.rejectValue("password", "Matches", "Invalid Password");
            }


        }

        return user;
    }
	
	 // returns all the users
    public List<User> allUsers() {
        return userRepo.findAll();
    }
    // creates a user
    public User createUser(User newUser) {
        return userRepo.save(newUser);
    }
    // retrieves a user
    public User findUser(Long id) {
        Optional<User> optionalUser = userRepo.findById(id);
        if(optionalUser.isPresent()) {
            return optionalUser.get();
        } else {
            return null;
        }
    }
    
    // updates the user
    public User updateUser(User updatedUser) {
    	return userRepo.save(updatedUser);
    }
    
    public void deleteUser(Long id) {
    	Optional<User> deleteUserAction = userRepo.findById(id);
    	if(deleteUserAction.isPresent()) {
    		userRepo.deleteById(id);
    	} 
    	else {
    		System.out.println("Failed to delete");
    	}
    }
}
