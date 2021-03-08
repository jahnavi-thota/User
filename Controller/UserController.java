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
import com.module.RepoSitory.CustomerRepo;
import com.module.RepoSitory.UserRepository;
import com.module.Service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserRepository userRepo;
    @Autowired
    UserService userService;
   
    
	  @PostMapping(value="/users/inputs")
	  @ResponseStatus(code = HttpStatus.CREATED) 
	  public User addUser(@RequestBody User u) 
	  {
		  userService.addUser(u); 
		  return u;
	  }
	 
	  
	  @DeleteMapping("/user/{id}")
	  
	  @ResponseStatus(code = HttpStatus.NO_CONTENT) 
	  public void deleteUser(@PathVariable("id") int id) 
	  {
		  userService.deleteUser(id); 
	  }
	  
	  @GetMapping("/User/{role}")
	  
	  @ResponseStatus(code = HttpStatus.OK) public User
	  validateUser(@PathVariable("role") String role,@RequestBody User user)
	  
	  {
		  userService.validateUser(role, user); 
		  return user; 
		}
	  
	 
}


