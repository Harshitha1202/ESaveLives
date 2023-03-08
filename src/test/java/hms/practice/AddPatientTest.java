package hms.practice;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.tyss.Generic_Utility.ExcelUtility;
import com.tyss.Generic_Utility.JavaUtility;
import com.tyss.Generic_Utility.WebDriverUtility;
import com.tyss.Generic_Utility.Constants.FrameWorkConstants;
import com.tyss.Generic_Utility.Enums.ExcelSheet.PropertyKey;
import com.tyss.Generic_Utility.ExternalFileUtility.PropertyUtility;
import com.tyss.Generic_Utility.ExternalFileUtility.VerificationUtility;
import com.tyss.Generic_Utility.ExternalFileUtility.WaitUtility;

import hms.objectRepository_Application.HMSHomePage;
import hms.objectRepository_Doctor.AddPatientPage;
import hms.objectRepository_Doctor.DoctorDashboardPage;
import hms.objectRepository_Doctor.DoctorLoginPage;
import hms.objectRepository_Doctor.ManagePatientPage;
import hms.objectRepository_Doctor.MedicalHistoryPage;


public class AddPatientTest 
{
	  
	public static void main(String[] args) throws IOException 
	{
	
		WebDriverUtility webdriverutil= new WebDriverUtility();
		WaitUtility waitutil= new WaitUtility();
		VerificationUtility verificationutil= new VerificationUtility();
		

		//commom data
		PropertyUtility propertyutil = new PropertyUtility(FrameWorkConstants.TEST_PROPERTY_FILEPATH);
		ExcelUtility excelutil = new ExcelUtility(FrameWorkConstants.EXCEL_PATH);
		String browser = propertyutil.getPropertyData(PropertyKey.BROWSER);
		long timeout = Long.parseLong(propertyutil.getPropertyData(PropertyKey.TIMEOUT));
		String url = propertyutil.getPropertyData(PropertyKey.URL);
		
		
		
		//launch application
		WebDriver driver = webdriverutil.setBrowser(browser);
		driver.get(url);
		JavaUtility javautil= new JavaUtility(driver);
		webdriverutil.windowMaximize();
		waitutil.implicityWait(driver, timeout);
		
		String doctorUserName = javautil.Decrypt(propertyutil.getPropertyData(PropertyKey.DOCTOR_USERNAME));
		String doctorPassword = javautil.Decrypt(propertyutil.getPropertyData(PropertyKey.DOCTOR_PASSWORD));
				
		//fetch data from excel
		String exptestCaseName= "add_patient";
		String sheetName= "testscriptdata";
		Map<String, String> map = excelutil.getData(sheetName, exptestCaseName);
				
		// POM
		DoctorDashboardPage maindocdash= new DoctorDashboardPage(driver);
		HMSHomePage hmshome= new HMSHomePage(driver);
		DoctorLoginPage dlogin= new DoctorLoginPage(driver);
		ManagePatientPage managepatient= new ManagePatientPage(driver);
		MedicalHistoryPage medhis= new MedicalHistoryPage(driver);

		//Home page
		verificationutil.verifyPage(hmshome.ApplicationHomeTitleVerificationAction(), map.get("application_homepage"));
		//doctor login
		hmshome.Home_DoctorAction();
		dlogin.DoctorLoginAction(doctorUserName, doctorPassword);
		verificationutil.verifyPage(maindocdash.DoctorHomePageVerificationAction(), map.get("doctor_homepage"));
		//add patient
		maindocdash.DashboardPatientAction();
		maindocdash.DashboardAddPatientAction();
		String addpatpage = driver.findElement(By.xpath("//h1[@class='mainTitle']")).getText();
		verificationutil.verifyPage(addpatpage, map.get("add_patientpage"));
		AddPatientPage addpat= new AddPatientPage(driver);
		String P_Email = map.get("patient_email")+javautil.getRandomNumber(1000)+"@gmail.com";
		addpat.AddPatientAction(map.get("patient_name"), map.get("patient_contact"), 
		P_Email, map.get("pat_address"), map.get("pat_age"), map.get("pat_medhistory"));
			    
		//manage patient
		maindocdash.DashboardPatientAction();
		maindocdash.DashboardManagePatientAction();
		String expectedpatname = driver.findElement(By.xpath("(//td[contains(text(), 'harshitha')])[last()]")).getText();
		verificationutil.validateData(map.get("patient_name"), expectedpatname);
		String managepat = driver.findElement(By.xpath("//h1[@class='mainTitle']")).getText();
		verificationutil.verifyPage(managepat, map.get("manage_patientpage"));
		managepatient.ViewPatientAction();
		managepatient.AddMedicalHistoryButtonAction();
		WebElement load = driver.findElement(By.id("exampleModalLabel"));
		waitutil.webDriverWait(load, driver);
		String medhispage = driver.findElement(By.id("exampleModalLabel")).getText();
		verificationutil.verifyPage(medhispage, map.get("add_medicalhistorypage"));
		medhis.MedicalHistoryPageAction(map.get("BP"), map.get("Bsugar"), 
		map.get("weight"), map.get("temperature"), map.get("prescription"));
		webdriverutil.handleAlertAccept(driver);
		
		//log out
		maindocdash.DashboardDoctorLogoutAction();	
		
	}	

}
		
		

