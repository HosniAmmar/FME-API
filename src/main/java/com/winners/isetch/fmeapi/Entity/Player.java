package com.winners.isetch.fmeapi.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Player {

    @Id
    private int id;

    private String licenseNumber;
    private String firstName;
    private String lastName;
    //cin number
    private String natIdNum;
    private String adress;
    private String phone;
    private String mailAdress;
    private double height;
    private double weight;
    private String birthdate;
    private int actualTeamId;
    private int previousTeamId;
    private String nationality;
    private String category;

    public Player() {
    }

    public Player(int id, String licenseNumber, String firstName, String lastName, String natIdNum, String adress, String phone, String mailAdress, double height, double weight, String birthdate, int actualTeamId, int previousTeamId, String nationality, String category) {
        this.id = id;
        this.licenseNumber = licenseNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.natIdNum = natIdNum;
        this.adress = adress;
        this.phone = phone;
        this.mailAdress = mailAdress;
        this.height = height;
        this.weight = weight;
        this.birthdate = birthdate;
        this.actualTeamId = actualTeamId;
        this.previousTeamId = previousTeamId;
        this.nationality = nationality;
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

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
