package com.indra.automation.testcases;

import com.indra.automation.base.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class LoginTest extends Base {
	
	public LoginTest()
	{
		super();
	}

	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		driver=intializeBrowser(prop.getProperty("browserName"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void loginTestWithValidCredentials() {

		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(prop.getProperty("userName"));
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());

	}

	
}
