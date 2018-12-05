
package com.winners.isetch.fmeapi.Entity;

import javax.persistence.Id;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Matchee {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;

	private int idEquipe1;
	private int idEquipe2;
	private String date;
	private String heure;
	private String place;
	private int idArbitre1;
	private int idArbitre2;
	private int idArbitre3;
	private int idCommissaire;
	
	
	public Matchee() {
	}

	public Matchee(int id, int idEquipe1, int idEquipe2, String date, String heure, String place, int idArbitre1,
			int idArbitre2, int idArbitre3, int idCommissaire) {
		this.id = id;
		this.idEquipe1 = idEquipe1;
		this.idEquipe2 = idEquipe2;
		this.date = date;
		this.heure = heure;
		this.place = place;
		this.idArbitre1 = idArbitre1;
		this.idArbitre2 = idArbitre2;
		this.idArbitre3 = idArbitre3;
		this.idCommissaire = idCommissaire;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdEquipe1() {
		return idEquipe1;
	}

	public void setIdEquipe1(int idEquipe1) {
		this.idEquipe1 = idEquipe1;
	}

	public int getIdEquipe2() {
		return idEquipe2;
	}

	public void setIdEquipe2(int idEquipe2) {
		this.idEquipe2 = idEquipe2;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getHeure() {
		return heure;
	}

	public void setHeure(String heure) {
		this.heure = heure;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public int getIdArbitre1() {
		return idArbitre1;
	}

	public void setIdArbitre1(int idArbitre1) {
		this.idArbitre1 = idArbitre1;
	}

	public int getIdArbitre2() {
		return idArbitre2;
	}

	public void setIdArbitre2(int idArbitre2) {
		this.idArbitre2 = idArbitre2;
	}

	public int getIdArbitre3() {
		return idArbitre3;
	}

	public void setIdArbitre3(int idArbitre3) {
		this.idArbitre3 = idArbitre3;
	}

	public int getIdCommissaire() {
		return idCommissaire;
	}

	public void setIdCommissaire(int idCommissaire) {
		this.idCommissaire = idCommissaire;
	}

	@Override
	public String toString() {
		return "Matchee [id=" + id + ", idEquipe1=" + idEquipe1 + ", idEquipe2=" + idEquipe2 + ", date=" + date
				+ ", heure=" + heure + ", place=" + place + ", idArbitre1=" + idArbitre1 + ", idArbitre2=" + idArbitre2
				+ ", idArbitre3=" + idArbitre3 + ", idCommissaire=" + idCommissaire + "]";
	}

	
}
