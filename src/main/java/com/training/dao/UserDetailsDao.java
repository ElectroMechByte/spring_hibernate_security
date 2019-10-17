package com.training.dao;

import java.util.List;

import com.training.model.User;

public interface UserDetailsDao {

	List<User> getAllUsers();

	void deleteUser(String userId);
	
	void addUser(User user);
	
	User getUserById(String userId);
	
	User findUserByUsername(String username);
}
