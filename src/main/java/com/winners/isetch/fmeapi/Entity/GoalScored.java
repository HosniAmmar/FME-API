package com.winners.isetch.fmeapi.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GoalScored {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	private int idPlayer;
	private int idMatch;
	private String min;
	
	public GoalScored() {
		
	}

	public GoalScored(int id, int idPlayer, int idMatch, String min) {
		
		this.id = id;
		this.idPlayer = idPlayer;
		this.idMatch = idMatch;
		this.min = min;
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

	public String getMin() {
		return min;
	}

	public void setMin(String min) {
		this.min = min;
	}

	@Override
	public String toString() {
		return "GoalScored [id=" + id + ", idPlayer=" + idPlayer + ", idMatch=" + idMatch + ", min=" + min + "]";
	}

	
		
	
}
