package com.module.Service;

import java.util.List;
import java.util.Optional;

import javax.xml.bind.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.module.Entity.User;
import com.module.Exceptions.DuplicateUserException;
import com.module.Exceptions.NotValidUserException;
import com.module.Exceptions.UserNotFoundException;

import com.module.RepoSitory.UserRepository;

@Service
public class UserService {
	@Autowired
    UserRepository userRepo;
public User addUser(User user) 
{
	Optional<User> use = userRepo.findById(user.getUserId());
			if(use.isPresent()) 
			{
				throw new DuplicateUserException("user already present");
			}
			else
              {
				userRepo.save(user);
			  }
return user;
}
public void deleteUser(int id) 
{	
	Optional<User> use = userRepo.findById(id);
	if(use.isPresent()) {
	userRepo.deleteById(id);
	}
	else {
		throw new UserNotFoundException("User is not found");
	}
}
public User validateUser(String role,User user) 
{
	String string ="admin";
	Optional<User> use = userRepo.findById(user.getUserId());
	if(role.equalsIgnoreCase(string))
	{if(use.isPresent()) 
	{
		userRepo.findUserByIdAndPassword(user.getUserName(), user.getPassword());
	}}
	else {
		throw new NotValidUserException("not valid details");
	}
	return user;
	}
}

	


