package hms.objectRepository_Doctor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DoctorLoginPage {
	//declaration
		@FindBy(xpath = "//input[@name='username']") private WebElement doctorUserNameTextField;
		@FindBy(xpath = "//input[@name='password']") private WebElement doctorPasswordTextField;
		@FindBy(xpath = "//button[@name='submit']") private WebElement doctorLoginButton;
		
		//initialization
		public DoctorLoginPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		//utilization (BUSINESS LOGIC)
		public void DoctorLoginAction(String username, String password)
		{
			doctorUserNameTextField.sendKeys(username);
			doctorPasswordTextField.sendKeys(password);
			doctorLoginButton.click();
		}

}
 