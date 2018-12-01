package com.winners.isetch.fmeapi.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Secretary extends Personne {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
	public Secretary() {
		
	}
	public Secretary(String firstName, String lastName, String phone, String natIdNum, String address,
			String mailAddress, double height, double weight, String birthdate, String nationality, String photoUrl,
			String region, String city, String numpasseport, String comment, int id) {
		super(firstName, lastName, phone, natIdNum, address, mailAddress, height, weight, birthdate, nationality,
				photoUrl, region, city, numpasseport, comment);
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Secretary [id=" + id + ", " + super.toString() + "]";
	}
	
	
}
