package hms.objectRepository_Doctor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManagePatientPage {
	//declaration
			@FindBy(xpath= "(//i[@class=\"fa fa-eye\"])[last()]") private WebElement ViewIcon;
			@FindBy(xpath = "//button[contains(text(), 'Add Medical History')]") private WebElement AddMedicalHistoryButton;
		
			
			//initialization
			public ManagePatientPage(WebDriver driver)
			{
				PageFactory.initElements(driver, this);
			}
			
			//utilization (BUSINESS LOGIC)
			public void ViewPatientAction()
			{
				ViewIcon.click();
			}

			public void AddMedicalHistoryButtonAction()
			{
				AddMedicalHistoryButton.click();
			}
}
