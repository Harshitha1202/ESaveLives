package com.tyss.Generic_Utility;

import java.io.IOException;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import com.github.dockerjava.api.model.Driver;
import com.tyss.Generic_Utility.Constants.FrameWorkConstants;
import com.tyss.Generic_Utility.Enums.ExcelSheet.PropertyKey;
import com.tyss.Generic_Utility.ExternalFileUtility.PropertyUtility;
import com.tyss.Generic_Utility.ExternalFileUtility.VerificationUtility;
import com.tyss.Generic_Utility.ExternalFileUtility.WaitUtility;
import com.tyss.Generic_Utility.Listener.ExtentReportListener;

import hms.objectRepository_Admin.AddDoctorPage;
import hms.objectRepository_Admin.AddDoctorSpecializationPage;
import hms.objectRepository_Admin.AdminDashboardPage;
import hms.objectRepository_Admin.AdminLoginPage;
import hms.objectRepository_Admin.AdminViewPatientPage;
import hms.objectRepository_Admin.Admin_AppointmentHistoryPage;
import hms.objectRepository_Admin.EditDoctorPage;
import hms.objectRepository_Admin.ManageDoctorPage;
import hms.objectRepository_Application.HMSHomePage;
import hms.objectRepository_Doctor.DoctorAppointmentHistoryPage;
import hms.objectRepository_Doctor.DoctorDashboardPage;
import hms.objectRepository_Doctor.DoctorLoginPage;
import hms.objectRepository_Doctor.ManagePatientPage;
import hms.objectRepository_Doctor.MedicalHistoryPage;
import hms.objectRepository_Patient.CreateUserPage;
import hms.objectRepository_Patient.PatientBookAppointmentPage;
import hms.objectRepository_Patient.PatientDashboardPage;
import hms.objectRepository_Patient.PatientLoginPage;
/**
 * This class is used to initialize  and setup all the actions before running the @test method
 * @author MBA-Student110
 *
 */
public class TestNextGenAnnotations extends TestNextGenDeclarations
{
	
		/**
		* this method is used to initialize the property data
	 	*/
		@org.testng.annotations.Parameters(value = "browser")
		
		@BeforeClass(alwaysRun = true)
		public void initialSetUp(@Optional String browser)
		{
		report=ExtentReportListener.sreport;
		//commom data
		propertyutil = new PropertyUtility(FrameWorkConstants.TEST_PROPERTY_FILEPATH);
		excelutil = new ExcelUtility(FrameWorkConstants.EXCEL_PATH);
		webdriverutil= new WebDriverUtility();
		waitutil= new WaitUtility();
		verificationutil= new VerificationUtility();
		if(browser==null || browser.isBlank() || browser.isEmpty() || browser.equals(""))
		{
			browser=propertyutil.getPropertyData(PropertyKey.BROWSER);
		}
		this.browser=browser;
		//browser = propertyutil.getPropertyData(PropertyKey.BROWSER);
		timeout = Long.parseLong(propertyutil.getPropertyData(PropertyKey.TIMEOUT));
		url = propertyutil.getPropertyData(PropertyKey.URL);

		}
		 
		/**
		 * this method is used to launch browser and fetch the credentials and initial POM
		 */
		@BeforeMethod(alwaysRun = true)
		public void setup()
		{
		
		//launchbrowser
		driver = webdriverutil.setBrowser(browser);
		driver.get(url);
		javautil= new JavaUtility(driver);
		webdriverutil.windowMaximize();
		waitutil.implicityWait(driver, timeout);
		timeout = Long.parseLong(propertyutil.getPropertyData(PropertyKey.TIMEOUT));
		url = propertyutil.getPropertyData(PropertyKey.URL);
			
		//Property data
		doctorUserName = javautil.Decrypt(propertyutil.getPropertyData(PropertyKey.DOCTOR_USERNAME));
		doctorPassword = javautil.Decrypt(propertyutil.getPropertyData(PropertyKey.DOCTOR_PASSWORD));
		adminUserName = javautil.Decrypt(propertyutil.getPropertyData(PropertyKey.ADMIN_USERNAME));
		adminPassword = javautil.Decrypt(propertyutil.getPropertyData(PropertyKey.ADMIN_PASSWORD));
		patientUserName = javautil.Decrypt(propertyutil.getPropertyData(PropertyKey.PATIENT_USERNAME));
		patientPassword = javautil.Decrypt(propertyutil.getPropertyData(PropertyKey.PATIENT_PASSWORD));
		
		//PomInitialization
		mainadmdash= new AdminDashboardPage(driver);
		adddocpage= new AddDoctorPage(driver);
		editdoctor= new EditDoctorPage(driver);
		managedoctor = new ManageDoctorPage(driver);
		hmshome= new HMSHomePage(driver);
		alogin= new AdminLoginPage(driver);
		adddoctorspec= new AddDoctorSpecializationPage(driver);
		mainpatdash= new PatientDashboardPage(driver);
		bookapppage= new PatientBookAppointmentPage(driver);
		maindocdash= new DoctorDashboardPage(driver);
		dlogin= new DoctorLoginPage(driver);
		managepatient= new ManagePatientPage(driver);
		medhis= new MedicalHistoryPage(driver);
		plogin = new PatientLoginPage(driver);
		createuser= new CreateUserPage(driver);
		doctorappointmenthistory=new DoctorAppointmentHistoryPage(driver);
		adminappointmenthistory=new  Admin_AppointmentHistoryPage(driver);
		adminpatientveiw= new AdminViewPatientPage(driver);
	
		}
		/**
		 * this method is used to close the application
		 */
		@AfterMethod(alwaysRun = true)
		public void closeBrower()
		{
			webdriverutil.closeApplication();
		}
		
		/**
		 * this method is used to close the excel file
		 */
		@AfterClass(alwaysRun = true)
		public void closeExcel()
		{
		excelutil.close();
		}
	
}
