package com.winners.isetch.fmeapi.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Player {

    @Id
    private int id;

    private String numLicense;
    private String categorie;
    private String nom;
    private String prenom;
    private String urlPhoto;
    private String dateDaNaissance;
    private String nationalite;
    private String adresse;
    private int cin;
    private int numPasseport;
    private String numTel;
    private String email;
    private double taille;
    private double poids;
    private int idEquipe;
    private int numMaillot;
    private String commentaire;
    
    public Player() {
    }

	public Player(int id, String numLicense, String categorie, String nom, String prenom, String urlPhoto,
			String dateDaNaissance, String nationalite, String adresse, int cin, int numPasseport, String numTel,
			String email, double taille, double poids, int idEquipe, int numMaillot, String commentaire) {
		super();
		this.id = id;
		this.numLicense = numLicense;
		this.categorie = categorie;
		this.nom = nom;
		this.prenom = prenom;
		this.urlPhoto = urlPhoto;
		this.dateDaNaissance = dateDaNaissance;
		this.nationalite = nationalite;
		this.adresse = adresse;
		this.cin = cin;
		this.numPasseport = numPasseport;
		this.numTel = numTel;
		this.email = email;
		this.taille = taille;
		this.poids = poids;
		this.idEquipe = idEquipe;
		this.numMaillot = numMaillot;
		this.commentaire = commentaire;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumLicense() {
		return numLicense;
	}

	public void setNumLicense(String numLicense) {
		this.numLicense = numLicense;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
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

	public String getDateDaNaissance() {
		return dateDaNaissance;
	}

	public void setDateDaNaissance(String dateDaNaissance) {
		this.dateDaNaissance = dateDaNaissance;
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

	public String getNumTel() {
		return numTel;
	}

	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getTaille() {
		return taille;
	}

	public void setTaille(double taille) {
		this.taille = taille;
	}

	public double getPoids() {
		return poids;
	}

	public void setPoids(double poids) {
		this.poids = poids;
	}

	public int getIdEquipe() {
		return idEquipe;
	}

	public void setIdEquipe(int idEquipe) {
		this.idEquipe = idEquipe;
	}

	public int getNumMaillot() {
		return numMaillot;
	}

	public void setNumMaillot(int numMaillot) {
		this.numMaillot = numMaillot;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	@Override
	public String toString() {
		return "Player [id=" + id + ", numLicense=" + numLicense + ", categorie=" + categorie + ", nom=" + nom
				+ ", prenom=" + prenom + ", urlPhoto=" + urlPhoto + ", dateDaNaissance=" + dateDaNaissance
				+ ", nationalite=" + nationalite + ", adresse=" + adresse + ", cin=" + cin + ", numPasseport="
				+ numPasseport + ", numTel=" + numTel + ", email=" + email + ", taille=" + taille + ", poids=" + poids
				+ ", NomEquipe=" + idEquipe + ", numMaillot=" + numMaillot + ", commentaire=" + commentaire + "]";
	}

    
}