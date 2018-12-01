package com.winners.isetch.fmeapi.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Commissioner extends Personne {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
	private int badge;

	;

	public Commissioner() {
	
	}

	

	public Commissioner(String firstName, String lastName, String phone, String natIdNum, String address,
			String mailAddress, double height, double weight, String birthdate, String nationality, String photoUrl,
			String region, String city, String numpasseport, String comment, int id, int badge) {
		super(firstName, lastName, phone, natIdNum, address, mailAddress, height, weight, birthdate, nationality,
				photoUrl, region, city, numpasseport, comment);
		this.id = id;
		this.badge = badge;
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



	@Override
	public String toString() {
		return "Commissioner [id=" + id + ", badge=" + badge +", "+ super.toString() + "]";
	}





}