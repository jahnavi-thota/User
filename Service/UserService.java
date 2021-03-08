package com.module.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.module.Entity.Customer;
import com.module.Entity.User;
import com.module.Exceptions.DuplicateUserException;
import com.module.Exceptions.NotValidUserException;
import com.module.Exceptions.UserNotFoundException;
import com.module.RepoSitory.CustomerRepo;
import com.module.RepoSitory.UserRepository;

@Service
public class UserService {
	@Autowired
    UserRepository userRepo;
public User addUser(User user) 
{
	Optional<User> userOptional = userRepo.findById(user.getUserId());
	if(!(userOptional.isPresent())) 
	{
	userRepo.save(user);
	}
	else {
		throw new DuplicateUserException("user"+user.getUserId()+"Already exixts");
	}

return user;
}
public void deleteUser(int id) 
{
	Optional<User> user = userRepo.findById(id);
	if(user.isPresent())
	{
	userRepo.deleteById(id);
	}
	else {
		throw new UserNotFoundException("user not found with id : "+id);
	}
}
public User validateUser(String role,User user) 
{
	String str="admin";
   if(str.equalsIgnoreCase(role)) {
	Optional<User> useOptional = userRepo.findUserByIdAndPassword(user.getUserId(), user.getPassword());
	if(useOptional.isEmpty()) 
	{
		throw new NotValidUserException("User Id : "+user.getUserId()+"or the User password : "+user.getPassword()+"is invalid");
	}}
	return user;
}}
