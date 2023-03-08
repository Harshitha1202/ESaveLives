package com.tyss.Generic_Utility;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.tyss.Generic_Utility.Constants.ReportUtility;
import com.tyss.Generic_Utility.ExternalFileUtility.PropertyUtility;
import com.tyss.Generic_Utility.ExternalFileUtility.VerificationUtility;
import com.tyss.Generic_Utility.ExternalFileUtility.WaitUtility;

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
 * this class is used to declare all the objects and variables
 * @author MBA-Student110
 *
 */
public class TestNextGenDeclarations 

{
	protected WebDriver driver;
	protected WebDriverUtility webdriverutil;
	protected WaitUtility waitutil;
	protected VerificationUtility verificationutil;
	protected PropertyUtility propertyutil;
	public JavaUtility javautil;
	protected ExcelUtility excelutil;
	
	protected long timeout;
	protected String url;
	protected String browser;
	
	protected String doctorUserName;
	protected String doctorPassword;
	protected String adminUserName;
	protected String adminPassword;
	protected String patientUserName ;
	protected String patientPassword;
	protected String newUserName;
	protected String newUserPassword;
	
	protected AdminDashboardPage mainadmdash;
	protected AddDoctorPage adddocpage;
	protected EditDoctorPage editdoctor;
	protected ManageDoctorPage managedoctor;
	protected HMSHomePage hmshome;
	protected AdminLoginPage alogin;
	protected AddDoctorSpecializationPage adddoctorspec;
	protected PatientDashboardPage mainpatdash;
	protected PatientBookAppointmentPage bookapppage;
	protected DoctorDashboardPage maindocdash;
	protected DoctorLoginPage dlogin;
	protected ManagePatientPage managepatient;
	protected MedicalHistoryPage medhis;
	protected PatientLoginPage plogin;
	protected CreateUserPage createuser;
	protected DoctorAppointmentHistoryPage doctorappointmenthistory;
	protected Admin_AppointmentHistoryPage  adminappointmenthistory;
	protected AdminViewPatientPage adminpatientveiw;
	
	protected ReportUtility report;
	public ExtentTest test;
}
