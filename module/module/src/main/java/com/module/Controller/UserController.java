package com.module.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.module.Entity.*;
import com.module.Exceptions.DuplicateUserException;
import com.module.Exceptions.UserNotFoundException;

import com.module.RepoSitory.UserRepository;
import com.module.Service.UserService;


@RestController

public class UserController {
	
	@Autowired
	UserRepository userRepo;
    @Autowired
    UserService userService;
  

    
	  @PostMapping("/addUser")
	  @ResponseStatus(code = HttpStatus.CREATED) 
	  public ResponseEntity<String> addUser(@RequestBody User u) 
	  {
	
		  Optional<User> user =userRepo.findByUsername(u.getUserName());  
		 if(user.isPresent()) 
		 {
			 return new ResponseEntity<>("Duplicate is present!!!", HttpStatus.CONFLICT);
		 }
		 else {
		  userService.addUser(u);
		  return new ResponseEntity<>("Successfully created!!!", HttpStatus.CREATED);
		 }
		  
	  } 
	  @DeleteMapping("/user/{id}")
	  @ResponseStatus(code = HttpStatus.NO_CONTENT) 
	  public ResponseEntity<String> deleteUser(@PathVariable("id") int id) 
	  { 
		  Optional<User> user =userRepo.findById(id);  
			 if(user.isPresent()) 
			 {
			  userService.deleteUser(id);
			  return new ResponseEntity<>("user deleted" , HttpStatus.OK);
		}
			 else {
				 return new ResponseEntity<>("No user" , HttpStatus.NOT_FOUND);
			}}
	  
	  
	  @GetMapping("/validateUser/{role}")
	  @ResponseStatus(code = HttpStatus.OK) 
	  public ResponseEntity<String> validateUser(@PathVariable("role") String role,@RequestBody User user)
	  
	  { 
		  Optional<User> use = userRepo.findByUsername(user.getUserName()); 
		 if(use.isPresent()) {
		  userService.validateUser(role, user);
		  return new ResponseEntity<>("validation of user" , HttpStatus.ACCEPTED);
		 }
		 else {
			 return new ResponseEntity<>("Not possible to validate" , HttpStatus.NOT_FOUND);
		}
		 
	}
}


