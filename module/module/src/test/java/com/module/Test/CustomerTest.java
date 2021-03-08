package com.module.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.module.Entity.Customer;
import com.module.Service.CustomerService;
@SpringBootTest
public class CustomerTest {
Customer customer;
@Autowired
CustomerService customerService;
//  @Test
void testAddCustomer() 
{
	Customer customer = new Customer("Janu","T","testcust@gmail.com","test12442627","testing");
}

}
