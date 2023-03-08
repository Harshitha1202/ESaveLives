package hms.objectRepository_Admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminLoginPage {
	//declaration
	@FindBy(xpath = "//input[@name='username']") private WebElement adminUserNameTextField;
	@FindBy(xpath = "//input[@name='password']") private WebElement adminPasswordTextField;
	@FindBy(xpath = "//button[@name='submit']") private WebElement adminLoginButton;
	
	//initialization
	public AdminLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//utilization (BUSINESS LOGIC)
	public void AdminLoginAction(String username, String password)
	{
		adminUserNameTextField.sendKeys(username);
		adminPasswordTextField.sendKeys(password);
		adminLoginButton.click();
	}

}
