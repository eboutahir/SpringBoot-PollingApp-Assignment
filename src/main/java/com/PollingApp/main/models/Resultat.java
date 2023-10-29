package com.PollingApp.main.models;

import javax.persistence.*;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "results")
public class Resultat {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String username;
	private String email;
	private int totalCorrect = 0;

	public Resultat() {
		super();
	}

	public Resultat(int id, String username,String email, int totalCorrect) {
		super();
		this.id = id;
		this.username = username;
		this.email=email;
		this.totalCorrect = totalCorrect;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return username;
	}

	public void setEmail(String email) {
		this.username = email;
	}

	public int getTotalCorrect() {
		return totalCorrect;
	}

	public void setTotalCorrect(int totalCorrect) {
		this.totalCorrect = totalCorrect;
	}

}
