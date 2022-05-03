package com.auth0.example.model;

import java.time.LocalDate;

import com.auth0.example.model.Enums.StatusReclamation;
import com.auth0.example.model.Users.Admin;
import com.auth0.example.model.Users.User;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Reclamation {
	private LocalDate date;
	private String description;
	private User user;
	private Admin admin;
	private StatusReclamation statusReclamation;
}
