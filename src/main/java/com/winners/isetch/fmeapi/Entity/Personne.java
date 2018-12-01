package com.winners.isetch.fmeapi.Entity;


import javax.persistence.MappedSuperclass;
@MappedSuperclass
public class Personne {
	private String firstName;
	private String lastName;
	private String phone;
	private String natIdNum;
	private String address;
	private String mailAddress;
	private double height;
	private double weight;
	private String birthdate;
	private String nationality;
	private String photoUrl;
	private String region;
	private String city;
	private String numpasseport;
	private String comment;
	public Personne(){
		
	}
	
	
	
	public Personne(String firstName, String lastName, String phone, String natIdNum, String address,
			String mailAddress, double height, double weight, String birthdate, String nationality, String photoUrl,
			String region, String city, String numpasseport, String comment) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.natIdNum = natIdNum;
		this.address = address;
		this.mailAddress = mailAddress;
		this.height = height;
		this.weight = weight;
		this.birthdate = birthdate;
		this.nationality = nationality;
		this.photoUrl = photoUrl;
		this.region = region;
		this.city = city;
		this.numpasseport = numpasseport;
		this.comment = comment;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getNatIdNum() {
		return natIdNum;
	}
	public void setNatIdNum(String natIdNum) {
		this.natIdNum = natIdNum;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMailAddress() {
		return mailAddress;
	}
	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
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
		return " firstName=" + firstName + ", lastName=" + lastName + ", phone=" + phone + ", natIdNum="
				+ natIdNum + ", address=" + address + ", mailAddress=" + mailAddress + ", height=" + height
				+ ", weight=" + weight + ", birthdate=" + birthdate + ", nationality=" + nationality + ", photoUrl="
				+ photoUrl + ", region=" + region + ", city=" + city + ", numpasseport=" + numpasseport + ", comment="
				+ comment ;
	}

	
}
