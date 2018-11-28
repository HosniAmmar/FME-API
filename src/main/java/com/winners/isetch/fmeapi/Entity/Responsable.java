package com.winners.isetch.fmeapi.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Responsable extends Personne {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
	private String fonction;
	private int actualTeamId;

	public Responsable() {
	}

	public Responsable(String firstName, String lastName, String phone, String natIdNum, String address,
			String mailAddress, double height, double weight, String birthdate, String nationality, String photoUrl,
			String region, String city, String numpasseport, String comment, int id, String fonction,
			int actualTeamId) {
		super(firstName, lastName, phone, natIdNum, address, mailAddress, height, weight, birthdate, nationality,
				photoUrl, region, city, numpasseport, comment);
		this.id = id;
		this.fonction = fonction;
		this.actualTeamId = actualTeamId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFonction() {
		return fonction;
	}

	public void setFonction(String fonction) {
		this.fonction = fonction;
	}

	public int getActualTeamId() {
		return actualTeamId;
	}

	public void setActualTeamId(int actualTeamId) {
		this.actualTeamId = actualTeamId;
	}

	@Override
	public String toString() {
		return "Responsable [id=" + id + ", fonction=" + fonction + ", actualTeamId=" + actualTeamId + ", "
				+ super.toString() + "]";
	}

	
}
