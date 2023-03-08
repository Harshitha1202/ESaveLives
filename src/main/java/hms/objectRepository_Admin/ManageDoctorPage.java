package hms.objectRepository_Admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageDoctorPage {
	//declaration
		@FindBy(xpath = "(//i[@class='fa fa-times fa fa-white'])[last()]") private WebElement DeleteIcon;
		@FindBy(xpath= "(//i[@class='fa fa-pencil'])[last()]") private WebElement EditIcon;
		
		@FindBy(xpath= "//p[contains(text(),'data del')]") private WebElement DeleteDoctorMsg;
		@FindBy(xpath = "//h1[.='Admin | Manage Doctors']") private WebElement ManageDoctorPageText;
		
	
		
		//initialization
		public ManageDoctorPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		//utilization (BUSINESS LOGIC)
		public void DeleteDoctorAction()
		{
			DeleteIcon.click();
		}
		
		public void EditDoctorAction()
		{
			EditIcon.click();
		}
		
		public String DoctorDeleteVerificationAction()
		{
			String DeleteConfirmation = DeleteDoctorMsg.getText();
			return DeleteConfirmation;
		}

		public String ManageDoctorPageVerificationAction()
		{
			return ManageDoctorPageText.getText();
		}
		
	
		
}

