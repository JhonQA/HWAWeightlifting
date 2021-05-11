package com.qa.weightlifting.selenium;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.weightlifting.index.WeightliftingIndex;

public class IndexPageTest {
	private WebDriver driver;
	
	@Before
	public void init() {
	
	System.setProperty("webdriver.chrome.driver", "src/test/java/chromedriver.exe");
	
	ChromeOptions options = new ChromeOptions();
	options.setHeadless(false);
	
	driver = new ChromeDriver(options);
	
	driver.manage().window().setSize(new Dimension(1366,763));
}
	
	@Test
	public void getWeightlifting() {
		driver.get(WeightliftingIndex.URL);
		assertEquals("Weightlifting", driver.getTitle());
	}
	
	@Test
	public void insertModal() {
		driver.get(WeightliftingIndex.URL);
		WeightliftingIndex index = PageFactory.initElements(driver, WeightliftingIndex.class);
		index.getInsertModal().click();
		assertTrue(index.getInsertModalWindow().getTagName().contains("h5"));
	}
	
	@Test
	public void submitButton() {
		driver.get(WeightliftingIndex.URL);
		WeightliftingIndex index = PageFactory.initElements(driver, WeightliftingIndex.class);

		index.getInsertModal().click();
		index.createRecord("Jhon", "Urrego", 140, 100, 80);
//		
//		WebDriverWait wait = new WebDriverWait(driver,5);
//		
//		
		index.getSubmitModal().click();
//		
		assertTrue(index.getRecordInsertedSucess().getText().contains("Record has been successfully created! Please wait a moment"));
//		
		
		
		
	}
	
//	@After
//	public void shutDown() {
//		driver.close();
//	}
}
