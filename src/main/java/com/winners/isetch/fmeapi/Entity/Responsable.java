package com.winners.isetch.fmeapi.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Responsable {
	
	@Id
	private int id;
	 
	 	private String nom;
	 	private String prenom;
	 	private String urlPhoto;
	 	private String dateDeNaissance;
	 	private String nationalite;
	 	private String adresse;
	 	private String region;
	 	private int cin;
	 	private int numPasseport;
	 	private int numTel;
	 	private String email;
	 	private String fonction;
	 	private String  commentaire;
	 	
	 	
	 	public Responsable() {}


		public Responsable(int id, String nom, String prenom, String urlPhoto, String dateDeNaissance,
				String nationalite, String adresse, String region, int cin, int numPasseport, int numTel, String email,
				String fonction, String commentaire) {
			super();
			this.id = id;
			this.nom = nom;
			this.prenom = prenom;
			this.urlPhoto = urlPhoto;
			this.dateDeNaissance = dateDeNaissance;
			this.nationalite = nationalite;
			this.adresse = adresse;
			this.region = region;
			this.cin = cin;
			this.numPasseport = numPasseport;
			this.numTel = numTel;
			this.email = email;
			this.fonction = fonction;
			this.commentaire = commentaire;
		}


		public int getId() {
			return id;
		}


		public void setId(int id) {
			this.id = id;
		}


		public String getNom() {
			return nom;
		}


		public void setNom(String nom) {
			this.nom = nom;
		}


		public String getPrenom() {
			return prenom;
		}


		public void setPrenom(String prenom) {
			this.prenom = prenom;
		}


		public String getUrlPhoto() {
			return urlPhoto;
		}


		public void setUrlPhoto(String urlPhoto) {
			this.urlPhoto = urlPhoto;
		}


		public String getDateDeNaissance() {
			return dateDeNaissance;
		}


		public void setDateDeNaissance(String dateDeNaissance) {
			this.dateDeNaissance = dateDeNaissance;
		}


		public String getNationalite() {
			return nationalite;
		}


		public void setNationalite(String nationalite) {
			this.nationalite = nationalite;
		}


		public String getAdresse() {
			return adresse;
		}


		public void setAdresse(String adresse) {
			this.adresse = adresse;
		}


		public String getRegion() {
			return region;
		}


		public void setRegion(String region) {
			this.region = region;
		}


		public int getCin() {
			return cin;
		}


		public void setCin(int cin) {
			this.cin = cin;
		}


		public int getNumPasseport() {
			return numPasseport;
		}


		public void setNumPasseport(int numPasseport) {
			this.numPasseport = numPasseport;
		}


		public int getNumTel() {
			return numTel;
		}


		public void setNumTel(int numTel) {
			this.numTel = numTel;
		}


		public String getEmail() {
			return email;
		}


		public void setEmail(String email) {
			this.email = email;
		}


		public String getFonction() {
			return fonction;
		}


		public void setFonction(String fonction) {
			this.fonction = fonction;
		}


		public String getCommentaire() {
			return commentaire;
		}


		public void setCommentaire(String commentaire) {
			this.commentaire = commentaire;
		}


		@Override
		public String toString() {
			return "Responsable [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", urlPhoto=" + urlPhoto
					+ ", dateDeNaissance=" + dateDeNaissance + ", nationalite=" + nationalite + ", adresse=" + adresse
					+ ", region=" + region + ", cin=" + cin + ", numPasseport=" + numPasseport + ", numTel=" + numTel
					+ ", email=" + email + ", fonction=" + fonction + ", commentaire=" + commentaire + "]";
		}

		
}
