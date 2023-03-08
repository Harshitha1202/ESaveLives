package hms.objectRepository_Doctor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddPatientPage {
	//declaration
			@FindBy(name = "patname") private WebElement PatientNameTextField;
			@FindBy(name = "patcontact") private WebElement PatientContactTextField;
			@FindBy(name = "patemail") private WebElement PatientEmailTextField;
			@FindBy(xpath = "//label[@for=\"rg-female\"]") private WebElement PatientGenderRadioButton;
			@FindBy(name = "pataddress") private WebElement PatientAddressTextField;
			@FindBy(name = "patage") private WebElement PatientAgeTextField;
			@FindBy(name = "medhis") private WebElement PatientMedicalHistoryTextField;
			@FindBy(id = "submit") private WebElement OkButton;
			
			//initialization
			public AddPatientPage(WebDriver driver)
			{
				PageFactory.initElements(driver, this);
			}
			
			//utilization (BUSINESS LOGIC)
			public void AddPatientAction(String patientname, String patientcontact, 
					String patientemail, String patientaddress ,String patientage, String patientmedhistory)
			{
				PatientNameTextField.sendKeys(patientname);
				PatientContactTextField.sendKeys(patientcontact);
				PatientEmailTextField.sendKeys(patientemail);
				//PatientGenderRadioButton.sendKeys(null);
				PatientAddressTextField.sendKeys(patientaddress);
				PatientAgeTextField.sendKeys(patientage);
				PatientMedicalHistoryTextField.sendKeys(patientmedhistory);
				OkButton.click();
			}

}
