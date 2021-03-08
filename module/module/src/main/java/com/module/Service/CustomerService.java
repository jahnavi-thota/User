package com.module.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.module.Entity.Customer;
import com.module.Entity.User;
import com.module.Exceptions.CustomerException;
import com.module.RepoSitory.CustomerRepo;
import com.module.RepoSitory.UserRepository;
@Service
public class CustomerService {
@Autowired 
CustomerRepo customerRepo;
@Autowired
UserRepository userRepository;
public Customer addCustomer(String password,Customer customer) 
{
	Customer cust = customerRepo.findCustomerByFirstNameAndLastName(customer.getFirstName(),customer.getLastName());		
	if(customer == null){
		User  user = new User();
		user.setRole("customer");
		user.setPassword(password);
		customerRepo.save(customer);
		userRepository.save(user);
	}
	else
		throw new CustomerException("Customer "+ customer.getFirstName()  +" " +customer.getLastName() + " already exists.");
	return customer;
	}
}
