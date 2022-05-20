package com.auth0.example.model.Projects;

import java.util.ArrayList;
import java.util.List;

import com.auth0.example.model.Comments;
import com.auth0.example.model.Enums.StatusProjet;
import com.auth0.example.model.Enums.TypeProjet;
import com.auth0.example.model.Users.Etudiant;
import com.auth0.example.model.Users.Prof;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Project {
	private Long uid;
	private String titre;
	private int note;
	private String description ;
	private List<String> motsCles = new ArrayList<String>();
	private List<Version> versions = new ArrayList<Version>();
	private List<Etudiant> etudiants = new ArrayList<Etudiant>();
	private List<Comments> comments = new ArrayList<Comments>();
	//a discuter
	private Prof supervisor;
	private StatusProjet projectStatus;
	private TypeProjet projectType;




}
