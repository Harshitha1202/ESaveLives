package hms.objectRepository_Patient;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateUserPage {
	// declaration
	@FindBy(name = "full_name") private WebElement FullNameTextField;
	@FindBy(name = "address") private WebElement AddressTextField;
	@FindBy(name = "city") private WebElement CityTextField;
	@FindBy(xpath = "//label[@for='rg-female']") private WebElement GenderRadioButton;
	@FindBy(id = "email") private WebElement EmailTextField;
	@FindBy(id = "password") private WebElement PasswordTextField;
	@FindBy(id = "password_again") private WebElement ReEnterPasswordTextField;
	@FindBy(id = "agree") private WebElement AgreeCheckBox;
	@FindBy(id = "submit") private WebElement SubmitButton;
	@FindBy(xpath = "//a[@href='user-login.php']") private WebElement LoginButton;
	
	//initialization
		public CreateUserPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		//utilization (BUSINESS LOGIC)
		public void CreateUserPageAction(String UserName, String Address, String City, String Email,
				String Password, String ReEnterPassword)
		{
			FullNameTextField.sendKeys(UserName);
			AddressTextField.sendKeys(Address);
			CityTextField.sendKeys(City);
			GenderRadioButton.isEnabled();
			EmailTextField.sendKeys(Email);
			PasswordTextField.sendKeys(Password);
			ReEnterPasswordTextField.sendKeys(ReEnterPassword);
			AgreeCheckBox.isEnabled();
			SubmitButton.click();
		
		}
		
		public void ClickLoginAction()
		{
			LoginButton.click();
		}
		
}
