package com.tyss.Generic_Utility.Listener;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.tyss.Generic_Utility.JavaUtility;
import com.tyss.Generic_Utility.WebDriverUtility;
import com.tyss.Generic_Utility.Constants.ReportUtility;
import com.tyss.Generic_Utility.ExternalFileUtility.SystemDateUtility;

public class ListenerBaseClass {

	public SystemDateUtility systemdateutil;
	public WebDriver driver;
	public WebDriverUtility webdriverutil;
	public JavaUtility javautil;
	protected ReportUtility report;
	public ExtentTest test;
	

	@BeforeSuite
	public void suitesetup()
	{
		System.out.println("beforesuite");
	}
	
	@BeforeTest
	public void testsetup()
	{
		System.out.println("beforetest");
	}
	
	@BeforeClass
	public void classsetup()
	{
		System.out.println("beforeclass");
		
		systemdateutil= new SystemDateUtility();
		webdriverutil=new WebDriverUtility();
		driver= webdriverutil.setBrowser("chrome");
		javautil= new JavaUtility(driver);

	}
	
	@BeforeMethod
	public void methodsetup()
	{
		System.out.println("beforemethod");
	}
	
	
	@AfterMethod
	public void methodteardown()
	{
		System.out.println("aftermethod");
	}
	
	@AfterClass
	public void classteardown()
	{
		System.out.println("afterclass");
	}

	@AfterTest
	public void testteardown()
	{
		System.out.println("aftertest");
		driver.quit();
	}
	
	@AfterSuite
	public void suiteteardown()
	{
		System.out.println("aftersuite");
	}
}
