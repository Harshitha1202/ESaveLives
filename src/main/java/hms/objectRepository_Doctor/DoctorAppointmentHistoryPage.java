package hms.objectRepository_Doctor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DoctorAppointmentHistoryPage {
	// declaration
		@FindBy(xpath = "(//a[@title='Cancel Appointment'])[last()]") private WebElement CancelButton;
		
		
		//initialization
			public DoctorAppointmentHistoryPage(WebDriver driver)
			{
				PageFactory.initElements(driver, this);
			}
			
			
			
			public void CancelAppointmentAction()
			{
				CancelButton.click();
			}

}
