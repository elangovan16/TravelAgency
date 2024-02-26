package travelagency.dto;

import java.time.LocalDate;

public class User {
	private String name;
	private String residence;
	private String email;
	private LocalDate date;
	private int noOfPeople;
	private String vacationType;

	public User() {

	}

	public User(String name, String residence, String email, LocalDate date, int noOfPeople, String vacationType) {
		this.name = name;
		this.residence = residence;
		this.email = email;
		this.date = date;
		this.noOfPeople = noOfPeople;
		this.vacationType = vacationType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getResidence() {
		return residence;
	}

	public void setResidence(String residence) {
		this.residence = residence;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public int getNoOfPeople() {
		return noOfPeople;
	}

	public void setNoOfPeople(int noOfPeople) {
		this.noOfPeople = noOfPeople;
	}

	public String getVacationType() {
		return vacationType;
	}

	public void setVacationType(String vacationType) {
		this.vacationType = vacationType;
	}

}
