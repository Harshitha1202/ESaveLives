package hms.objectRepository_Admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tyss.Generic_Utility.WebDriverUtility;

public class AddDoctorPage {
	
	//declaration
	@FindBy(name = "docname") private WebElement DoctorNameTextField;
	@FindBy(name = "clinicaddress") private WebElement ClinicAdressTextField;
	@FindBy(name = "docfees") private WebElement DoctorFeesTextField;
	@FindBy(name = "doccontact") private WebElement DoctorContactNoTextField;
	@FindBy(name = "docemail") private WebElement DoctorEmailTextField;
	@FindBy(name = "npass") private WebElement NewPasswordTextField;
	@FindBy(name = "cfpass") private WebElement ConfirmPasswordTextField;
	@FindBy(name= "Doctorspecialization") private WebElement SelectDoctorDropDown;
	@FindBy(name = "submit") private WebElement CreateButton;
	@FindBy(xpath = "//h1[.='Admin | Add Doctor']") private WebElement AddDoctorPageMessage;
	
	
	//initialization
	public AddDoctorPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//utilization (BUSINESS LOGIC)
	public void AddDoctorAction(String doctorName, String clinicAddress, 
			String doctorFees, String doctorContactNo ,String doctorEmail, String newPassword, String confirmPassword)
	{
		DoctorNameTextField.sendKeys(doctorName);
		ClinicAdressTextField.sendKeys(clinicAddress);
		DoctorFeesTextField.sendKeys(doctorFees);
		DoctorContactNoTextField.sendKeys(doctorContactNo);
		DoctorEmailTextField.sendKeys(doctorEmail);
		NewPasswordTextField.sendKeys(newPassword);
		ConfirmPasswordTextField.sendKeys(confirmPassword);
		CreateButton.click();
	}
	
	public void SelectDoctorDropDownAction(WebDriverUtility webdriverutil, String visitext)
	{
		
		webdriverutil.select(SelectDoctorDropDown, visitext);
	}

	public String AddDoctorPageVerification()
	{
		return AddDoctorPageMessage.getText();
	}

}
