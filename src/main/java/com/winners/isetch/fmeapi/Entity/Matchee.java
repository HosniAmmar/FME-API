
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
	private int idArbitre1;
	private int idArbitre2;
	private int idArbitre3;
	private int idCommissaire;
	
	public Matchee() {}
	
	public Matchee(int id, int idEquipe1, int idEquipe2, String date, String heure, int idArbitre1, int idArbitre2,
			int idArbitre3, int idCommissaire) {
		super();
		this.id = id;
		this.idEquipe1 = idEquipe1;
		this.idEquipe2 = idEquipe2;
		this.date = date;
		this.heure = heure;
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

	public int getidEquipe1() {
		return idEquipe1;
	}

	public void setidEquipe1(int idEquipe1) {
		this.idEquipe1 = idEquipe1;
	}

	public int getidEquipe2() {
		return idEquipe2;
	}

	public void setidEquipe2(int idEquipe2) {
		this.idEquipe2 = idEquipe2;
	}

	public String getdate() {
		return date;
	}

	public void setdate(String date) {
		this.date = date;
	}

	public String getheure() {
		return heure;
	}

	public void setheure(String heure) {
		this.heure = heure;
	}

	public int getidArbitre1() {
		return idArbitre1;
	}

	public void setidArbitre1(int idArbitre1) {
		this.idArbitre1 = idArbitre1;
	}

	public int getidArbitre2() {
		return idArbitre2;
	}

	public void setidArbitre2(int idArbitre2) {
		this.idArbitre2 = idArbitre2;
	}

	public int getidArbitre3() {
		return idArbitre3;
	}

	public void setidArbitre3(int idArbitre3) {
		this.idArbitre3 = idArbitre3;
	}

	public int getidCommissaire() {
		return idCommissaire;
	}

	public void setidCommissaire(int idCommissaire) {
		this.idCommissaire = idCommissaire;
	}

	@Override
	public String toString() {
		return "Match [id=" + id + ", idEquipe1=" + idEquipe1 + ", idEquipe2=" + idEquipe2 + ", date=" + date
				+ ", heure=" + heure + ", idArbitre1=" + idArbitre1 + ", idArbitre2=" + idArbitre2 + ", idArbitre3="
				+ idArbitre3 + ", idCommissaire=" + idCommissaire + "]";
	}
	
	
		
}
