package com.module.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.module.Entity.User;

import com.module.Service.UserService;
@SpringBootTest
public class UserTest {
User user;
@Autowired
UserService userService;
//  @Test
 void testAddUser() 
 {
	 User user = new User("test","admin");
	 User user2 = userService.addUser(user);
	 System.out.print(user2);
 }
 //  @Test
 void testRemoveUser() 
 {
	 User user = new User("test","admin");
	 userService.deleteUser(user.getUserId());
 }
 // @Test
 void testUser() 
 {
	 User user = new User("priya","customer");
	 userService.addUser(user);
	 User user2 = userService.validateUser("admin", user);
 }
}
