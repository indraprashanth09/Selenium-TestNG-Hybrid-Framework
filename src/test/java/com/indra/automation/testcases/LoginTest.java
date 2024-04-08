package com.indra.automation.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.Assert;
import com.indra.automation.base.*;
import com.indra.automation.utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
	
	@Test(dataProvider = "validCredentials")
	public void loginTestWithValidCredentials(String email, String password) {

		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());

	}
	
	@DataProvider(name = "validCredentials")
	public Object[][] supplyData() {
		Object[][] data= Utils.getExcelData("ValidData");
		return data;
	}

	
}
