package com.auth0.example.model.Projects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Version {
	@NonNull
	private int number;
	@NonNull
	private String commentaire;
	@NonNull
	private String contenu;
	@NonNull
	private Long projectid;
}
