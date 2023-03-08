package hms.objectRepository_Doctor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MedicalHistoryPage {
	//declaration
	@FindBy(name = "bp") private WebElement BpTextField;
	@FindBy(name = "bs") private WebElement BsTextField;
	@FindBy(name = "weight") private WebElement WeightTextField;
	@FindBy(name = "temp") private WebElement TempatureTextField;
	@FindBy(name = "pres") private WebElement PrescriptionTextField;
	@FindBy(xpath = "//button[contains(text(), 'Submit')]") private WebElement SubmitButton;
	
	//initialization
	public MedicalHistoryPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//utilization (BUSINESS LOGIC)
	public void MedicalHistoryPageAction(String bP, String bSugar, String weight, String temperature ,String prescription)
	{
		BpTextField.sendKeys(bP);
		BsTextField.sendKeys(bSugar);
		WeightTextField.sendKeys(weight);
		TempatureTextField.sendKeys(temperature);
		PrescriptionTextField.sendKeys(prescription);
		SubmitButton.click();
	}


}
