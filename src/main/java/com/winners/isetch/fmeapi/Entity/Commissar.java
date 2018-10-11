package com.winners.isetch.fmeapi.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Commissar {
	@Id
	  	private int id;
	    private String name;
	    private int tel;
	    private String adress;
	    private String prenom;
	    private int age;

	    public Commissar() {}
	    
		public Commissar(int id, String name, int tel, String adress, String prenom, int age) {
			super();
			this.id = id;
			this.name = name;
			this.tel = tel;
			this.adress = adress;
			this.prenom = prenom;
			this.age = age;
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

		public int getTel() {
			return tel;
		}

		public void setTel(int tel) {
			this.tel = tel;
		}

		public String getAdress() {
			return adress;
		}

		public void setAdress(String adress) {
			this.adress = adress;
		}

		public String getPrenom() {
			return prenom;
		}

		public void setPrenom(String prenom) {
			this.prenom = prenom;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		@Override
		public String toString() {
			return "Referee [id=" + id + ", name=" + name + ", tel=" + tel + ", adress=" + adress + ", prenom=" + prenom
					+ ", age=" + age + "]";
		}
		
		

}