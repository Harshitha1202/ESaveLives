package com.tyss.Generic_Utility.ExternalFileUtility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {
	private WebDriver driver;
	
	
	/**
	 * implicitly wait 
	 * @param driver
	 */
	public void implicityWait(WebDriver driver, long timeout)
	{
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
	}
	
	// 2. WEBDRIVER WAIT
	/**
	 * explicitly wait for the condition
	 * @param driver
	 * @param ele
	 */
	public void webDriverWait( WebElement ele, WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	/**
	 * this method waits until the pageurl is loaded
	 * @param driver
	 * @param partialPageUrl
	 */
	public void WebDriverWaitLoadUrl(String partialPageUrl)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.urlContains(partialPageUrl));
	}
	
	/**
	 * this method is used to pause the execution for specified time
	 * @param millisecond
	 */
	public void pause(long millisecond)
	{
		try {
			Thread.sleep(millisecond);
		} catch (InterruptedException e) {
			
		}
	}
	/**
	 * 
	 * @param xpath
	 * @param text
	 */
	public void waitUntilInvisibleOfText(String xpath, String text)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath(xpath), text));
	}

	/**
	 * this method is used to customize the wait until it clicks on the element
	 * @param pollingTime
	 * @param duration
	 * @param element
	 */
	public void customWaitTillClickOnElement(long pollingTime, int duration, WebElement element)
	{
		int count=0;
		while(count<duration)
		{
			try {
				element.click();
				break;
			}
			catch(Exception e)
			{
				try {
					Thread.sleep(pollingTime);
				} catch (InterruptedException e1) {
					
				}
				count++;
			}
		}
		
	}
}
