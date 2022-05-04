package com.auth0.example.model.Projects;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.auth0.example.model.Users.Groupe;

public class Project {
	private String titre;
	private int note;
	private List<String> motsCles = new ArrayList<String>();
	private List<Version> versions = new ArrayList<Version>();
	private List<Groupe> groupes = new ArrayList<Groupe>();

	public Project(String titre, Collection<String> motsCles) {
		this.titre = titre;
		this.addMotCles(motsCles);
	}

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
