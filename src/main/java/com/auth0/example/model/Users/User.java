package com.auth0.example.model.Users;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.auth0.example.model.Reclamation;
import com.auth0.example.model.Enums.PermissionLevel;

public class User {
	private String uid;
	private String email;
	private String displayName;
	private String imageUrl;
	private final List<Reclamation> reclamations = new ArrayList<Reclamation>(); // ommited by lombok

	public User(String uid, String email, String displayName, String imageUrl, Collection<Reclamation> reclamations) {
		setUid(uid);
		setEmail(email);
		setDisplayName(displayName);
		setImageUrl(imageUrl);
		addReclamations(reclamations);
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public List<Reclamation> getReclamations() {
		return reclamations;
	}

	/**
	 * get property from xml databse
	 */
	public static PermissionLevel getDBPermissionLevel(String uid) {
		return null;
	}

	/**
	 * get property from xml database
	 */
	public static Boolean getDBIsTeacher(String uid) {
		return null;
	}

	public void addReclamations(Collection<Reclamation> r) {
		r.stream().forEach(reclamations::add);
	}
}
