package hms.objectRepository_Doctor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tyss.Generic_Utility.ExternalFileUtility.VerificationUtility;

public class DoctorDashboardPage {
	//declaration
			@FindBy(xpath ="//a[@href='appointment-history.php']" ) private WebElement AppointmentHistoryButton;
			@FindBy(xpath = "//span[contains(text(), \" Patients \")]") private WebElement PatientButton;
			@FindBy(xpath = "//span[contains(text(), \" Add Patient\")]") private WebElement AddPatientButton;
			@FindBy(xpath= "//span[contains(text(),  'Manage Patient')]") private WebElement ManagePatientButton;
			@FindBy(xpath= "//span[@class='username']") private WebElement LogoutDropDownButton;
			@FindBy(xpath= "//a[@href='logout.php']") private WebElement LogoutButton;
			
			@FindBy(xpath= "//span[.='Dashboard']") private WebElement ActualVerificationTitle;
			
			public DoctorDashboardPage(WebDriver driver)
			{
				PageFactory.initElements(driver, this);
			}
				
			//utilization (BUSINESS LOGIC)
			public void DashboardAppointHistoryAction()
			{
				AppointmentHistoryButton.click();
			}
			
			public void DashboardPatientAction()
			{
				PatientButton.click();
			}
			
			public void DashboardAddPatientAction()
			{
				AddPatientButton.click();
			}
			
			public void DashboardManagePatientAction()
			{
				ManagePatientButton.click();
			}
			
			public void DashboardDoctorLogoutAction()
			{
				LogoutDropDownButton.click();
				LogoutButton.click();
			}
			
			public String DoctorHomePageVerificationAction( )
			{
				String DoctorHomePage = ActualVerificationTitle.getText();
				return DoctorHomePage;
			}
			
			

}
