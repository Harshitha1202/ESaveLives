package hms.objectRepository_Admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Admin_AppointmentHistoryPage {
	//declaration
	
	@FindBy(xpath = "(//div[contains(text(), 'Canceled')])[last()]") private WebElement CancelledText;
	
	
	//initialization
	public Admin_AppointmentHistoryPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//utilization (BUSINESS LOGIC)
	public String VerifyAppointmentCancel()
	{
		return CancelledText.getText();	
	}

}
