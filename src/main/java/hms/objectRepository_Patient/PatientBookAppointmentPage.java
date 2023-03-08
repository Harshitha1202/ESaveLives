package hms.objectRepository_Patient;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tyss.Generic_Utility.WebDriverUtility;

public class PatientBookAppointmentPage {

	//declaration
			@FindBy(xpath = "//input[@class='form-control datepicker']" ) private WebElement AppointmentDateTextField;
			@FindBy(xpath = "//button[@type=\"submit\"]") private WebElement OkButton;
			@FindBy(name  = "Doctorspecialization") private WebElement DoctorspecializationDropDown;
			@FindBy(name= "doctor") private WebElement DoctorDropDown;

			

			public PatientBookAppointmentPage(WebDriver driver)
			{
				PageFactory.initElements(driver, this);
			}
				
			//utilization (BUSINESS LOGIC)
			public void BookAppointmentAction(String appointmentDate)
			{
				AppointmentDateTextField.click();
				AppointmentDateTextField.sendKeys(appointmentDate);
				OkButton.click();
			}
			
			public void DoctorspecializationDropDownAction( WebDriverUtility webdriverutil, String text )
			{
			
				webdriverutil.select(DoctorspecializationDropDown, text);
			}
			
			public void DoctorDropDownAction(WebDriverUtility webdriverutil, String visitext )
			{
				webdriverutil.select(DoctorDropDown, visitext);
			}
			
}
