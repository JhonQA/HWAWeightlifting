package com.qa.weightlifting.index;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WeightliftingIndex {

	public static final String URL ="http://127.0.0.1:5500/WeightliftingHWA/index.html";
	
	@FindBy(name = "Insert")
	private WebElement insertModal;
	
	@FindBy(id = "exampleModalLabel")
	private WebElement insertModalWindow;
	
	@FindBy(id="Submit")
	private WebElement submitModal;
	
	@FindBy(id="onSuccess")
	private WebElement recordInsertedSucess;
	
	@FindBy(id="firstName1")
	private WebElement firstNameField;
	
	@FindBy(id="lastName1")
	private WebElement lastNameField;
	
	@FindBy(id="benchPress1")
	private WebElement benchPressField ;
	
	@FindBy(id="cleanAndJ1")
	private WebElement cleanAndJField;
	
	@FindBy(id="snatch1")
	private WebElement snatchField;
	
	
	public void createRecord(String firstName1, String lastName1, int benchPress1, int cleanAndJ1, int snatch1 ) {
		firstNameField.click();
		firstNameField.sendKeys(firstName1);
		
		lastNameField.click();
		lastNameField.sendKeys(lastName1);
		
		benchPressField.click();
		benchPressField.sendKeys(String.valueOf(benchPress1));
		
		cleanAndJField.click();
		cleanAndJField.sendKeys(String.valueOf(cleanAndJ1));
		
		snatchField.click();
		snatchField.sendKeys(String.valueOf(snatch1));

	}


	public static String getUrl() {
		return URL;
	}


	public WebElement getInsertModal() {
		return insertModal;
	}


	public WebElement getInsertModalWindow() {
		return insertModalWindow;
	}


	public WebElement getSubmitModal() {
		return submitModal;
	}


	public WebElement getFirstNameField() {
		return firstNameField;
	}


	public WebElement getLastNameField() {
		return lastNameField;
	}


	public WebElement getBenchPressField() {
		return benchPressField;
	}


	public WebElement getCleanAndJField() {
		return cleanAndJField;
	}


	public WebElement getSnatchField() {
		return snatchField;
	}


	public WebElement getRecordInsertedSucess() {
		return recordInsertedSucess;
	}


	
	
	
	

}
