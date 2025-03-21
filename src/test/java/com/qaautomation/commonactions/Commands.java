package com.qaautomation.commonactions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.qaautomation.utilities.TestNGListner;

public class Commands {

	public static String getTitle(WebDriver driver) {
		
		String title=driver.getTitle();
		return title;
	}
	
	public static void CompareStringAssertions(String actual, String expected) {
		ExtentTest test=TestNGListner.extentThreadLocal.get();
		String actualValueAfterTrim=actual.trim();
		Assert.assertEquals(actualValueAfterTrim, expected);
		test.info("Verified the actual and expected messages: "+" Actual is: "+actualValueAfterTrim+" Expected is: "+expected);
	}
	
	public static String SwithToAlertAndGetAlertMessage(WebDriver driver) {
		String alertmessage=driver.switchTo().alert().getText();
		return alertmessage;
	}
	
	public static void SwitchtToAlertAndAccept(WebDriver driver) {
		ExtentTest test=TestNGListner.extentThreadLocal.get();
		driver.switchTo().alert().accept();
		test.info("Accpeted the alert");
	}
	
}
