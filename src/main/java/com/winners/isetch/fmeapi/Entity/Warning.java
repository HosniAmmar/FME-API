package com.winners.isetch.fmeapi.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Warning {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	private int idMatch;
	private String min;
	private int idPlayer;
	private String color;
	private String information;
	


	public Warning() {

	}



	public Warning(int id, int idMatch, String min, int idPlayer, String color, String information) {
		
		this.id = id;
		this.idMatch = idMatch;
		this.min = min;
		this.idPlayer = idPlayer;
		this.color = color;
		this.information = information;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public int getIdMatch() {
		return idMatch;
	}



	public void setIdMatch(int idMatch) {
		this.idMatch = idMatch;
	}



	public String getMin() {
		return min;
	}



	public void setMin(String min) {
		this.min = min;
	}



	public int getIdPlayer() {
		return idPlayer;
	}



	public void setIdPlayer(int idPlayer) {
		this.idPlayer = idPlayer;
	}



	public String getColor() {
		return color;
	}



	public void setColor(String color) {
		this.color = color;
	}



	public String getInformation() {
		return information;
	}



	public void setInformation(String information) {
		this.information = information;
	}



	@Override
	public String toString() {
		return "Warning [id=" + id + ", idMatch=" + idMatch + ", min=" + min + ", idPlayer=" + idPlayer + ", color="
				+ color + ", information=" + information + "]";
	}

		

}
