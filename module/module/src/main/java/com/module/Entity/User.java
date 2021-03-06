package com.module.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name="User_table") 

public class User {
	@Id
	@SequenceGenerator(name="user_sequence",allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO,generator = "user_sequence")
	private int userId;
	@NotNull
	private String password;
	private String userName;
	private String role;
	public User() {

	}
	 
	
	public User(String password, String userName, String role) {
		super();
		this.password = password;
		this.userName = userName;
		this.role = role;
	}
	

	public User(String password, String userName) {
		super();
		this.password = password;
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", password=" + password + ", role=" + role + "]";
	}
}
