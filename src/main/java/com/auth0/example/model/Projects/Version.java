package com.auth0.example.model.Projects;

import com.auth0.example.model.Comments;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Version {
	public String uid;
	public String publisher;
	public String numero;
	public String description;
	public Comments comments;
	public String contenu;



}
