package com.qaautomation.functionaltests;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.qaautomation.utilities.ReadConfigData;

public class BaseClass {

	//public WebDriver driver;
	//comment from git hub
	public ReadConfigData readconfigdata;
	
	ThreadLocal<WebDriver> threadlocaldriver=new ThreadLocal<WebDriver>();
	
	@BeforeMethod(alwaysRun = true)
	public void SetUp(ITestContext context) throws IOException {
		readconfigdata=new ReadConfigData();
		String url=readconfigdata.getUrl();
		
		//driver=new ChromeDriver();
		threadlocaldriver.set(new ChromeDriver());
		context.setAttribute("driver", threadlocaldriver.get());
		threadlocaldriver.get().get(url);
		threadlocaldriver.get().manage().window().maximize();
		
		WebDriverWait wait =new WebDriverWait(threadlocaldriver.get(), Duration.ofSeconds(10));
		
	}
	
	@AfterMethod(alwaysRun = true)
	public void TearDown() {
		threadlocaldriver.get().quit();
	}
	
	
	
}
