package com.app.attendence.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.attendence.entity.User;
import com.app.attendence.service.UserService;

@RestController
public class UserController {

	private UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@PostMapping("/users")
	public User createUser(@RequestBody User user) {
		return userService.createUser(user);
		
	}
	
	@PutMapping("/users")
	public User updateUser(@RequestBody User user) {
		return userService.updateUser(user);
		
	}
	
	@GetMapping("/users/{userId}") 
	public User getUserById(@PathVariable("userId") Long userId) {
		return userService.findUserByUserId(userId);
	}
	
	@GetMapping("/users/userName/{userName}") 
	public Object getUserById(@PathVariable("userName") String userName) {
		return userService.findUserByUserName(userName);
	}
	
	@GetMapping("/users/userName/{userName}/password/{password}") 
	public String validateUser(@PathVariable("userName") String userName, @PathVariable("password") String password) {
		return userService.validateUser(userName, password);
	}

}
