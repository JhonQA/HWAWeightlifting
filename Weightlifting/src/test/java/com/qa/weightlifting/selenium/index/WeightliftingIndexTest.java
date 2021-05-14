package com.qa.weightlifting.selenium.index;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WeightliftingIndexTest {

	
	
	@FindBy(name = "Insert")
	private WebElement insertModalButton;
	
	
	//These two buttons reference the IDs of the button the user clicks to change a record. This button is on the right hand side
	//of the table
	// Increment the ID changeUpdateModalButton or changeDeleteModalButton if you wish to test other rows in the table
	@FindBy(id = "updateButton1")
	private WebElement changeUpdateModalButton;
	
	@FindBy(id = "updateButton1")
	private WebElement changeDeleteModalButton;
	
	
	// These three are the buttons the user clicks on in the change modal to insert a new /update / delete an existing record
	// Increment the ID updateModalButton or deleteModalButton if you wish to test other rows in the table
	@FindBy(id="addPr")
	private WebElement submitModalButton;
	
	@FindBy(id="updatePr1")
	private WebElement updateModalButton;
	
	@FindBy(id="deletePr1")
	private WebElement deleteModalButton;
	
	
	// The ID and locations of the Modals for inserting a new record /update / delete an existing record
	// xpath was used on the insert as the ID was causing identification issues
	// Increment the ID of updateModalWindow or deleteModalWindow if you wish to test other rows in the table
	@FindBy(xpath = "/html/body/div[1]/div[3]/div[4]")
	private WebElement insertModalWindow;
	
	@FindBy(id = "exampleModal21")
	private WebElement updateModalWindow;
	
	@FindBy(id = "exampleModal21")
	private WebElement deleteModalWindow;
	
	
	// These three IDs represent the alert given to the user when they have inserted a new record /updated / deleted an existing record
	@FindBy(id="onSuccess")
	private WebElement recordInsertedSucess;
	
	@FindBy(id="onUpdate")
	private WebElement recordUpdateSucess;
	
	@FindBy(id="onDelete")
	private WebElement recordDeleteSucess;
	
	
	//These values represent the fields in which the user enters information in the Modal. This is for the Insert Modal
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
	
	
	//These values represent the fields in which the user enters information in the Modal. This is for the Change/Update Modal
	@FindBy(id="firstName21")
	private WebElement firstNameFieldUpdate;
	
	@FindBy(id="lastName21")
	private WebElement lastNameFieldUpdate;
	
	@FindBy(id="benchPress21")
	private WebElement benchPressFieldUpdate ;
	
	@FindBy(id="cleanAndJ21")
	private WebElement cleanAndJFieldUpdate;
	
	@FindBy(id="snatch21")
	private WebElement snatchFieldUpdate;
	
	
	
	
	public void createRecord(String firstName1, String lastName1, int benchPress1, int cleanAndJ1, int snatch1 ) {
		
		firstNameField.clear();
		firstNameField.sendKeys(firstName1);
		
		lastNameField.clear();
		lastNameField.sendKeys(lastName1);
		
		benchPressField.clear();
		benchPressField.sendKeys(String.valueOf(benchPress1));
		
		
		cleanAndJField.clear();
		cleanAndJField.sendKeys(String.valueOf(cleanAndJ1));
		
		snatchField.clear();
		snatchField.sendKeys(String.valueOf(snatch1));

	}
	
	
public void updateRecord(String firstName21, String lastName21, int benchPress21, int cleanAndJ21, int snatch21 ) {
		
		firstNameFieldUpdate.clear();;
		firstNameFieldUpdate.sendKeys(firstName21);
		
		lastNameFieldUpdate.clear();
		lastNameFieldUpdate.sendKeys(lastName21);
		
		benchPressFieldUpdate.clear();
		benchPressFieldUpdate.sendKeys(String.valueOf(benchPress21));
		
		
		cleanAndJFieldUpdate.clear();
		cleanAndJFieldUpdate.sendKeys(String.valueOf(cleanAndJ21));
		
		snatchFieldUpdate.clear();
		snatchFieldUpdate.sendKeys(String.valueOf(snatch21));

	}

	public WebElement getInsertModalButton() {
		return insertModalButton;
	}


	public WebElement getChangeUpdateModalButton() {
		return changeUpdateModalButton;
	}

	

	public WebElement getChangeDeleteModalButton() {
		return changeDeleteModalButton;
	}


	public WebElement getInsertModalWindow() {
		return insertModalWindow;
	}

	public WebElement getUpdateModalWindow() {
		return updateModalWindow;
	}
	
	

	public WebElement getDeleteModalWindow() {
		return deleteModalWindow;
	}


	public WebElement getSubmitModalButton() {
		return submitModalButton;
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
	
	


	public WebElement getRecordUpdateSucess() {
		return recordUpdateSucess;
	}


	public WebElement getRecordDeleteSucess() {
		return recordDeleteSucess;
	}


	public WebElement getUpdateModalButton() {
		return updateModalButton;
	}

	

	public WebElement getDeleteModalButton() {
		return deleteModalButton;
	}


	public WebElement getFirstNameFieldUpdate() {
		return firstNameFieldUpdate;
	}


	public WebElement getLastNameFieldUpdate() {
		return lastNameFieldUpdate;
	}


	public WebElement getBenchPressFieldUpdate() {
		return benchPressFieldUpdate;
	}


	public WebElement getCleanAndJFieldUpdate() {
		return cleanAndJFieldUpdate;
	}


	public WebElement getSnatchFieldUpdate() {
		return snatchFieldUpdate;
	}


	
	
	
	

}
