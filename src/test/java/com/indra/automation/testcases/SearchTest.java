package com.indra.automation.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.indra.automation.base.*;

public class SearchTest extends Base {

	public SearchTest()
	{
		super();
	}
	
	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		
		driver = intializeBrowser(prop.getProperty("browserName"));
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void searchExistingProduct()
	{
		driver.findElement(By.xpath("//input[@name=\"search\"]")).sendKeys("HP");
		driver.findElement(By.xpath("//button[@class=\"btn btn-default btn-lg\"]")).click();
		AssertJUnit.assertTrue(driver.findElement(By.linkText("HP LP3065")).isDisplayed());
		
	}
	
	@Test
	public void searchNonExistingProduct()
	{
		driver.findElement(By.xpath("//input[@name=\"search\"]")).sendKeys("Honda");
		driver.findElement(By.xpath("//button[@class=\"btn btn-default btn-lg\"]")).click();
		String message = driver.findElement(By.xpath("//p[contains(text(),'There is no product that matches the search criteria')]")).getText();
		AssertJUnit.assertEquals(message, "There is no product that matches the search criteria.");
	}
	
	@Test
	public void searchNoProduct()
	{
		driver.findElement(By.xpath("//input[@name=\"search\"]")).clear();
		driver.findElement(By.xpath("//button[@class=\"btn btn-default btn-lg\"]")).click();
		String message = driver.findElement(By.xpath("//p[contains(text(),'There is no product that matches the search criteria')]")).getText();
		AssertJUnit.assertEquals(message, "There is no product that matches the search criteria.");
	}

}
