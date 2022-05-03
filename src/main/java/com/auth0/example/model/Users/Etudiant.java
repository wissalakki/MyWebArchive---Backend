package com.auth0.example.model.Users;

import java.util.Collection;

import com.auth0.example.model.Reclamation;
import com.auth0.example.model.Enums.NiveauEtudes;

public class Etudiant extends User {
	private String mle;
	private NiveauEtudes niveauEtudes;

	public Etudiant(String uid, String email, String displayName, String imageUrl, Collection<Reclamation> reclamations,
			String mle) {
		super(uid, email, displayName, imageUrl, reclamations);
		this.mle = mle;
		this.niveauEtudes = NiveauEtudes.BAC3;
	}

	public Etudiant(String uid, String email, String displayName, String imageUrl, Collection<Reclamation> reclamations,
			String mle, NiveauEtudes niveauEtudes) {
		super(uid, email, displayName, imageUrl, reclamations);
		this.mle = mle;
		this.niveauEtudes = NiveauEtudes.BAC3;
		this.niveauEtudes = niveauEtudes;
	}

	@Override
	public void addReclamations(Collection<Reclamation> r) {
		super.addReclamations(r);
		r.stream().forEach((reclamation) -> reclamation.setUser(this));
	}
}
