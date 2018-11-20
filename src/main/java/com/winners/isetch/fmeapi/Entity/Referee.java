package com.winners.isetch.fmeapi.Entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

	@Entity
	public class Referee {
		 @Id
		 @GeneratedValue(strategy = GenerationType.SEQUENCE)
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
		 	//new att

		 	private String region;
		 	private String city;
		 	private String numpasseport;
		 	private String comment;
		 	
		 	public Referee() {}

		 	
			public Referee(int id, int badge, String firstName, String lastName, String natIdNum, String adress,
					String birthdate, String phone, String mailAdress, double height, double weight, String nationality,
					String photoUrl, String region, String city, String numpasseport, String comment) {
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
				this.region = region;
				this.city = city;
				this.numpasseport = numpasseport;
				this.comment = comment;
			}


			public Referee(int id, int badge, String firstName, String lastName, String natIdNum, String adress,
					String birthdate, String phone, String mailAdress, double height, double weight, String nationality,String photoUrl) {
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
				this.photoUrl=photoUrl;
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
				return "Referee [id=" + id + ", badge=" + badge + ", firstName=" + firstName + ", lastName=" + lastName
						+ ", natIdNum=" + natIdNum + ", adress=" + adress + ", birthdate=" + birthdate + ", phone="
						+ phone + ", mailAdress=" + mailAdress + ", height=" + height + ", weight=" + weight
						+ ", nationality=" + nationality + ", photoUrl=" + photoUrl + ", region=" + region + ", city="
						+ city + ", numpasseport=" + numpasseport + ", comment=" + comment + "]";
			}


		
			
	
}


