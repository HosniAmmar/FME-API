package com.winners.isetch.fmeapi.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Responsable {
	
	@Id
	 @GeneratedValue(strategy = GenerationType.SEQUENCE)
	    private int id;
	 
	 	private String firstName;
	 	private String lastName;
	 	private String natIdNum;
	 	private String adress;
	 	private String birthdate;
	 	private String phone;
	 	private String mailAdress;
	 	private String fonction;
	 	private String nationality;
	 	private String photoUrl;

	 	//new att
	 	private String region;
	 	private String city;
	 	private String numpasseport;
	 	private String comment;

	 	public Responsable() {}

	 	
		public Responsable(int id, String firstName, String lastName, String natIdNum, String adress, String birthdate,
				String phone, String mailAdress, String fonction, String nationality, String photoUrl, String region,
				String city, String numpasseport, String comment) {
			super();
			this.id = id;
			this.firstName = firstName;
			this.lastName = lastName;
			this.natIdNum = natIdNum;
			this.adress = adress;
			this.birthdate = birthdate;
			this.phone = phone;
			this.mailAdress = mailAdress;
			this.fonction = fonction;
			this.nationality = nationality;
			this.photoUrl = photoUrl;
			this.region = region;
			this.city = city;
			this.numpasseport = numpasseport;
			this.comment = comment;
		}


		public Responsable(int id, String firstName, String lastName, String natIdNum, String adress, String birthdate,
				String phone, String mailAdress, String fonction, String nationality, String photoUrl) {
			super();
			this.id = id;
			this.firstName = firstName;
			this.lastName = lastName;
			this.natIdNum = natIdNum;
			this.adress = adress;
			this.birthdate = birthdate;
			this.phone = phone;
			this.mailAdress = mailAdress;
			this.fonction = fonction;
			this.nationality = nationality;
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

		public String getBirthdate() {
			return birthdate;
		}

		public void setBirthdate(String birthdate) {
			this.birthdate = birthdate;
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

		

		public String getFonction() {
			return fonction;
		}

		public void setFonction(String fonction) {
			this.fonction = fonction;
		}

		public String getNationality() {
			return nationality;
		}

		public void setNationality(String nationality) {
			this.nationality = nationality;
		}

		public String getPhotoUrl() {
			return photoUrl;
		}

		public void setPhotoUrl(String photoUrl) {
			this.photoUrl = photoUrl;
		}


		public String getRegion() {
			return region;
		}


		public void setRegion(String region) {
			this.region = region;
		}


		public String getCity() {
			return city;
		}


		public void setCity(String city) {
			this.city = city;
		}


		public String getNumpasseport() {
			return numpasseport;
		}


		public void setNumpasseport(String numpasseport) {
			this.numpasseport = numpasseport;
		}


		public String getComment() {
			return comment;
		}


		public void setComment(String comment) {
			this.comment = comment;
		}


		@Override
		public String toString() {
			return "Responsable [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", natIdNum="
					+ natIdNum + ", adress=" + adress + ", birthdate=" + birthdate + ", phone=" + phone
					+ ", mailAdress=" + mailAdress + ", fonction=" + fonction + ", nationality=" + nationality
					+ ", photoUrl=" + photoUrl + ", region=" + region + ", city=" + city + ", numpasseport="
					+ numpasseport + ", comment=" + comment + "]";
		}
		

		
	 	
	 	 

		
}
