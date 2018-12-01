package com.winners.isetch.fmeapi.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Player extends Personne{

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
	private String licenseNumber;
	private int squadNumber;
	private int actualTeamId;
	private int previousTeamId;
	private String category;

	public Player() {
		
	}

	public Player(String firstName, String lastName, String phone, String natIdNum, String address, String mailAddress,
			double height, double weight, String birthdate, String nationality, String photoUrl, String region,
			String city, String numpasseport, String comment, int id, String licenseNumber, int squadNumber,
			int actualTeamId, int previousTeamId, String category) {
		super(firstName, lastName, phone, natIdNum, address, mailAddress, height, weight, birthdate, nationality,
				photoUrl, region, city, numpasseport, comment);
		this.id = id;
		this.licenseNumber = licenseNumber;
		this.squadNumber = squadNumber;
		this.actualTeamId = actualTeamId;
		this.previousTeamId = previousTeamId;
		this.category = category;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLicenseNumber() {
		return licenseNumber;
	}

	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}

	public int getSquadNumber() {
		return squadNumber;
	}

	public void setSquadNumber(int squadNumber) {
		this.squadNumber = squadNumber;
	}

	public int getActualTeamId() {
		return actualTeamId;
	}

	public void setActualTeamId(int actualTeamId) {
		this.actualTeamId = actualTeamId;
	}

	public int getPreviousTeamId() {
		return previousTeamId;
	}

	public void setPreviousTeamId(int previousTeamId) {
		this.previousTeamId = previousTeamId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Player [id=" + id + ", licenseNumber=" + licenseNumber + ", squadNumber=" + squadNumber
				+ ", actualTeamId=" + actualTeamId + ", previousTeamId=" + previousTeamId + ", category=" + category
				+ ", " + super.toString() + "]";
	}

	
}