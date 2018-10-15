package com.winners.isetch.fmeapi.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String name;
    private String logoUrl;
    private String adress;
    private String region;
    private String creationDate;
    private String presidentirstName;
    private String presidentLastName;
    private String presidentPhone;
    private String secretaryFirstName;
    private String secretaryLastName;
    private String secretaryPhone;
    private String mail;
    private String phone;
    private String fax;
    private String mainStadium;
    private String mainStadiumLocation;
    private String teamPhoto;
    private String division;

    public Team() {
    }

    public Team(String name, String logoUrl, String adress, String region, String creationDate, String presidentirstName, String presidentLastName, String presidentPhone, String secretaryFirstName, String secretaryLastName, String secretaryPhone, String mail, String phone, String fax, String mainStadium, String mainStadiumLocation, String teamPhoto, String division) {
        this.name = name;
        this.logoUrl = logoUrl;
        this.adress = adress;
        this.region = region;
        this.creationDate = creationDate;
        this.presidentirstName = presidentirstName;
        this.presidentLastName = presidentLastName;
        this.presidentPhone = presidentPhone;
        this.secretaryFirstName = secretaryFirstName;
        this.secretaryLastName = secretaryLastName;
        this.secretaryPhone = secretaryPhone;
        this.mail = mail;
        this.phone = phone;
        this.fax = fax;
        this.mainStadium = mainStadium;
        this.mainStadiumLocation = mainStadiumLocation;
        this.teamPhoto = teamPhoto;
        this.division = division;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getPresidentirstName() {
        return presidentirstName;
    }

    public void setPresidentirstName(String presidentirstName) {
        this.presidentirstName = presidentirstName;
    }

    public String getPresidentLastName() {
        return presidentLastName;
    }

    public void setPresidentLastName(String presidentLastName) {
        this.presidentLastName = presidentLastName;
    }

    public String getPresidentPhone() {
        return presidentPhone;
    }

    public void setPresidentPhone(String presidentPhone) {
        this.presidentPhone = presidentPhone;
    }

    public String getSecretaryFirstName() {
        return secretaryFirstName;
    }

    public void setSecretaryFirstName(String secretaryFirstName) {
        this.secretaryFirstName = secretaryFirstName;
    }

    public String getSecretaryLastName() {
        return secretaryLastName;
    }

    public void setSecretaryLastName(String secretaryLastName) {
        this.secretaryLastName = secretaryLastName;
    }

    public String getSecretaryPhone() {
        return secretaryPhone;
    }

    public void setSecretaryPhone(String secretaryPhone) {
        this.secretaryPhone = secretaryPhone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getMainStadium() {
        return mainStadium;
    }

    public void setMainStadium(String mainStadium) {
        this.mainStadium = mainStadium;
    }

    public String getMainStadiumLocation() {
        return mainStadiumLocation;
    }

    public void setMainStadiumLocation(String mainStadiumLocation) {
        this.mainStadiumLocation = mainStadiumLocation;
    }

    public String getTeamPhoto() {
        return teamPhoto;
    }

    public void setTeamPhoto(String teamPhoto) {
        this.teamPhoto = teamPhoto;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }
}
