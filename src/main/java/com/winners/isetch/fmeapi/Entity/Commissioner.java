package com.winners.isetch.fmeapi.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Commissioner {
	 @Id
	    private int id;
	 
	 	private int badge;
	 	private String nom;
	 	private String urlPhoto;
	 	private String dateDeNaissance;
	 	private String nationalite;
	 	private String adresse;
	 	private String region;
	 	private int cin;
	 	private int numPasseport;
	 	private int numtel;
	 	private String mail;
	 	private double poids;
	 	private double taille;
	 	private String commentaire;
	 	
	 	 
	 	public Commissioner() {}


		public Commissioner(int id, int badge, String nom, String urlPhoto, String dateDeNaissance, String nationalite,
				String adresse, String region, int cin, int numPasseport, int numtel, String mail, double poids,
				double taille, String commentaire) {
			this.id = id;
			this.badge = badge;
			this.nom = nom;
			this.urlPhoto = urlPhoto;
			this.dateDeNaissance = dateDeNaissance;
			this.nationalite = nationalite;
			this.adresse = adresse;
			this.region = region;
			this.cin = cin;
			this.numPasseport = numPasseport;
			this.numtel = numtel;
			this.mail = mail;
			this.poids = poids;
			this.taille = taille;
			this.commentaire = commentaire;
		}


		public int getId() {
			return id;
		}


		public void setId(int id) {
			this.id = id;
		}


		public int getBadge() {
			return badge;
		}


		public void setBadge(int badge) {
			this.badge = badge;
		}


		public String getNom() {
			return nom;
		}


		public void setNom(String nom) {
			this.nom = nom;
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


		public int getNumtel() {
			return numtel;
		}


		public void setNumtel(int numtel) {
			this.numtel = numtel;
		}


		public String getMail() {
			return mail;
		}


		public void setMail(String mail) {
			this.mail = mail;
		}


		public double getPoids() {
			return poids;
		}


		public void setPoids(double poids) {
			this.poids = poids;
		}


		public double getTaille() {
			return taille;
		}


		public void setTaille(double taille) {
			this.taille = taille;
		}


		public String getCommentaire() {
			return commentaire;
		}


		public void setCommentaire(String commentaire) {
			this.commentaire = commentaire;
		}


		@Override
		public String toString() {
			return "Referee [id=" + id + ", badge=" + badge + ", nom=" + nom + ", urlPhoto=" + urlPhoto
					+ ", dateDeNaissance=" + dateDeNaissance + ", nationalite=" + nationalite + ", adresse=" + adresse
					+ ", region=" + region + ", cin=" + cin + ", numPasseport=" + numPasseport + ", numtel=" + numtel
					+ ", mail=" + mail + ", poids=" + poids + ", taille=" + taille + ", commentaire=" + commentaire
					+ "]";
		}
	 	
		

}