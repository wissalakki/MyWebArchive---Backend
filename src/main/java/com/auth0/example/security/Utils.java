package com.auth0.example.security;

import org.springframework.http.MediaType;
import java.util.Collections;

import com.auth0.example.web.JsonResponseFormat.Response;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class Utils {
	private final RestTemplate restTemplate;

	public Utils(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}

	public String getUser(String authHeader) {
		String url = "https://dev--r9nce6d.us.auth0.com/userinfo";
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.set("Authorization", authHeader);
		HttpEntity request = new HttpEntity(headers);
		ResponseEntity<Response> response = this.restTemplate.exchange(url, HttpMethod.GET, request, Response.class, 1);
		return response.getBody().getEmail();
	}
}
