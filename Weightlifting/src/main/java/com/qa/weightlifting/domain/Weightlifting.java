package com.qa.weightlifting.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;



@Entity
public class Weightlifting {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message= "First Name may not be null")
	private String firstName;
	
	@NotNull(message= "Last Name may not be null")
	private String lastName;
	
	@NotNull(message= "Bench Press may not be null")
	private Integer benchPress;
	
	@NotNull(message= "Clean and Jerk may not be null")
	private Integer cleanAndJ;
	
	@NotNull(message= "Snatch may not be null")
	private Integer snatch;
	
	public Weightlifting(String firstName, String lastName, Integer benchPress, Integer cleanAndJ, Integer snatch) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.benchPress = benchPress;
		this.cleanAndJ = cleanAndJ;
		this.snatch = snatch;
	}
	
	
	
	public Weightlifting(Long id,
			@NotNull(message= "Name may not be null") String firstName, 
			@NotNull(message= "Last Name may not be null")String lastName, 
			@NotNull(message= "Bench Press may not be null")Integer benchPress, 
			@NotNull(message= "Clean and Jerk may not be null")Integer cleanAndJ, 
			@NotNull(message= "Snatch may not be null")Integer snatch) {
		super();
		this.id = id;
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
	public Integer getBenchPress() {
		return benchPress;
	}
	public void setBenchPress(Integer benchPress) {
		this.benchPress = benchPress;
	}
	public Integer getCleanAndJ() {
		return cleanAndJ;
	}
	public void setCleanAndJ(Integer cleanAndJ) {
		this.cleanAndJ = cleanAndJ;
	}
	public Integer getSnatch() {
		return snatch;
	}
	public void setSnatch(Integer snatch) {
		this.snatch = snatch;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((benchPress == null) ? 0 : benchPress.hashCode());
		result = prime * result + ((cleanAndJ == null) ? 0 : cleanAndJ.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((snatch == null) ? 0 : snatch.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Weightlifting other = (Weightlifting) obj;
		if (benchPress == null) {
			if (other.benchPress != null)
				return false;
		} else if (!benchPress.equals(other.benchPress))
			return false;
		if (cleanAndJ == null) {
			if (other.cleanAndJ != null)
				return false;
		} else if (!cleanAndJ.equals(other.cleanAndJ))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (snatch == null) {
			if (other.snatch != null)
				return false;
		} else if (!snatch.equals(other.snatch))
			return false;
		return true;
	}



	
	
}
