package com.example.finalproject.service.impl;

import java.util.List;

import com.example.finalproject.model.User;

public interface IUser {
	
	List<User> getAllUsers();
	User findById(long id);
	User findByEmail(String email);
	User findByEmailAndPassword(String email , String password);
	User save(User us);
	void deleteById(long id);
}
