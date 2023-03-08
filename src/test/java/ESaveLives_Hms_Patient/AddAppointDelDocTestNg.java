package ESaveLives_Hms_Patient;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tyss.Generic_Utility.TestNextGenAnnotations;
import com.tyss.Generic_Utility.Constants.Report;

import hms.objectRepository_Admin.AddDoctorPage;
import hms.objectRepository_Admin.AdminDashboardPage;
import hms.objectRepository_Admin.AdminLoginPage;
import hms.objectRepository_Admin.ManageDoctorPage;
import hms.objectRepository_Application.HMSHomePage;
import hms.objectRepository_Patient.PatientBookAppointmentPage;
import hms.objectRepository_Patient.PatientDashboardPage;
import hms.objectRepository_Patient.PatientLoginPage;

public class AddAppointDelDocTestNg extends TestNextGenAnnotations{
	@Report(author= "Harshitha")
	@Test
	
	public void addAppointDelDoc ()
	{
		
		//fetch data from excel
		String exptestCaseName= "addAppointmentDelDoc";
		String sheetName= "testscriptdata";
		Map<String, String> map = excelutil.getData(sheetName, exptestCaseName);
		
		//HomePage
		Assert.assertEquals(hmshome.ApplicationHomeTitleVerificationAction(), map.get("application_homepage"));
		hmshome.Home_AdminAction();
		
		//admin login // from obj repository
		alogin.AdminLoginAction(adminUserName, adminPassword);
		Assert.assertEquals(mainadmdash.AdminHomePageVerificationAction(), map.get("admin_homepage"));
	    mainadmdash.AdminDoctorAction();
	    //WebElement addDoctorButton = driver.findElement(By.xpath("//span[.= ' Add Doctor']"));
	   //	waitutil.webDriverWait(addDoctorButton, driver);
	    mainadmdash.AddDoctorAction();
	    
	
	    adddocpage.SelectDoctorDropDownAction(webdriverutil, "Oncologist");
	    String D_Email =map.get("docter_email")+javautil.getRandomNumber(1000)+"@gmail.com";
	    adddocpage.AddDoctorAction(map.get("doctor_name"), map.get("clinic_address"), map.get("doctor _fees"),
	    		map.get("doctor_contactno"), D_Email, map.get("new_password"), map.get("confirm_password"));
	    webdriverutil.handleAlertAccept(driver);
	    mainadmdash.AdminLogout();
	    
	    //login as patient // from obj repository
	    hmshome.Home_PatientAction();
	    plogin = new PatientLoginPage(driver);
	    plogin.PatientLoginAction(patientUserName, patientPassword);
		Assert.assertEquals(mainpatdash.PatientHomePageVerification(), map.get("patient_homepage"));
	    mainpatdash.DashboardBookAppointmentAction();
	    bookapppage.DoctorspecializationDropDownAction(webdriverutil, "Oncologist");
	    bookapppage.DoctorDropDownAction(webdriverutil, "Suresh");
	    bookapppage.BookAppointmentAction(map.get("appointment_date"));
	    webdriverutil.handleAlertAccept(driver);
	    mainpatdash.PatientLogoutAction();	
	    
	    //admin login
	    hmshome.Home_AdminAction();
	  	alogin.AdminLoginAction(adminUserName, adminPassword);
		Assert.assertEquals(mainadmdash.AdminHomePageVerificationAction(), map.get("admin_homepage"));
	    //del doctor  from obj repository
	  	mainadmdash.AdminDoctorAction();
	  	mainadmdash.ManageDoctorAction();
	  	managedoctor.DeleteDoctorAction();
	    webdriverutil.handleAlertAccept(driver);
		Assert.assertEquals(managedoctor.DoctorDeleteVerificationAction(), map.get("delete_doctor") );
		
		
	}

}
