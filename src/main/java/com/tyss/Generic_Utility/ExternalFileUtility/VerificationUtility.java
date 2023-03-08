package com.tyss.Generic_Utility.ExternalFileUtility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerificationUtility {
	


	/**
	 * the method is to verify the condition with actual string
	 * @param actual
	 * @param expected
	 * @throws IOException 
	 */
	public void verifyPage(String actual, String expected)
	{
		if(actual.equals(expected))
		{ 
			System.out.println(expected  + "page displayed");
		}
		else
		{
			System.out.println(expected  + "page not displayed");
			
		}
	}
	
	/**
	 * the method is to verify the condition with partial string
	 * @param actual
	 * @param expected
	 */
	public void verifyPageContains(String actual, String expected)
	{
		if(actual.contains(expected))
		{
			System.out.println(expected  + "page displayed");
		}
		else
		{
			System.out.println(expected  + "page not displayed");
		}
	}
	
	
	
	/**
	 * this method is used to do exact verification for page or test case or element
	 * @param actual
	 * @param expected
	 * @param strategy
	 * @param pageORelementORTCname
	 */
	public void exactVerify(String actual, String expected, String strategy, String pageORelementORTCname)
	{
		String pass="";
		String fail="";
		switch(strategy.toUpperCase())
		{
		case "TC":
			pass= "TC pass";
			fail= "TC failed";
			break;
			
		case "PAGE":
			pass= "page displayed";
			fail= "page not displayed";
			break;
			
		case "ELEMENT":
			pass= "is present";
			fail= "is not present";
			break;
			
		default:
			break;
		}
		
		if(actual.equals(expected))
			System.out.println(pageORelementORTCname + pass);
		else
			System.out.println(pageORelementORTCname + fail);	
		
	}
	
	public void validateData(String actualdata, String expecteddata)
	{
		 if(actualdata.contains(expecteddata))
		    	System.out.println("add data is successful");
		    else
		    	System.out.println("add data is not unsuccessful");
	}
	
	
}
