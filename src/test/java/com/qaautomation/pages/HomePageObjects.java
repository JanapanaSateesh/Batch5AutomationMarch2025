package com.qaautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.qaautomation.commonactions.Commands;
import com.qaautomation.utilities.TestNGListner;

public class HomePageObjects {
	WebDriver driver;
	LoginPageObjects loginpage;
	
   public HomePageObjects(WebDriver driver) {
	   loginpage=new LoginPageObjects(driver);
	   this.driver=driver;
	   PageFactory.initElements(driver, this);
   }
   
   @FindBy(xpath = "//a[text()='Insurance Project']")
   private WebElement object_insuranceproject_tab;
   
   public void ClickOnInsuranceProjectTab() {
	   try {
		   ExtentTest test=TestNGListner.extentThreadLocal.get();
		   object_insuranceproject_tab.click();
		   test.info("Clicked on insurance project tab");
	   }catch (Exception e) {
		// TODO: handle exception
		   throw e;
	}
	   
   }
   
   public void VerifyInsuranceTab(String username, String password,String expectedisurancetabtitle) throws InterruptedException {
	   loginpage.GenericLogin(username, password);
	   ClickOnInsuranceProjectTab();
	   Thread.sleep(2000);
	   String actualTitle=Commands.getTitle(driver);
	   Commands.CompareStringAssertions(actualTitle, expectedisurancetabtitle);
   }
}
