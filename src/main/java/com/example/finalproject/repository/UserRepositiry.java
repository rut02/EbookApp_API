package com.example.finalproject.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.finalproject.model.User;

@Repository
public interface UserRepositiry  extends JpaRepository<User, Long>{
	
	User findById(long id);
	User findByEmail(String email);
	User findByUsername(String username);
	User findByEmailAndPassword(String email , String password);
	Optional<User> findOptionalById(long id);
}
