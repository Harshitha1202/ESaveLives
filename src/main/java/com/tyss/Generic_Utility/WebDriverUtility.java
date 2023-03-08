package com.tyss.Generic_Utility;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.ISelect;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;
import com.tyss.Generic_Utility.ExternalFileUtility.SystemDateUtility;

import io.github.bonigarcia.wdm.WebDriverManager;



public class WebDriverUtility 
{
	private WebDriver driver;
	
	
 
	/**
	 * This method is used to set a browser and launch
	 * @param browser
	 * @return 
	 * @return 
	 */
	public WebDriver setBrowser(String browser) 
	{
		switch(browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			break;
		case "ie":
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			break;	
		}
		return driver;
	}
	
	
	/**
	 * This method is used handle the drop down
	 * @param ele
	 * @param text
	 */
	public void select(WebElement ele, String visitext)
	{
		Select s= new Select(ele);
		s.selectByVisibleText(visitext);
		
		
	}
	
	/**
	 * This method is used to handle the drop down using index
	 * @param element
	 * @param index
	 */
	public void select(WebElement element, int index)
	{
		Select s_index= new Select(element);
		s_index.selectByIndex(index);
		
	}
	
	
	/**
	 * This method is used to close the browser
	 * @param driver
	 */
	public void closeApplication()
	{
		driver.quit();
	}
	
	/**
	 * This method is used to close the window
	 * @param driver
	 */
	public void closeWindow()
	{
		driver.close();
	}
	
	/**
	 * This method is used to get the url of the current web page
	 * @param driver
	 */
	public void getUrl()
	{
		driver.getCurrentUrl();
	}
	
	/**
	 * This method is used to maximize the window
	 * @param driver
	 */
	public void windowMaximize()
	{
		driver.manage().window().maximize();
	}
	
	/**
	 *  This method is used to title name of the page
	 * @param driver
	 */
	public void getTitle(WebDriver driver)
	{
		driver.getTitle();
	}
	
	/**
	 *  This method is used to get class name
	 * @param driver
	 */
	public void getclass(WebDriver driver)
	{
		driver.getClass();
	}	
	
	/**
	 *  This method is used to accept the handle pop up
	 * @param driver
	 */
	public void handleAlertAccept(WebDriver driver)
	{
		 driver.switchTo().alert().accept();
	}
	
	/**
	 *  This method is used to dismiss the handle pop up
	 * @param driver
	 */
	public void handleAlertDismiss(WebDriver driver)
	{
		 driver.switchTo().alert().dismiss();
	}
	
	/**
	 * this method is used to fetch the url
	 * @param url
	 */
	public void fetchUrl(String url)
	{
		driver.get(url);
	}
	
	/**
	 * this method is used to resize the browser window with specified dimension
	 * @param width
	 * @param height
	 */
	public void resizeBrowser(int width, int height)
	{
		driver.manage().window().setSize(new Dimension(width, height));
		
	}
	
	
	
}













