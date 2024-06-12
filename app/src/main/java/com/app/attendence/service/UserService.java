package com.app.attendence.service;

import java.util.List;

import com.app.attendence.entity.User;

public interface UserService {

	List<User> getAllUsers();
	
	User createUser(User user);

	User findUserByUserId(Long userId);

	String validateUser(String userName, String password);

	Object findUserByUserName(String userName);

	User updateUser(User user);
}
