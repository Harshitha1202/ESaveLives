package hms.objectRepository_Admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.tyss.Generic_Utility.Enums.AdminDashboardTabNames;

public class AdminDashboardDXpathPage {
	
	private WebDriver driver;
	
	//declaration
	private String adminDashBoardDynamicXpath= "//span[contains(text(), ' %s ')]";
	
	private WebElement ConvertToWebElement(String partialXpath, String replaceData)
	{
		String xpath= String.format(partialXpath, replaceData);
		return driver.findElement(By.xpath(xpath));
	}
	
	//initialize
	public AdminDashboardDXpathPage(WebDriver driver)
	{	
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	public void clickAdminDashboardTab(AdminDashboardTabNames tabName)
	{
		ConvertToWebElement(adminDashBoardDynamicXpath, tabName.getTab()).click();
	}

}
