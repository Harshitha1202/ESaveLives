package com.tyss.Generic_Utility;

import java.io.File;
import java.io.IOException;
import java.util.Base64;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.tyss.Generic_Utility.ExternalFileUtility.SystemDateUtility;

public class JavaUtility {
	private WebDriver driver;
	
	public JavaUtility(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	// 1. Get random num
	/**
	 * This method is returns the random integer values
	 * @return
	 */
	public  int getRandomNumber(int boundryValue)
	{
		Random rd = new Random();
		int ranDom = rd.nextInt(boundryValue);
		return ranDom;
	}
	/**
	 * this method is used to decode the decrypted string 
	 * @param s
	 * @return
	 */
	public String Decrypt(String s)
	{
		return new String(Base64.getDecoder().decode(s.getBytes())) ;
	}
	
	/**
	 * this method is used to encrypt the string 
	 * @param s
	 * @return
	 */
	public String Encrypt(String s)
	{
		return new String(Base64.getEncoder().encodeToString(s.getBytes()));
	}
	
	/**
	 * this method is used to capture a screenshot of a page
	 * @param pageName
	 * @param systemDate
	 * @throws IOException
	 */
	public String capturePageScreenShot(String pageName, SystemDateUtility systemDateUtil)
	{
		TakesScreenshot shot = (TakesScreenshot)driver;
		File src = shot.getScreenshotAs(OutputType.FILE);
		File dst = new File("./screenshot/pages/"+ pageName +systemDateUtil.getCurrentDateAndTime()+".png");
		try {
			FileUtils.copyFile(src, dst);
		} catch (IOException e) {
			
		}
		return dst.getAbsolutePath();
	}
	
	
	/**
	 * this method is used to capture a screenshot of an element
	 * @return 
	 * @throws IOException 
	 */
	public String captureElementScreenShot(WebElement ele, String elementName, SystemDateUtility systemDateUtil) throws IOException 
	{
		File src = ele.getScreenshotAs(OutputType.FILE);
		File dst = new File("./screenshot/elements/"+ elementName +"_"+systemDateUtil.getCurrentDateAndTime()+ ".png");
		FileUtils.copyFile(src, dst);
		return dst.getAbsolutePath();
	}
	
	/**
	 * this method is used to take the screen shot using base 64
	 * @return
	 */
	public String getScreenShot()
	{
		TakesScreenshot shot= (TakesScreenshot)driver;
		String path= shot.getScreenshotAs(OutputType.BASE64);
		return path;
	}
	
	

}
