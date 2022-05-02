package com.auth0.example.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Reclamation {
	private LocalDate date;
	private String description;
	private User user;
}
