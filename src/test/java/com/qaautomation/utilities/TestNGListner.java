package com.qaautomation.utilities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class TestNGListner implements ITestListener {
	
	ExtentSparkReporter htmlreporter;
	ExtentReports reports;
	ExtentTest test;
	
	public static ThreadLocal<ExtentTest> extentThreadLocal=new ThreadLocal<ExtentTest>();
	
	public void ConfigureReport() {
		LocalDateTime now=LocalDateTime.now();
		DateTimeFormatter formatter=DateTimeFormatter.ofPattern("YYYY_MM_dd_hh_mm_ss");
		String currentdatetime=now.format(formatter);
		
		htmlreporter=new ExtentSparkReporter("./Reports/summaryreport"+currentdatetime+".html");
		htmlreporter.config().setDocumentTitle("Tutorial Point Automation Test Summary Report");
		htmlreporter.config().setTheme(Theme.DARK);
		
		reports=new ExtentReports();
		reports.attachReporter(htmlreporter);
		reports.setSystemInfo("Author", "Sateesh");
		reports.setSystemInfo("Browser", "Chrome");
		reports.setSystemInfo("OS", "Windows");	
	}

	@Override
	public void onTestStart(ITestResult result) {
		
		//TC001_LoginWithValidCredentials
		//TC002_LoginWithInValidCredentials
	    test=reports.createTest(result.getName());
		extentThreadLocal.set(test);
		System.out.println("On Test Start Started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("On Test Succcess Execuetd");
		test=extentThreadLocal.get();
		test.log(Status.PASS, result.getName()+" : is Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("On Test Failure Execuetd");
		test=extentThreadLocal.get();
		
		test.log(Status.FAIL, result.getName()+" : is Failed");
		String errormesg=result.getThrowable().getMessage();
		test.fail(errormesg);
		WebDriver driver= (WebDriver) result.getTestContext().getAttribute("driver");
		
		String base64image=((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);	
		test.addScreenCaptureFromBase64String(base64image);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
	}


	@Override
	public void onStart(ITestContext context) {
		System.out.println("On Overall Start exeuting");
		ConfigureReport();
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("On Overall Finish exeuted");
		reports.flush();
	}

}
