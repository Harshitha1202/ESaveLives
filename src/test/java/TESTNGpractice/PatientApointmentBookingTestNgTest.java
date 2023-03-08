package TESTNGpractice;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tyss.Generic_Utility.TestNextGenAnnotations;
import com.tyss.Generic_Utility.Constants.Report;

import hms.objectRepository_Application.HMSHomePage;
import hms.objectRepository_Doctor.DoctorDashboardPage;
import hms.objectRepository_Doctor.DoctorLoginPage;
import hms.objectRepository_Patient.PatientBookAppointmentPage;
import hms.objectRepository_Patient.PatientDashboardPage;
import hms.objectRepository_Patient.PatientLoginPage;

public class PatientApointmentBookingTestNgTest extends TestNextGenAnnotations
{
	@Report(author= "Harshitha")
	@Test(groups = "sanity")
	public void patientApointmentBooking()
	{
		//fetch data from excel
		String exptestCaseName= "bookAppointment";
		String sheetName= "testscriptdata";
		Map<String, String> map = excelutil.getData(sheetName, exptestCaseName);
		
		//POM // from obj repository
		HMSHomePage hmshomepage= new HMSHomePage(driver);
		PatientDashboardPage mainpatdash= new PatientDashboardPage(driver);
		PatientBookAppointmentPage bookapppage= new PatientBookAppointmentPage(driver);
		PatientLoginPage plogin = new PatientLoginPage(driver);
		DoctorDashboardPage maindocdash= new DoctorDashboardPage(driver);
		
		//home page
		Assert.assertEquals(hmshomepage.ApplicationHomeTitleVerificationAction(), map.get("application_homepage"));
		
		//patient login //object repo
		hmshomepage.Home_PatientAction();
	    plogin.PatientLoginAction(patientUserName, patientPassword);
	    Assert.assertEquals(mainpatdash.PatientHomePageVerification(), map.get("patient_homepage"));
	    //book appointment
	    mainpatdash.DashboardBookAppointmentAction();
	    bookapppage.DoctorspecializationDropDownAction(webdriverutil, "General Physician");
	    bookapppage.BookAppointmentAction(map.get("appointment_date"));
	    webdriverutil.handleAlertAccept(driver);
	    mainpatdash.PatientLogoutAction();
	    
	    //doctor login
	    hmshomepage.Home_DoctorAction();
	    DoctorLoginPage dlogin= new DoctorLoginPage(driver);
		dlogin.DoctorLoginAction(doctorUserName, doctorPassword);
		Assert.assertEquals(maindocdash.DoctorHomePageVerificationAction(), map.get("doctor_homepage"));
	    maindocdash.DashboardAppointHistoryAction();
	}
}
