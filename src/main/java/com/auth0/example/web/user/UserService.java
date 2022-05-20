package com.auth0.example.web.user;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.auth0.example.model.Users.User;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

	private final RestTemplate restTemplate = new RestTemplate();

	public String getUserType(String user){
		String url = "http://localhost:3000/api/users/gettype";
		ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

		String type = response.getBody();

		return type;
	}


	public List<User> getAllUsers() {
		String url = "http://localhost:3000/users/getAll";
		ResponseEntity<User[]> response = restTemplate.getForEntity(url, User[].class);

		User[] user = response.getBody();

		return Arrays.asList(user);
	}

	public User[] getUserById(String uid) {
		String url = "http://localhost:3000/users/getuser/{uid}";
		ResponseEntity<User[]> response = restTemplate.getForEntity(url, User[].class);

		User[] user = response.getBody();

		return user;
	}

	public void addUser(User user) {
		List<User> newUsers = new ArrayList<>();
		newUsers.add(user);

		restTemplate.postForObject("http://localhost:3000/users/adduser", newUsers, ResponseEntity.class);

	}

	/*
	public void updateUser(String uid) {
		String url = "http://localhost:8080/api/users/updateuser/{uid}";
		HttpEntity<User> entity = new HttpEntity<>(Body.valueof(user));
		this.restTemplate.put(url, entity, uid);
	}
	*/

	public void deleteUser(String uid) {
		String url = "http://localhost:3000/users/deleteuser/{uid}";

		this.restTemplate.delete(url, uid);
	}

}




