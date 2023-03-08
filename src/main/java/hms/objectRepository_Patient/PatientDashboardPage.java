package hms.objectRepository_Patient;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PatientDashboardPage {
	
	//declaration
	@FindBy(xpath = "//span[contains(text(), ' Book Appointment ')]") private WebElement BookAppointmentButton;
	@FindBy(xpath = "//i[@class=\"ti-angle-down\"]") private WebElement PatientLogoutDropDown;
	@FindBy(xpath = "//a[contains(text(), 'Log Out')]") private WebElement PatientLogoutButton;
	
	@FindBy(xpath = "//h1[text()='User | Dashboard']") private WebElement HomeTitle;
	

	
	public PatientDashboardPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
		
	//utilization (BUSINESS LOGIC)
	public void DashboardBookAppointmentAction()
	{
		BookAppointmentButton.click();
	}
	
	public void PatientLogoutAction()
	{
		PatientLogoutDropDown.click();
		PatientLogoutButton.click();
	}
	
	public String PatientHomePageVerification()
	{
		 String PatientHomeTitle = HomeTitle.getText();
		 return PatientHomeTitle;
	}

}
