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
	 	private String formation;
	 	private String nationality;
	 	private String photoUrl;
	 	
	 	public Responsable() {}

		public Responsable(int id, String firstName, String lastName, String natIdNum, String adress, String birthdate,
				String phone, String mailAdress, String formation, String nationality, String photoUrl) {
			super();
			this.id = id;
			this.firstName = firstName;
			this.lastName = lastName;
			this.natIdNum = natIdNum;
			this.adress = adress;
			this.birthdate = birthdate;
			this.phone = phone;
			this.mailAdress = mailAdress;
			this.formation = formation;
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

		public String getFormation() {
			return formation;
		}

		public void setFormation(String formation) {
			this.formation = formation;
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

		@Override
		public String toString() {
			return "Responsable [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", natIdNum="
					+ natIdNum + ", adress=" + adress + ", birthdate=" + birthdate + ", phone=" + phone
					+ ", mailAdress=" + mailAdress + ", formation=" + formation + ", nationality=" + nationality
					+ ", photoUrl=" + photoUrl + "]";
		}
	 	
	 	
	 	 

}
