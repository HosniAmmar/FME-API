package com.winners.isetch.fmeapi.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class MatchDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @ManyToOne
    @JoinColumn(name = "idEquipe1")
    private Team equipe1;

    @ManyToOne
    @JoinColumn(name = "idEquipe2")
    private Team equipe2;

    @ManyToMany
    @JoinTable(
            name="equipe1PlayerR"
            , joinColumns={
            @JoinColumn(name="id_match")
    }
            , inverseJoinColumns={
            @JoinColumn(name="id_player")
    }
    )
    private List<Player> equipe1PlayerR;

    @ManyToMany
    @JoinTable(
            name="equipe1PlayerP"
            , joinColumns={
            @JoinColumn(name="id_match")
    }
            , inverseJoinColumns={
            @JoinColumn(name="id_player")
    }
    )
    private List<Player> equipe1PlayerP;

    @ManyToMany
    @JoinTable(
            name="equipe2PlayerR"
            , joinColumns={
            @JoinColumn(name="id_match")
    }
            , inverseJoinColumns={
            @JoinColumn(name="id_player")
    }
    )
    private List<Player> equipe2PlayerR;

    @ManyToMany
    @JoinTable(
            name="equipe2PlayerP"
            , joinColumns={
            @JoinColumn(name="id_match")
    }
            , inverseJoinColumns={
            @JoinColumn(name="id_player")
    }
    )
    private List<Player> equipe2PlayerP;


    private boolean equipe1Prepared;
    private boolean equipe2Prepared;

    private String date;
    private String heure;
    private String place;
    private int idArbitre1;
    private int idArbitre2;
    private int idArbitre3;
    private int idCommissaire;

    private boolean confirmedByResponsable;


    public MatchDetails() {
    }

    public MatchDetails(Team equipe1, Team equipe2, List<Player> equipe1PlayerR,
                        List<Player> equipe1PlayerP, List<Player> equipe2PlayerR,
                        List<Player> equipe2PlayerP, boolean equipe1Prepared,
                        boolean equipe2Prepared, String date, String heure,
                        String place, int idArbitre1, int idArbitre2,
                        int idArbitre3, int idCommissaire,boolean confirmedByResponsable) {
        this.equipe1 = equipe1;
        this.equipe2 = equipe2;
        this.equipe1PlayerR = equipe1PlayerR;
        this.equipe1PlayerP = equipe1PlayerP;
        this.equipe2PlayerR = equipe2PlayerR;
        this.equipe2PlayerP = equipe2PlayerP;
        this.equipe1Prepared = equipe1Prepared;
        this.equipe2Prepared = equipe2Prepared;
        this.date = date;
        this.heure = heure;
        this.place = place;
        this.idArbitre1 = idArbitre1;
        this.idArbitre2 = idArbitre2;
        this.idArbitre3 = idArbitre3;
        this.idCommissaire = idCommissaire;
        this.confirmedByResponsable = confirmedByResponsable;
    }

    public boolean isConfirmedByResponsable() {
        return confirmedByResponsable;
    }

    public void setConfirmedByResponsable(boolean confirmedByResponsable) {
        this.confirmedByResponsable = confirmedByResponsable;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Team getEquipe1() {
        return equipe1;
    }

    public void setEquipe1(Team equipe1) {
        this.equipe1 = equipe1;
    }

    public Team getEquipe2() {
        return equipe2;
    }

    public void setEquipe2(Team equipe2) {
        this.equipe2 = equipe2;
    }

    public List<Player> getEquipe1PlayerR() {
        return equipe1PlayerR;
    }

    public void setEquipe1PlayerR(List<Player> equipe1PlayerR) {
        this.equipe1PlayerR = equipe1PlayerR;
    }

    public List<Player> getEquipe1PlayerP() {
        return equipe1PlayerP;
    }

    public void setEquipe1PlayerP(List<Player> equipe1PlayerP) {
        this.equipe1PlayerP = equipe1PlayerP;
    }

    public List<Player> getEquipe2PlayerR() {
        return equipe2PlayerR;
    }

    public void setEquipe2PlayerR(List<Player> equipe2PlayerR) {
        this.equipe2PlayerR = equipe2PlayerR;
    }

    public List<Player> getEquipe2PlayerP() {
        return equipe2PlayerP;
    }

    public void setEquipe2PlayerP(List<Player> equipe2PlayerP) {
        this.equipe2PlayerP = equipe2PlayerP;
    }

    public boolean isEquipe1Prepared() {
        return equipe1Prepared;
    }

    public void setEquipe1Prepared(boolean equipe1Prepared) {
        this.equipe1Prepared = equipe1Prepared;
    }

    public boolean isEquipe2Prepared() {
        return equipe2Prepared;
    }

    public void setEquipe2Prepared(boolean equipe2Prepared) {
        this.equipe2Prepared = equipe2Prepared;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getIdArbitre1() {
        return idArbitre1;
    }

    public void setIdArbitre1(int idArbitre1) {
        this.idArbitre1 = idArbitre1;
    }

    public int getIdArbitre2() {
        return idArbitre2;
    }

    public void setIdArbitre2(int idArbitre2) {
        this.idArbitre2 = idArbitre2;
    }

    public int getIdArbitre3() {
        return idArbitre3;
    }

    public void setIdArbitre3(int idArbitre3) {
        this.idArbitre3 = idArbitre3;
    }

    public int getIdCommissaire() {
        return idCommissaire;
    }

    public void setIdCommissaire(int idCommissaire) {
        this.idCommissaire = idCommissaire;
    }
}
