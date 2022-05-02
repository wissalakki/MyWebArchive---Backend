package com.auth0.example.web;

import java.util.List;

import com.auth0.example.model.User;

import org.springframework.stereotype.Service;

@Service
public class UserService {
	/**
	 * get user by id from auth0 service
	 * 
	 * @param id
	 * @return user
	 */
	public User getUserById(Long id) {
		return null;
	}

	/**
	 * get a list of users from auth0 service
	 * 
	 * @return a list of users
	 */
	public List<User> getAllUsers() {
		return null;
	}
}
