package com.qaautomation.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.qaautomation.commonactions.Commands;
import com.qaautomation.utilities.TestNGListner;

public class LoginPageObjects {

	WebDriver driver;
	public LoginPageObjects(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//WebElement ele=driver.findElement(By.xpath("//").sendKeys()
	//ele.sendKeys()
	
	
	//-----Below are the Locators---
	@FindBy(xpath="//input[@name='uid']")
	private WebElement object_username;
	
	@FindBy(name = "password")
	private WebElement object_password;
	
	@FindBy(name = "btnLogin")
	private WebElement object_login;
	
	
	//----------Locators Implementations
	public void EnterUserName(String username) {
		try {
			ExtentTest test=TestNGListner.extentThreadLocal.get();
			object_username.sendKeys(username);
			test.info("Entered Username:"+username);
		}catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
		
	}
	
	public void EnterPassword(String password) {
		try {
			ExtentTest test=TestNGListner.extentThreadLocal.get();
			object_password.sendKeys(password);
			test.info("Entered Username: *** ");
		}catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
		
	}
	
	public void LoginButtonClick() {
		try {
			ExtentTest test=TestNGListner.extentThreadLocal.get();
			object_login.click();
			test.info("Logged in Successfully");
		}catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
		
		
	}
	
	public void HitEnterWithPassword() {
		try {
			ExtentTest test=TestNGListner.extentThreadLocal.get();
			object_password.sendKeys(Keys.ENTER);
			test.info("Logged in successfully with enter button");
		}catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
		
	}
	
	
	//--Actual Tests Implementation
	
	public void LoginWithValidCredentials(String username, String Password, String expectedtitle) throws InterruptedException {

		EnterUserName(username);
		EnterPassword(Password);
		LoginButtonClick();	
		Thread.sleep(4000);
		String actualtitle=Commands.getTitle(driver);
		Commands.CompareStringAssertions(actualtitle, expectedtitle);

		
		
	}
	
	public void LoginWithInValidCredentials(String username, String Password, String expectedAlertMessage) throws InterruptedException {

			EnterUserName(username);
			EnterPassword(Password);
			LoginButtonClick();
			Thread.sleep(4000);
			String alertmsg=Commands.SwithToAlertAndGetAlertMessage(driver);
			Commands.CompareStringAssertions(alertmsg, expectedAlertMessage);
			Commands.SwitchtToAlertAndAccept(driver);


		
		
	}
	
	public void LoginWithoutCredentials(String expectedAlertMessage ) throws InterruptedException {

			LoginButtonClick();

			Thread.sleep(4000);
			String alertmsg=Commands.SwithToAlertAndGetAlertMessage(driver);
			Commands.CompareStringAssertions(alertmsg, expectedAlertMessage);
			Commands.SwitchtToAlertAndAccept(driver);


		
	}
	
	public void LoginWithEnterButton(String username, String Password,String expectedtitle) throws InterruptedException {

			EnterUserName(username);
			EnterPassword(Password);

			HitEnterWithPassword();

			Thread.sleep(4000);
			String actualtitle=Commands.getTitle(driver);
			Commands.CompareStringAssertions(actualtitle, expectedtitle);


		
		
	}
	
	///-----------------
	public void GenericLogin(String username, String Password) throws InterruptedException {
		EnterUserName(username);
		EnterPassword(Password);
		LoginButtonClick();	
		Thread.sleep(4000);

	}
	
	
}
