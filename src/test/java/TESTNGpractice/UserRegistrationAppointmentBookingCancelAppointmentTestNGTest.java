package TESTNGpractice;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tyss.Generic_Utility.TestNextGenAnnotations;
import com.tyss.Generic_Utility.Constants.Report;

import hms.objectRepository_Doctor.DoctorLoginPage;

public class UserRegistrationAppointmentBookingCancelAppointmentTestNGTest extends TestNextGenAnnotations{
	@Report(author= "Harshitha")
	@Test
	public void userRegistrationAppointmentBookingCancelAppointment()
	{
		//fetch data from excel
		String exptestCaseName= "UserRegistrationAppointmentBookingCancelAppointment";
		String sheetName= "testscriptdata";
		Map<String, String> map = excelutil.getData(sheetName, exptestCaseName);
				
		//Home page
		Assert.assertEquals(hmshome.ApplicationHomeTitleVerificationAction(), map.get("application_homepage"));
		hmshome.Home_PatientAction();
		plogin.ClickCreateUser();
		String EmailID = map.get("Email")+javautil.getRandomNumber(100)+"@gmail.com";
		createuser.CreateUserPageAction(map.get("UserName"), map.get("Address"), map.get("City"), EmailID , 
				map.get("Password"), map.get("ReEnterPassword"));
		webdriverutil.handleAlertAccept(driver);
		
		createuser.ClickLoginAction();
		//patient login

		plogin.PatientLoginAction(EmailID, map.get("Password"));
		Assert.assertEquals(mainpatdash.PatientHomePageVerification(), map.get("patient_homepage"));
		//book appointment
		mainpatdash.DashboardBookAppointmentAction();
		bookapppage.DoctorspecializationDropDownAction(webdriverutil, "Cardiologist");
		bookapppage.DoctorDropDownAction(webdriverutil, "Dr. Doctor");
		bookapppage.BookAppointmentAction(map.get("appointment_date"));
		webdriverutil.handleAlertAccept(driver);
		mainpatdash.PatientLogoutAction();		 
		
		//doctor login
	    hmshome.Home_DoctorAction();
	    dlogin.DoctorLoginAction(doctorUserName, doctorPassword);
		Assert.assertEquals(maindocdash.DoctorHomePageVerificationAction(), map.get("doctor_homepage"));
	    maindocdash.DashboardAppointHistoryAction();
	    doctorappointmenthistory.CancelAppointmentAction();
	    webdriverutil.handleAlertAccept(driver);
	    maindocdash.DashboardDoctorLogoutAction();
	    
	    //admin login // from obj repository
		hmshome.Home_AdminAction();
	    alogin.AdminLoginAction(adminUserName, adminPassword);
	    Assert.assertEquals(mainadmdash.AdminHomePageVerificationAction(), map.get("admin_homepage"));
	    mainadmdash.ClickAppointmentHistoryAction();
//	    System.out.println(adminappointmenthistory.VerifyAppointmentCancel());
//	    System.out.println(map.get("AppointmentStatus"));
	    Assert.assertEquals(adminappointmenthistory.VerifyAppointmentCancel(), map.get("AppointmentStatus"));
	    
	}
}
