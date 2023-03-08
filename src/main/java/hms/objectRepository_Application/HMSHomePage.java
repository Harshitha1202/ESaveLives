package hms.objectRepository_Application;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HMSHomePage {
	//declaration
		@FindBy(xpath = "//a[@href='hms/admin']") private WebElement AdminLoginLink;
		@FindBy(xpath = "//a[@href='hms/user-login.php']") private WebElement PatientLoginLink;
		@FindBy(xpath = "//a[@href='hms/doctor/']") private WebElement DoctorLoginLink;
		
		@FindBy(xpath = "//a[.='Hospital Management system']") private WebElement HomeTitle;
			
		
		public HMSHomePage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
			
		//utilization (BUSINESS LOGIC)
		public void Home_AdminAction()
		{
			AdminLoginLink.click();
		}
		
		public void Home_PatientAction()
		{
			PatientLoginLink.click();
		}
		
		public void Home_DoctorAction()
		{
			DoctorLoginLink.click();
		}
		
		public String ApplicationHomeTitleVerificationAction()
		{
			String Title = HomeTitle.getText();
			return Title;
		}


}
