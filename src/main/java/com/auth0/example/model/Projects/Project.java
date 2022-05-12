package com.auth0.example.model.Projects;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.auth0.example.model.Enums.StatusProjet;
import com.auth0.example.model.Enums.TypeProjet;
import com.auth0.example.model.Users.Groupe;
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
	private String titre;
	private int note;
	public Project(String titre, int note) {
		this.titre = titre;
		this.note =note;
	}

	private List<String> motsCles = new ArrayList<String>();
	private List<Version> versions = new ArrayList<Version>();
	private List<Groupe> groupes = new ArrayList<Groupe>();
	//a discuter
	private Prof supervisor;
	private StatusProjet projectStatus;
	private TypeProjet projectType;



	public void addMotCles(Collection<String> m) {
		m.stream().forEach(motsCles::add);
	}

	public void addVersion(Version version) {
		versions.add(version);
	}

	public void addGroupe(Groupe groupe) {
		groupes.add(groupe);
	}
}
