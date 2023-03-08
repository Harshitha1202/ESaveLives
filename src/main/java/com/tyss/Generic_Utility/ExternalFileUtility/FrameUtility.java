package com.tyss.Generic_Utility.ExternalFileUtility;

import org.openqa.selenium.WebDriver;

import com.tyss.Generic_Utility.WebDriverUtility;

public class FrameUtility {
	/**
	 * this method is used to switch to the frame using index
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}
	/**
	 * this method is used to switch to the frame using id_name attribute
	 * @param driver
	 * @param id_Name
	 */
	public void switchToFrame(WebDriver driver, String id_Name)
	{
		driver.switchTo().frame(id_Name);
	}

}
