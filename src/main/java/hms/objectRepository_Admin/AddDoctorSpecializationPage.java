package hms.objectRepository_Admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tyss.Generic_Utility.ExternalFileUtility.VerificationUtility;

public class AddDoctorSpecializationPage {
	
	//declaration
			@FindBy(name = "doctorspecilization" ) private WebElement AddDoctorSpecailizationTextField;
			@FindBy(name = "submit" ) private WebElement AddButton;
			@FindBy(xpath = "//p[contains(text(), 'Specialization added successfully')]") private WebElement SuccessMessage;

	public AddDoctorSpecializationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
		
	//utilization (BUSINESS LOGIC)
	public void AddDoctorSpecializationAction(String doctorSpectialization)
	{
		AddDoctorSpecailizationTextField.sendKeys(doctorSpectialization);
		AddButton.click();
	}
	
	public String AddSpecializationSuccessVerification()
	{
		return SuccessMessage.getText();
	}

}
