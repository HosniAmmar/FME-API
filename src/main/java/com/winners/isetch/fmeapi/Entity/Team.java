package com.winners.isetch.fmeapi.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Team {
	@Id
    private int id;
    private String nom;
    private String urlLogo;
    private String adresse;
    private String region;
    private String dateDeCreation;
    private String nomDePresident;
    private String prenomDePresident;
    private int numtelDePresident;
    private String nomDeSecretaireGeneral;
    private String prenomDeSecretaireGeneral;
    private int numTelDeSecretaireGeneral;
    private String email;
    private String numTel;
    private String numFax;
    private String terrainPrincipale;
    private String urlPhoto;
    private String division;
    private String commentaire;

    public Team() {
    }

	public Team(int id, String nom, String urlLogo, String adresse, String region, String dateDeCreation, String nomDePresident,
			String prenomDePresident, int numtelDePresident, String nomDeSecretaireGeneral,
			String prenomDeSecretaireGeneral, int numTelDeSecretaireGeneral, String email, String numTel, String numFax,
			String terrainPrincipale, String urlPhoto, String division, String commentaire) {
		super();
		this.nom=nom;
		this.id = id;
		this.urlLogo = urlLogo;
		this.adresse = adresse;
		this.region = region;
		this.dateDeCreation = dateDeCreation;
		this.nomDePresident = nomDePresident;
		this.prenomDePresident = prenomDePresident;
		this.numtelDePresident = numtelDePresident;
		this.nomDeSecretaireGeneral = nomDeSecretaireGeneral;
		this.prenomDeSecretaireGeneral = prenomDeSecretaireGeneral;
		this.numTelDeSecretaireGeneral = numTelDeSecretaireGeneral;
		this.email = email;
		this.numTel = numTel;
		this.numFax = numFax;
		this.terrainPrincipale = terrainPrincipale;
		this.urlPhoto = urlPhoto;
		this.division = division;
		this.commentaire = commentaire;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUrlLogo() {
		return urlLogo;
	}

	public void setUrlLogo(String urlLogo) {
		this.urlLogo = urlLogo;
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

	public String getDateDeCreation() {
		return dateDeCreation;
	}

	public void setDateDeCreation(String dateDeCreation) {
		this.dateDeCreation = dateDeCreation;
	}

	public String getNomDePresident() {
		return nomDePresident;
	}

	public void setNomDePresident(String nomDePresident) {
		this.nomDePresident = nomDePresident;
	}

	public String getPrenomDePresident() {
		return prenomDePresident;
	}

	public void setPrenomDePresident(String prenomDePresident) {
		this.prenomDePresident = prenomDePresident;
	}

	public int getNumtelDePresident() {
		return numtelDePresident;
	}

	public void setNumtelDePresident(int numtelDePresident) {
		this.numtelDePresident = numtelDePresident;
	}

	public String getNomDeSecretaireGeneral() {
		return nomDeSecretaireGeneral;
	}

	public void setNomDeSecretaireGeneral(String nomDeSecretaireGeneral) {
		this.nomDeSecretaireGeneral = nomDeSecretaireGeneral;
	}

	public String getPrenomDeSecretaireGeneral() {
		return prenomDeSecretaireGeneral;
	}

	public void setPrenomDeSecretaireGeneral(String prenomDeSecretaireGeneral) {
		this.prenomDeSecretaireGeneral = prenomDeSecretaireGeneral;
	}

	public int getNumTelDeSecretaireGeneral() {
		return numTelDeSecretaireGeneral;
	}

	public void setNumTelDeSecretaireGeneral(int numTelDeSecretaireGeneral) {
		this.numTelDeSecretaireGeneral = numTelDeSecretaireGeneral;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNumTel() {
		return numTel;
	}

	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}

	public String getNumFax() {
		return numFax;
	}

	public void setNumFax(String numFax) {
		this.numFax = numFax;
	}

	public String getTerrainPrincipale() {
		return terrainPrincipale;
	}

	public void setTerrainPrincipale(String terrainPrincipale) {
		this.terrainPrincipale = terrainPrincipale;
	}

	public String getUrlPhoto() {
		return urlPhoto;
	}

	public void setUrlPhoto(String urlPhoto) {
		this.urlPhoto = urlPhoto;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	@Override
	public String toString() {
		return "Team [id=" + id +", nom =" + nom + ", urlLogo=" + urlLogo + ", adresse=" + adresse + ", region=" + region
				+ ", dateDeCreation=" + dateDeCreation + ", nomDePresident=" + nomDePresident + ", prenomDePresident="
				+ prenomDePresident + ", numtelDePresident=" + numtelDePresident + ", nomDeSecretaireGeneral="
				+ nomDeSecretaireGeneral + ", prenomDeSecretaireGeneral=" + prenomDeSecretaireGeneral
				+ ", numTelDeSecretaireGeneral=" + numTelDeSecretaireGeneral + ", email=" + email + ", numTel=" + numTel
				+ ", numFax=" + numFax + ", terrainPrincipale=" + terrainPrincipale + ", urlPhoto=" + urlPhoto
				+ ", division=" + division + ", commentaire=" + commentaire + "]";
	}

    
}