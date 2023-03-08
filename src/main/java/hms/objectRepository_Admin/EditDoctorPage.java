package hms.objectRepository_Admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tyss.Generic_Utility.WebDriverUtility;

public class EditDoctorPage {
	
	//declaration
		@FindBy(name = "docname") private WebElement UpdateDoctorNameTextField;
		@FindBy(name = "clinicaddress") private WebElement UpdateClinicAdressTextField;
		@FindBy(name = "docfees") private WebElement UpadteDoctorFeesTextField;
		@FindBy(name = "doccontact") private WebElement UpdateDoctorContactNoTextField;
		@FindBy(name= "Doctorspecialization") private WebElement EditDoctorSpecializationDropDown;
		@FindBy(xpath = "//button[@type=\"submit\"]") private WebElement UpdateButton;
		@FindBy(xpath = "//h5[contains(text(), 'updated Successfully')]") private WebElement UpdateSucessText;
		//initialization
		public EditDoctorPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		//utilization (BUSINESS LOGIC)
		public void EditDoctorAction(String updatedDoctorName, String updatedClinicAddress, 
				String updatedDoctorFees, String updatedDoctorContactNo )
		{
			UpdateDoctorNameTextField.clear();
			UpdateClinicAdressTextField.clear();
			UpadteDoctorFeesTextField.clear();
			UpdateDoctorContactNoTextField.clear();
			UpdateDoctorNameTextField.sendKeys(updatedDoctorName);
			UpdateClinicAdressTextField.sendKeys(updatedClinicAddress);
			UpadteDoctorFeesTextField.sendKeys(updatedDoctorFees);
			UpdateDoctorContactNoTextField.sendKeys(updatedDoctorContactNo);
			UpdateButton.click();
		}
		
		public void EditDoctorSpecializationDropDownAction(WebDriverUtility webdriverutil, String visitext)
		{
			webdriverutil.select(EditDoctorSpecializationDropDown, visitext);
		}
		
		public String DoctorDetailsUpdateVerificationAction()
		{
			return UpdateSucessText.getText();
		}

}
