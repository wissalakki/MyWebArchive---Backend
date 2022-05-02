package com.auth0.example.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.auth0.example.model.Enums.PermissionLevel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
public class User {
	@NonNull
	private String uid;
	@NonNull
	private String email;
	private String displayName;
	private String imageUrl;
	private final List<Reclamation> reclamations = new ArrayList<Reclamation>(); // ommited by lombok because its final
																																								// and initialized

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
