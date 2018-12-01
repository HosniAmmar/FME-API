package com.winners.isetch.fmeapi.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Injury {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	private int idPlayer;
	private int idMatch;
	private int min;
	private String type;
	private String infomation;	
	public Injury() {
	}
	public Injury(int id, int idPlayer, int idMatch, int min, String type, String infomation) {
		
		this.id = id;
		this.idPlayer = idPlayer;
		this.idMatch = idMatch;
		this.min = min;
		this.type = type;
		this.infomation = infomation;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdPlayer() {
		return idPlayer;
	}
	public void setIdPlayer(int idPlayer) {
		this.idPlayer = idPlayer;
	}
	public int getIdMatch() {
		return idMatch;
	}
	public void setIdMatch(int idMatch) {
		this.idMatch = idMatch;
	}
	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getInfomation() {
		return infomation;
	}
	public void setInfomation(String infomation) {
		this.infomation = infomation;
	}
	@Override
	public String toString() {
		return "Injury [id=" + id + ", idPlayer=" + idPlayer + ", idMatch=" + idMatch + ", min=" + min + ", type="
				+ type + ", infomation=" + infomation + "]";
	}
	
		
	
	
	
}
