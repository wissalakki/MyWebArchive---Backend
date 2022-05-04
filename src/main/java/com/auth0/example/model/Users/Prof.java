package com.auth0.example.model.Users;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.auth0.example.model.Reclamation;
import com.auth0.example.model.Enums.DomainesExpertise;

public class Prof extends User {
	private List<DomainesExpertise> domainesExpertise = new ArrayList<DomainesExpertise>();

	public Prof(String uid, String email, String displayName, String imageUrl, Collection<Reclamation> reclamations,
			Collection<DomainesExpertise> domainesExpertise) {
		super(uid, email, displayName, imageUrl, reclamations);
		addDomainesExpertise(domainesExpertise);
	}

	public void addDomainesExpertise(Collection<DomainesExpertise> d) {
		d.stream().forEach(domainesExpertise::add);
	}

	// TODO: needs to affect db
	@Override
	public void addReclamations(Collection<Reclamation> r) {
		super.addReclamations(r);
		r.stream().forEach((reclamation) -> reclamation.setUser(this));
	}
}
