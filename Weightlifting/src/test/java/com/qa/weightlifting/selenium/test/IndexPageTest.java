package com.qa.weightlifting.selenium.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.qa.weightlifting.selenium.index.WeightliftingIndexTest;

@ContextConfiguration
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class IndexPageTest {
	
	 
	@LocalServerPort
	int randomPort;
	
	public static final String URL ="http://localhost:" ;
	
	private WebDriver driver;
	
	@Before
	public void init() {
	
	System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
	
	ChromeOptions options = new ChromeOptions();
	options.setHeadless(false);
	
	driver = new ChromeDriver(options);
	
	driver.manage().window().setSize(new Dimension(1366,763));
	
	
	
}
	
	@Test
	public void checkURL() {
		driver.get(URL +randomPort +"/");
		assertEquals(URL+randomPort +"/",  driver.getCurrentUrl());
	}
	
	
	@Test
	public void getWeightlifting() {
		driver.get(URL+randomPort +"/");
		assertEquals("Weightlifting", driver.getTitle());
	}
	
	
	@Test
	public void submitButton() {
		
		driver.get(URL+randomPort +"/");
		WeightliftingIndexTest index = PageFactory.initElements(driver, WeightliftingIndexTest.class);

		index.getInsertModalButton().click();
		 
		 
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(index.getInsertModalWindow()));
		
		index.createRecord("Jhon", "Urrego", 140, 100, 80);
		
		
		index.getSubmitModalButton().click();
		
		WebDriverWait success = new WebDriverWait(driver,20);
		success.until(ExpectedConditions.visibilityOf(index.getRecordInsertedSucess()));
		
		assertTrue(index.getRecordInsertedSucess().getText().contains("Record has been successfully created! Please wait a moment"));
	}
	

	
	
	@Test
	public void deleteButton() {
		driver.get(URL+randomPort +"/");
		WeightliftingIndexTest index = PageFactory.initElements(driver, WeightliftingIndexTest.class);

		index.getChangeDeleteModalButton().click();
		
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(index.getDeleteModalWindow()));
		
		
		index.getDeleteModalButton().click();
		
		WebDriverWait deleted = new WebDriverWait(driver,20);
		deleted.until(ExpectedConditions.visibilityOf(index.getRecordDeleteSucess()));
		
		assertTrue(index.getRecordDeleteSucess().getText().contains("Record has been deleted! Please wait a moment"));
		
	}
	
	@Test
	public void updateButton() {
		
		driver.get(URL+randomPort +"/");
		WeightliftingIndexTest index = PageFactory.initElements(driver, WeightliftingIndexTest.class);

		index.getChangeUpdateModalButton().click();
		
		
		WebDriverWait wait = new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.visibilityOf(index.getUpdateModalWindow()));
		
		index.updateRecord("Steve", "Rogers", 380, 320, 320);
	 
		  
		index.getUpdateModalButton().click();
		
		WebDriverWait updated = new WebDriverWait(driver,20);
		updated.until(ExpectedConditions.visibilityOf(index.getRecordUpdateSucess()));
		
		assertTrue(index.getRecordUpdateSucess().getText().contains("Record has been successfully updated! Please wait a moment"));
		
		
	}
	
	@After
	public void shutDown() {
		driver.close();
	}
	
	
}
