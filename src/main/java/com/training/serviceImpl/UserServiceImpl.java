package com.training.serviceImpl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.training.dao.UserDetailsDao;
import com.training.model.User;
import com.training.service.UserService;

@Service(value = "userDetailService")
public class UserServiceImpl implements UserDetailsService,UserService {

	@Autowired
	private UserDetailsDao userDao;

	@Transactional
	public List<User> getAllUsers() {

		return userDao.getAllUsers();
	}

	@Transactional
	public void deleteUser(String userId) {
		userDao.deleteUser(userId);

	}

	@Transactional
	public void addUser(User user) {
		userDao.addUser(user);
	}

	@Transactional
	public User getUserById(String userId) {
		return userDao.getUserById(userId);
	}

	@Transactional(readOnly = true)
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userDao.findUserByUsername(username);

		if(user == null){
			throw new UsernameNotFoundException("Invalid username or password.Please Check");
		}
		return new org.springframework.security.core.userdetails.User(user.getEmailId(), user.getPassword(), getAuthority());
	}
	
	private List<SimpleGrantedAuthority> getAuthority() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
	}

	}

