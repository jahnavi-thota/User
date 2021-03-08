package com.module.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.module.Entity.Customer;
import com.module.Entity.User;
import com.module.RepoSitory.CustomerRepo;
import com.module.RepoSitory.UserRepository;
import com.module.Service.CustomerService;
import com.module.Service.UserService;

@RestController
public class CustomerController {
@Autowired
UserService userService;
@Autowired
UserRepository userRepo;
@Autowired
CustomerService customerService;
@Autowired
CustomerRepo custRepo;
@PostMapping(value="/Customer/input/{password}")
@ResponseStatus(code = HttpStatus.CREATED) 
public Customer addUser(@PathVariable("password") String pass,@RequestBody Customer c) 
{
	  customerService.addCustomer(pass, c);
	  return c;
}
}
