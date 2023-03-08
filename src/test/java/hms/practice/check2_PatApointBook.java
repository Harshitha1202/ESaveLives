package hms.practice;


	import java.io.FileInputStream;
	import java.io.IOException;
	import java.util.HashMap;
	import java.util.Map;
	import java.util.Properties;
	import java.util.concurrent.TimeUnit;

	import org.apache.poi.ss.usermodel.DataFormatter;
	import org.apache.poi.ss.usermodel.Sheet;
	import org.apache.poi.ss.usermodel.Workbook;
	import org.apache.poi.ss.usermodel.WorkbookFactory;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.support.ui.Select;

import com.tyss.Generic_Utility.ExcelUtility;
import com.tyss.Generic_Utility.JavaUtility;
import com.tyss.Generic_Utility.WebDriverUtility;
import com.tyss.Generic_Utility.Constants.FrameWorkConstants;
import com.tyss.Generic_Utility.Enums.ExcelSheet.PropertyKey;
import com.tyss.Generic_Utility.ExternalFileUtility.PropertyUtility;
import com.tyss.Generic_Utility.ExternalFileUtility.VerificationUtility;
import com.tyss.Generic_Utility.ExternalFileUtility.WaitUtility;

import hms.objectRepository_Application.HMSHomePage;
import hms.objectRepository_Doctor.DoctorDashboardPage;
import hms.objectRepository_Doctor.DoctorLoginPage;
import hms.objectRepository_Patient.PatientBookAppointmentPage;
import hms.objectRepository_Patient.PatientDashboardPage;
import hms.objectRepository_Patient.PatientLoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
 
	public class check2_PatApointBook {
		
		public static void main(String[] args) throws IOException 
		{
			WebDriverUtility webdriverutil=new WebDriverUtility();
			WaitUtility waitutil= new WaitUtility();
			VerificationUtility verificationutil= new VerificationUtility();
			
			
			//commom data
			PropertyUtility propertyutil = new PropertyUtility(FrameWorkConstants.TEST_PROPERTY_FILEPATH);
			ExcelUtility excelutil = new ExcelUtility(FrameWorkConstants.EXCEL_PATH);
			String url = propertyutil.getPropertyData(PropertyKey.URL);
			String browser= propertyutil.getPropertyData(PropertyKey.BROWSER);
		    long timeout = Long.parseLong(propertyutil.getPropertyData(PropertyKey.TIMEOUT));
		    
		  
			//launch application
			WebDriver driver = webdriverutil.setBrowser(browser);
			driver.get(url);
			JavaUtility javautil= new JavaUtility(driver);
			webdriverutil.windowMaximize();
			waitutil.implicityWait(driver, timeout);
			
			String doctorUserName = javautil.Decrypt(propertyutil.getPropertyData(PropertyKey.DOCTOR_USERNAME));
			String doctorPassword = javautil.Decrypt(propertyutil.getPropertyData(PropertyKey.DOCTOR_PASSWORD));
			String adminUserName = javautil.Decrypt(propertyutil.getPropertyData(PropertyKey.ADMIN_USERNAME));
			String adminPassword = javautil.Decrypt(propertyutil.getPropertyData(PropertyKey.ADMIN_PASSWORD));
			String patientUserName = javautil.Decrypt(propertyutil.getPropertyData(PropertyKey.PATIENT_USERNAME));
			String patientPassword = javautil.Decrypt(propertyutil.getPropertyData(PropertyKey.PATIENT_PASSWORD));
				
			
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
			verificationutil.verifyPage(hmshomepage.ApplicationHomeTitleVerificationAction(), map.get("application_homepage"));
			
			//patient login //object repo
			hmshomepage.Home_PatientAction();
		    plogin.PatientLoginAction(patientUserName, patientPassword);
		    verificationutil.verifyPage(mainpatdash.PatientHomePageVerification(), map.get("patient_homepage"));
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
		    verificationutil.verifyPage(maindocdash.DoctorHomePageVerificationAction(), map.get("doctor_homepage"));
		    maindocdash.DashboardAppointHistoryAction();
		    webdriverutil.closeApplication();
			
			
		}	
	}
			
			
			
			
			
		
		
		
		
		



