package com.module.RepoSitory;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.module.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	

  public Optional<User> findById(int id);
  @Query("select u from User u where u.userName= ?1 and u.password= ?2")
public Optional<User> findUserByIdAndPassword(String userName, String password);
  @Query("select u from User u where u.userName= ?1")
  public Optional<User> findByUsername(String userName);
	



}
