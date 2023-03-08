package hms.objectRepository_Patient;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PatientLoginPage 
{
	//declaration
	@FindBy(xpath = "//input[@name='username']") private WebElement patientUserNameTextField;
	@FindBy(xpath = "//input[@name='password']") private WebElement patientPasswordTextField;
	@FindBy(xpath = "//button[@name='submit']") private WebElement patientLoginButton;
	@FindBy(xpath = "//a[@href='registration.php']") private WebElement CreateUserLink;
	
	//initialization
	public PatientLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//utilization (BUSINESS LOGIC)
	public void PatientLoginAction(String username, String password)
	{
		patientUserNameTextField.sendKeys(username);
		patientPasswordTextField.sendKeys(password);
		patientLoginButton.click();
	}
	
	public void ClickCreateUser()
	{
		CreateUserLink.click();
	}
	
}
