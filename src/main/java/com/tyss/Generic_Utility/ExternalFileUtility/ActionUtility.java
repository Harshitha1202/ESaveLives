package com.tyss.Generic_Utility.ExternalFileUtility;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionUtility 
{
	private	Actions act;
	
	/**
	 * constructor
	 * @param driver
	 */
	public ActionUtility(WebDriver driver)
	{
		act=new Actions(driver);
	}
	
	/**
	 * This method is used to right click on the webelement
	 */
	public void rightClickOnElement(WebDriver driver, WebElement ele)
	{
		act.contextClick(ele).perform();
	} 

		/**
		 *This method is used to press enter
		 * @param driver
		 */
		public void enterKey(WebDriver driver)
		{			
			act.sendKeys(Keys.ENTER).perform();
		}
	
		/**
		 * This method is used to perform mouse Hover action on the web element
		 * @param driver
		 * @param ele
		 */
		public void mouseHover(WebDriver driver, WebElement ele)
		{
			act.moveToElement(ele).perform();
		}
	
		/**
		 *  This method is used to perform drag and drop operations
		 * @param driver
		 * @param source
		 * @param destination
		 */
		public void dragDrop(WebDriver driver, WebElement source , WebElement destination)
		{
			act.dragAndDrop(source, destination).perform();
		}

		/**
		 *  This method is used to perform double click on the element
		 * @param driver
		 * @param ele
		 */
		public void doubleClickOnElement(WebDriver driver, WebElement ele)
		{
			act.doubleClick(ele).perform();
		}
		
		/**
		 *  This method is used to perform double click on the element
		 * @param driver
		 * @param ele
		 */
		public void doubleClick(WebDriver driver)
		{
			act.doubleClick().perform();
		}
	
		/**
		 *  This method is used to perform click operation
		 * @param driver
		 * @param ele
		 */
		public void clickOnElement(WebDriver driver, WebElement ele)
		{
			act.click(ele).perform();
		}
	
		/**
		 *  This method is used to perform click operation anywhere on the window
		 * @param driver
		 */
		public void click(WebDriver driver)
		{
			act.click().perform();
		}
	
		 /**
		  * This method is used to click and hold on a web element
		  * @param driver
		  * @param ele
		  */
		public void clickAndHold(WebDriver driver, WebElement ele)
		{
			act.clickAndHold(ele).perform();
		}
	
		/**
		 *  This method is used to click and hold anywhere on the window
		 * @param driver
		 */
		public void clickHold(WebDriver driver)
		{
			act.clickAndHold().perform();
		}
		
		/**
		 * 
		 * @param driver
		 * @param ele
		 */
		public void contextClickOnElement(WebDriver driver, WebElement ele) 
		{
			act.contextClick(ele).perform();
		}
		
		/**
		 * 
		 * @param driver
		 * 
		 */
		public void contextClick(WebDriver driver) 
		{
			act.contextClick().perform();
		}

}
