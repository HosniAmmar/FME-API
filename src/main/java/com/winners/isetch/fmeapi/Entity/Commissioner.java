package com.winners.isetch.fmeapi.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Commissioner {
	 @Id
	    private int id;

	    private int badge;
	    private String firstName;
	    private String lastName;
	 	private String natIdNum;
	 	private String adress;
	 	private String birthdate;
	 	private String phone;
	 	private String mailAdress;
	 	private double height;
	 	private double weight;
	 	private String nationality;
	 	private String photoUrl;

	    public Commissioner() {
	    }

	    public Commissioner(int id, int badge, String firstName, String lastName, String natIdNum, String adress,
				String birthdate, String phone, String mailAdress, double height, double weight, String nationality,
				String photoUrl) {
			super();
			this.id = id;
			this.badge = badge;
			this.firstName = firstName;
			this.lastName = lastName;
			this.natIdNum = natIdNum;
			this.adress = adress;
			this.birthdate = birthdate;
			this.phone = phone;
			this.mailAdress = mailAdress;
			this.height = height;
			this.weight = weight;
			this.nationality = nationality;
			this.photoUrl = photoUrl;
		}



		public int getBadge() {
			return badge;
		}



		public void setBadge(int badge) {
			this.badge = badge;
		}



		public String getPhotoUrl() {
			return photoUrl;
		}



		public void setPhotoUrl(String photoUrl) {
			this.photoUrl = photoUrl;
		}



		public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	  

	    public String getFirstName() {
	        return firstName;
	    }

	    public void setFirstName(String firstName) {
	        this.firstName = firstName;
	    }

	    public String getLastName() {
	        return lastName;
	    }

	    public void setLastName(String lastName) {
	        this.lastName = lastName;
	    }

	    public String getNatIdNum() {
	        return natIdNum;
	    }

	    public void setNatIdNum(String natIdNum) {
	        this.natIdNum = natIdNum;
	    }

	    public String getAdress() {
	        return adress;
	    }

	    public void setAdress(String adress) {
	        this.adress = adress;
	    }

	    public String getPhone() {
	        return phone;
	    }

	    public void setPhone(String phone) {
	        this.phone = phone;
	    }

	    public String getMailAdress() {
	        return mailAdress;
	    }

	    public void setMailAdress(String mailAdress) {
	        this.mailAdress = mailAdress;
	    }

	    public double getHeight() {
	        return height;
	    }

	    public void setHeight(double height) {
	        this.height = height;
	    }

	    public double getWeight() {
	        return weight;
	    }

	    public void setWeight(double weight) {
	        this.weight = weight;
	    }

	    public String getBirthdate() {
	        return birthdate;
	    }

	    public void setBirthdate(String birthdate) {
	        this.birthdate = birthdate;
	    }

	    public String getNationality() {
	        return nationality;
	    }

	    public void setNationality(String nationality) {
	        this.nationality = nationality;
	    }		

}