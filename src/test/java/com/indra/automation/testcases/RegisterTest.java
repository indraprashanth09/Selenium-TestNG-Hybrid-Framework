package com.indra.automation.testcases;

import com.indra.automation.base.*;

import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.indra.automation.utils.Utils;

public class RegisterTest extends Base {

	WebDriver driver;
	
	public RegisterTest()
	{
		super();
	}

	@BeforeMethod
	public void setUp() {
		
		driver= intializeBrowser(prop.getProperty("browserName"));

	}

	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}

	@Test
	public void registerWithValidDetails() {
		
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys("Jack");
		driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys("casino");
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(Utils.generateEmailWithTimestamp());
		driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys("1234567891");
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("Indra@1999");
		driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys("Indra@1999");
		driver.findElement(By.xpath("//input[@name=\"newsletter\"][@value=1]")).click();
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();

		String actualHeading = driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
		Assert.assertEquals(actualHeading, "Your Account Has Been Created!");
		driver.quit();

	}

	@Test
	public void registerWithInvalidEmail() {
		
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys("Jack");
		driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys("casino");
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("indra@gmailcom");
		driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys("1234567891");
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("Indra@1999");
		driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys("Indra@1999");
		driver.findElement(By.xpath("//input[@name=\"newsletter\"][@value=1]")).click();
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();

		String errorMsg = driver
				.findElement(By.xpath("//div[contains(text(),'E-Mail Address does not appear to be valid!')]"))
				.getText();
		Assert.assertEquals(errorMsg, "E-Mail Address does not appear to be valid!");
		driver.quit();

	}

}
