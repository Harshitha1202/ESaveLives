package ESaveLives_Hms_Doctor;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tyss.Generic_Utility.TestNextGenAnnotations;
import com.tyss.Generic_Utility.Constants.Report;

import hms.objectRepository_Doctor.AddPatientPage;

public class BookAppointmentAddPatientAddRecordsAdminViewRecord extends TestNextGenAnnotations
{
	@Report(author= "Harshitha")
	@Test
	public void bookAppointmentAddPatientAddRecordsAdminViewRecord()
	{
	
		//fetch data from excel
		String exptestCaseName= "BookAppointmentAddPatientAddRecordsAdminViewRecord";
		String sheetName= "testscriptdata";
		Map<String, String> map = excelutil.getData(sheetName, exptestCaseName);
		
		//Home page
		Assert.assertEquals(hmshome.ApplicationHomeTitleVerificationAction(), map.get("application_homepage"));
		hmshome.Home_PatientAction();
		plogin.PatientLoginAction(patientUserName, patientPassword);
		Assert.assertEquals(mainpatdash.PatientHomePageVerification(), map.get("patient_homepage"));
		//book appointment
		mainpatdash.DashboardBookAppointmentAction();
		bookapppage.DoctorspecializationDropDownAction(webdriverutil, "Cardiologist");
		bookapppage.DoctorDropDownAction(webdriverutil, "Dr. Doctor");
		bookapppage.BookAppointmentAction(map.get("appointmentDate"));
		webdriverutil.handleAlertAccept(driver);
		mainpatdash.PatientLogoutAction();		 
		
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
		String expectedpatname = driver.findElement(By.xpath("(//td[contains(text(), 'Nicholas')])[last()]")).getText();
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
				
		//admin login
		hmshome.Home_AdminAction();
		alogin.AdminLoginAction(adminUserName, adminPassword);
		Assert.assertEquals(mainadmdash.AdminHomePageVerificationAction(), map.get("admin_homepage"));
		mainadmdash.ClickPatientTab();
		Assert.assertEquals(adminpatientveiw.PatientHistoryVerification(), map.get("patient_name"));
		adminpatientveiw.ViewPatientHistory();
				
	}
	
}
