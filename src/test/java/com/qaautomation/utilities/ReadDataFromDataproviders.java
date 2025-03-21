package com.qaautomation.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class ReadDataFromDataproviders {

	@DataProvider
	public String[][] TC001_TestData() throws IOException {
		String[][] data=ReadDataFromExcel.getData("./TestData/LoginTestData.xlsx", "TC001Data");
		return data;
	}
	
	@DataProvider
	public String[][] TC002_TestData() throws IOException {
		String[][] data=ReadDataFromExcel.getData("./TestData/LoginTestData.xlsx", "TC002Data");
		return data;
	}
	
	@DataProvider
	public String[][] TC006_TestData() throws IOException {
		String[][] data=ReadDataFromExcel.getData("./TestData/HomePageTestData.xlsx", "TC006Data");
		return data;
	}
	
}
