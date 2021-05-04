package com.qa.weightlifting.domain;

public class Weightlifting {
	
	
	private Long id;
	private String firstName;
	private String lastName;
	private Long benchPress;
	private Long cleanAndJ;
	private Long snatch;
	
	public Weightlifting(String firstName, String lastName, Long benchPress, Long cleanAndJ, Long snatch) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.benchPress = benchPress;
		this.cleanAndJ = cleanAndJ;
		this.snatch = snatch;
	}
	
	public Weightlifting() {
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public Long getBenchPress() {
		return benchPress;
	}
	public void setBenchPress(Long benchPress) {
		this.benchPress = benchPress;
	}
	public Long getCleanAndJ() {
		return cleanAndJ;
	}
	public void setCleanAndJ(Long cleanAndJ) {
		this.cleanAndJ = cleanAndJ;
	}
	public Long getSnatch() {
		return snatch;
	}
	public void setSnatch(Long snatch) {
		this.snatch = snatch;
	}


	
	
}
