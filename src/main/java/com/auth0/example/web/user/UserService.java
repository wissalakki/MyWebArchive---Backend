package com.auth0.example.web.user;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.auth0.example.model.Users.User;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {
	
	private final RestTemplate restTemplate = new RestTemplate();
	
	public List<User> getAllUsers() {
		String url="http://localhost:8000/api/users/getAll";
		ResponseEntity<User[]> response = restTemplate.getForEntity(url, User[].class);
		
		User[] user = response.getBody();
		
		return Arrays.asList(user);
	}
	
	public User[] getUserById(String uid) {
		String url="http://localhost:8000/api/users/getuser/{uid}";
		ResponseEntity<User[]> response = restTemplate.getForEntity(url, User[].class, uid);
		
		User[] user = response.getBody();
		
		return user;
	}
	
	public void addUser(User user) {
		List<User> newUsers = new ArrayList<>();
		newUsers.add(user);
		
		restTemplate.postForObject("http://localhost:8080/api/users/adduser", newUsers, ResponseEntity.class);

	}
	
	/*
	public void updateUser(String uid) {
		String url = "http://localhost:8080/api/users/updateuser/{uid}";
		HttpEntity<User> entity = new HttpEntity<>(Body.valueof(user));
		this.restTemplate.put(url, entity, uid);
	}
	*/
	
	public void deleteUser(String uid) {
		String url = "http://localhost:8080/api/users/deleteuser/{uid}";
		
		this.restTemplate.delete(url,uid);
	}
	
	
	
	
}
