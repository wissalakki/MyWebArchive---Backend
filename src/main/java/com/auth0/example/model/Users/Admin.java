package com.auth0.example.model.Users;

import java.util.Collection;

import com.auth0.example.model.Reclamation;
import com.auth0.example.model.Enums.StatusReclamation;

public class Admin extends User {
	public Admin(String uid, String email, String displayName, String imageUrl, Collection<Reclamation> reclamations,
			String mle) {
		super(uid, email, displayName, imageUrl, reclamations);
	}

	// TODO: needs to affect db
	@Override
	public void addReclamations(Collection<Reclamation> r) {
		super.addReclamations(r);
		r.stream().forEach((reclamation) -> reclamation.setAdmin(this));
	}

	// TODO: needs to affect db
	public boolean reglerReclamation(Reclamation r) {
		if (!this.getReclamations().contains(r) || r.getStatusReclamation().equals(StatusReclamation.REGLEE)) {
			return false;
		}
		r.setStatusReclamation(StatusReclamation.REGLEE);
		return true;
	}
}
