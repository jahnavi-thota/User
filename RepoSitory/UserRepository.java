package com.module.RepoSitory;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.module.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	@Query("select u from User u where u.userId= ?1 and u.password= ?2")
  public Optional<User> findUserByIdAndPassword(int id,String password);
  public Optional<User> findById(int id);
	



}
