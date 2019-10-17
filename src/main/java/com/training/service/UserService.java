package com.training.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.training.model.User;

public interface UserService {

	List<User> getAllUsers();

	void deleteUser(String userId);
	
	void addUser(User user);
	
	User getUserById(String userId);

	UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
