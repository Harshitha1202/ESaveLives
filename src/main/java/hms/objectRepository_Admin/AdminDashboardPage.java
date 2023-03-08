package hms.objectRepository_Admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminDashboardPage {
	//declaration
		@FindBy(xpath = "//span[contains(text(), ' Doctors ')]" ) private WebElement AdminDoctorButton;
		@FindBy(xpath ="//span[contains(text(), ' Doctor Specialization ')]" ) private WebElement AddSpecializationButton;
		@FindBy(xpath = "//span[.= ' Add Doctor']") private WebElement AddDoctorButton;
		@FindBy(xpath = "//span[contains(text(), ' Manage Doctors ')]") public WebElement  ManageDoctorButton;
		@FindBy(xpath = "//i[@class='ti-angle-down']") private WebElement AdminLogoutDropDown;
		@FindBy(xpath = "//a[contains(text(), 'Log Out')]") private WebElement AdminLogoutButton ;
		@FindBy(xpath = "//span[.=' Appointment History ']") private WebElement AppointmentHistoryTab;
		@FindBy(xpath = "//h1[.='Admin | Dashboard']") private WebElement HomeTitle;
		@FindBy(xpath = "//span[.=' Patients ']") private WebElement PatientTab;
		@FindBy(xpath = "//span[.=' Manage Patients ']") private WebElement ManagePatientTab;

		public AdminDashboardPage(WebDriver driver)
		{	
			
			PageFactory.initElements(driver, this);
		}
			
		//utilization (BUSINESS LOGIC)
		public void AdminDoctorAction()
		{
			AdminDoctorButton.click();
		}
		
		public void AddSpecializationAction()
		{
			AddSpecializationButton.click();
		}
		
		public void AddDoctorAction()
		{
			AddDoctorButton.click();
		}
		
		public void ManageDoctorAction()
		{
			ManageDoctorButton.click();
		}
		
		public void AdminLogout()
		{
			AdminLogoutDropDown.click();
			AdminLogoutButton.click();
		}
		
		public String AdminHomePageVerificationAction()
		{
			String AdminHomeTitle = HomeTitle.getText();
			return AdminHomeTitle;
		}
		
		public void ClickAppointmentHistoryAction()
		{
			AppointmentHistoryTab.click();
		}
		
		public void ClickPatientTab()
		{
			PatientTab.click();
			ManagePatientTab.click();
		}

}
