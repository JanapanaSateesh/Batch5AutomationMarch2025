package com.qaautomation.functionaltests;

import org.testng.annotations.Test;

import com.qaautomation.pages.HomePageObjects;
import com.qaautomation.pages.LoginPageObjects;
import com.qaautomation.utilities.ReadDataFromDataproviders;

public class HomePageTests extends BaseClass {
	HomePageObjects homepage;

	@Test(priority = 1, dataProviderClass = ReadDataFromDataproviders.class, dataProvider = "TC006_TestData",groups = {"sanity","regression","homepagefeature"})
	public void TC006_InsurnaceProjectTabValidation(String username, String password, String expectedinusrancetitle) throws InterruptedException {
		homepage=new HomePageObjects(threadlocaldriver.get());
		homepage.VerifyInsuranceTab(username, password, expectedinusrancetitle);
	}
}
