package com.app.attendence.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.app.attendence.entity.User;
import com.app.attendence.repository.UserRepository;
import com.app.attendence.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private final String INVALID_USER_NAME = "Invalid userName.";
	private final String INVALID_PASSWORD = "Invalid password.";
	private final String LOGIN_SUCCESSFUL = "Login successful!";
	
	private UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User createUser(User user) {
		return userRepository.save(user);
	}
	
	@Override
	public User updateUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User findUserByUserId(Long userId) {
		return userRepository.findById(userId).get();
	}
	
	@Override
	public Object findUserByUserName(String userName) {
		return CollectionUtils.isEmpty(userRepository.findUserByUserName(userName)) ? INVALID_USER_NAME : userRepository.findUserByUserName(userName).get(0);
	}

	@Override
	public String validateUser(String userName, String password) {
		
		if(userRepository.validateUserName(userName) == null) {
			return INVALID_USER_NAME;
		} 
		
		if(userRepository.validatePassword(password) == null) {
			return INVALID_PASSWORD;
		} 
		
		if(userRepository.validateUser(userName, password) == null) {
			return INVALID_PASSWORD;
		}
		
		return LOGIN_SUCCESSFUL;
	}

}
