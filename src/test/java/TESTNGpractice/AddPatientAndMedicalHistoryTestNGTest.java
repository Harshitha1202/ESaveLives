package TESTNGpractice;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tyss.Generic_Utility.ExcelUtility;
import com.tyss.Generic_Utility.JavaUtility;
import com.tyss.Generic_Utility.TestNextGenAnnotations;
import com.tyss.Generic_Utility.WebDriverUtility;
import com.tyss.Generic_Utility.Constants.FrameWorkConstants;
import com.tyss.Generic_Utility.Constants.Report;
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


/**
 * this Script is used to AddPatient and Medical History by doctor
 */
public class AddPatientAndMedicalHistoryTestNGTest extends TestNextGenAnnotations {
	@Report(author= "Harshitha")
	@Test
	public void addPatientAndMedicalHistory()
	{
		
		//SoftAssert soft=new SoftAssert();	
		//fetch data from excel
		String exptestCaseName= "add_patient";
		String sheetName= "testscriptdata";
		Map<String, String> map = excelutil.getData(sheetName, exptestCaseName);
		
		
		//Home page
		Assert.assertEquals(hmshome.ApplicationHomeTitleVerificationAction(), map.get("application_homepage"));
		//doctor login
		hmshome.Home_DoctorAction();
		dlogin.DoctorLoginAction(doctorUserName, doctorPassword);
		Assert.assertEquals(maindocdash.DoctorHomePageVerificationAction(), map.get("doctor_homepage"));
		//add patient
		maindocdash.DashboardPatientAction();
		maindocdash.DashboardAddPatientAction();
		String addpatpage = driver.findElement(By.xpath("//h1[@class='mainTitle']")).getText();
		Assert.assertEquals(addpatpage, map.get("add_patientpage"));
		AddPatientPage addpat= new AddPatientPage(driver);
		String P_Email = map.get("patient_email")+javautil.getRandomNumber(1000)+"@gmail.com";
		addpat.AddPatientAction(map.get("patient_name"), map.get("patient_contact"), 
		P_Email, map.get("pat_address"), map.get("pat_age"), map.get("pat_medhistory"));
			    
		//manage patient
		maindocdash.DashboardPatientAction();
		WebElement ManagePatient = driver.findElement(By.xpath("//span[.= ' Manage Patient ']"));
		waitutil.webDriverWait(ManagePatient, driver);
		maindocdash.DashboardManagePatientAction();
		String expectedpatname = driver.findElement(By.xpath("(//td[contains(text(), 'harshitha')])[last()]")).getText();
		Assert.assertEquals(map.get("patient_name"), expectedpatname);
		String managepat = driver.findElement(By.xpath("//h1[@class='mainTitle']")).getText();
		Assert.assertEquals(managepat, map.get("manage_patientpage"));
		managepatient.ViewPatientAction();
		managepatient.AddMedicalHistoryButtonAction();
		WebElement load = driver.findElement(By.id("exampleModalLabel"));
		waitutil.webDriverWait(load, driver);
		String medhispage = driver.findElement(By.id("exampleModalLabel")).getText();
		Assert.assertEquals(medhispage, map.get("add_medicalhistorypage"));
		medhis.MedicalHistoryPageAction(map.get("BP"), map.get("Bsugar"), 
		map.get("weight"), map.get("temperature"), map.get("prescription"));
		webdriverutil.handleAlertAccept(driver);
		
		//log out
		maindocdash.DashboardDoctorLogoutAction();	
	}
}
