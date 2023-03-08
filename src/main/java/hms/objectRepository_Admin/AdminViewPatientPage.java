package hms.objectRepository_Admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminViewPatientPage {
	
	//declaration
			@FindBy(xpath = "(//i[@class='fa fa-eye'])[last()]" ) private WebElement ViewIcon;
			@FindBy(xpath = "(//td[.='Nicholas'])[last()]") private WebElement PatientVerificationName;

			public AdminViewPatientPage(WebDriver driver)
			{	
				
				PageFactory.initElements(driver, this);
			}
				
			//utilization (BUSINESS LOGIC)
			public void ViewPatientHistory()
			{
				ViewIcon.click();
			}
			
			public String PatientHistoryVerification()
			{
				return PatientVerificationName.getText();
			}

}
