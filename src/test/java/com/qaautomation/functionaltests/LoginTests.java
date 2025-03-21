package com.qaautomation.functionaltests;


import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qaautomation.pages.LoginPageObjects;
import com.qaautomation.utilities.ReadDataFromDataproviders;
import com.qaautomation.utilities.TestNGListner;


public class LoginTests extends BaseClass {
	
	LoginPageObjects loginpage;

	@Test(priority = 1, dataProviderClass = ReadDataFromDataproviders.class, dataProvider = "TC001_TestData", groups = {"smoke","regression"})
	public void TC001_LoginWithValidCredentials(String username, String password, String expectedtitle) throws InterruptedException {
		loginpage=new LoginPageObjects(threadlocaldriver.get());
		loginpage.LoginWithValidCredentials(username, password, expectedtitle);		
	}
	
	
	@Test(priority = 2,dataProviderClass = ReadDataFromDataproviders.class, dataProvider = "TC002_TestData",groups = {"smoke","regression"})
	public void TC002_LoginWithInValidCredentials(String username, String Password, String errormessage) throws InterruptedException {
		loginpage=new LoginPageObjects(threadlocaldriver.get());
		loginpage.LoginWithInValidCredentials(username, Password, errormessage);	
	}
	
	
	@Test(priority = 3,groups = {"smoke","regression"})
	public void TC003_LoginWithoutCredentials() throws InterruptedException {
		loginpage=new LoginPageObjects(threadlocaldriver.get());
		loginpage.LoginWithoutCredentials("User or Password is not valid");
		
	}
	
	@Test(priority = 4, dataProviderClass = ReadDataFromDataproviders.class, dataProvider = "TC001_TestData",groups = {"smoke","regression"})
	public void TC004_LoginWithEnter(String username, String password, String expectedtitle) throws InterruptedException {
		loginpage=new LoginPageObjects(threadlocaldriver.get());
		loginpage.LoginWithEnterButton(username, password, expectedtitle);
		
	}

	
	
	
}
