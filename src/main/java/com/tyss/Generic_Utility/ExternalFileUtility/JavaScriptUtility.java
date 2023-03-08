package com.tyss.Generic_Utility.ExternalFileUtility;

import java.awt.Window;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtility {
	JavascriptExecutor js;
	
	/**
	 * 
	 * @param driver
	 */
	public JavaScriptUtility(WebDriver driver)
	{
		js=(JavascriptExecutor)driver;
	}
	
	/**
	 * this method is used to scroll down
	 */
	public void scrollDown()
	{
		js.executeScript("window.scrollBy(0, document.body.scrollHeight)");
				
	}
	
	/**
	 * this method is used to scroll up
	 */
	public void scrollUp()
	{
		js.executeScript("window.scrollBy(0, -document.body.scrollHeight)");
				
	}
	
	/**
	 * this method is used to scroll until the element is visible
	 * @param element
	 */
	public void scrollTillElement(WebElement element)
	{
		js.executeScript("arguments[0].scrollIntoView", element);
	}

	/**
	 * this method is used to scroll until the element is visible and click
	 * @param element
	 */
	public void click(WebElement element)
	{
		js.executeScript("agruments[0].click()", element);
	}
	
	/**
	 * this method is used to fetch the url
	 * @param url
	 */
	public void launchApplication(String url)
	{
		js.executeScript("window.location=arguments[0]", url);
	}
	
	/**
	 * 
	 * @param element
	 * @param data
	 */
	public void sendKeys(WebElement element, String data)
	{
		js.executeScript("agruments[0].value=agrguments[1]", element, data);
	}
	
	/**
	 * This method is used to highlight the specified element
	 * @param element
	 */
	public void highlight(WebElement element) 
	{
		js.executeScript("arguments[0].setAttribute('style','border:6px solid red;');",element);
	}

	
}






