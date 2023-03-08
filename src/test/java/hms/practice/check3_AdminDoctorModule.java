package hms.practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;


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

import hms.objectRepository_Admin.AddDoctorPage;
import hms.objectRepository_Admin.AddDoctorSpecializationPage;
import hms.objectRepository_Admin.AdminDashboardPage;
import hms.objectRepository_Admin.AdminLoginPage;
import hms.objectRepository_Admin.EditDoctorPage;
import hms.objectRepository_Admin.ManageDoctorPage;
import hms.objectRepository_Application.HMSHomePage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class check3_AdminDoctorModule {
	
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
		
		//fetch data from excel
		String exptestCaseName= "Adm_doctorModule";
		String sheetName= "testscriptdata";
		Map<String, String> map = excelutil.getData(sheetName, exptestCaseName);
		
		String doctorUserName = javautil.Decrypt(propertyutil.getPropertyData(PropertyKey.DOCTOR_USERNAME));
		String doctorPassword = javautil.Decrypt(propertyutil.getPropertyData(PropertyKey.DOCTOR_PASSWORD));
		String adminUserName = javautil.Decrypt(propertyutil.getPropertyData(PropertyKey.ADMIN_USERNAME));
		String adminPassword = javautil.Decrypt(propertyutil.getPropertyData(PropertyKey.ADMIN_PASSWORD));
		String patientUserName = javautil.Decrypt(propertyutil.getPropertyData(PropertyKey.PATIENT_USERNAME));
		String patientPassword = javautil.Decrypt(propertyutil.getPropertyData(PropertyKey.PATIENT_PASSWORD));
		
		//POM
		AdminDashboardPage mainadmdash= new AdminDashboardPage(driver);
		AddDoctorPage adddocpage= new AddDoctorPage(driver);
		EditDoctorPage editdoctor= new EditDoctorPage(driver);
		ManageDoctorPage managedoctor = new ManageDoctorPage(driver);
		HMSHomePage hmshome= new HMSHomePage(driver);
		AdminLoginPage alogin= new AdminLoginPage(driver);
		AddDoctorSpecializationPage adddoctorspec= new AddDoctorSpecializationPage(driver);

			//Home page
			verificationutil.verifyPage(hmshome.ApplicationHomeTitleVerificationAction(), map.get("apphome"));
			
			//admin login
			hmshome.Home_AdminAction();
			alogin.AdminLoginAction(adminUserName, adminPassword);
		    verificationutil.verifyPage(mainadmdash.AdminHomePageVerificationAction(), map.get("admhome"));
		    mainadmdash.AdminDoctorAction();
		    
		    //add doc specialization
		    mainadmdash.AddSpecializationAction();
		    String addspec = driver.findElement(By.xpath("//h1[.='Admin | Add Doctor Specialization']")).getText();
		    verificationutil.verifyPage(addspec, map.get("A_addspecialization"));
		    adddoctorspec.AddDoctorSpecializationAction(map.get("doctor specialization"));
		    verificationutil.verifyPage(adddoctorspec.AddSpecializationSuccessVerification(), map.get("addspecialization_success"));
		    
		    //add doctor
		    mainadmdash.AdminDoctorAction();
		    mainadmdash.AddDoctorAction();
		    verificationutil.verifyPage(adddocpage.AddDoctorPageVerification(), map.get("A_adddoctor"));
		    adddocpage.SelectDoctorDropDownAction(webdriverutil, "Cardiologist");
		    String D_Email = map.get("doc_email")+javautil.getRandomNumber(1000)+"@gmail.com";
		    adddocpage.AddDoctorAction(map.get("doctor_name"), map.get("clinic_address"), map.get("doctor _fees"), 
		    		map.get("doctor_contactno"), D_Email, map.get("new_password"), map.get("confirm_password"));
		    webdriverutil.handleAlertAccept(driver);
		    
		    //manage doctor
		    mainadmdash.AdminDoctorAction();
		    mainadmdash.ManageDoctorAction();
		    verificationutil.verifyPage(managedoctor.ManageDoctorPageVerificationAction(), map.get("A_managedoctor"));
		    managedoctor.EditDoctorAction();
		    editdoctor.EditDoctorAction(map.get("update_doctorname"), map.get("update_clinicaddress"), 
		    		map.get("update_doctorfees"), map.get("update_doctorcontact"));
		    verificationutil.verifyPage(editdoctor.DoctorDetailsUpdateVerificationAction(), map.get("doc_details_updated"));
		    
		    //del doctor
		    mainadmdash.AdminDoctorAction();
		    mainadmdash.ManageDoctorAction();
		    managedoctor.DeleteDoctorAction();
		    webdriverutil.handleAlertAccept(driver);
		    String deldoc = driver.findElement(By.xpath("//p[contains(text(),'data del')]")).getText();
		    verificationutil.verifyPage(deldoc, map.get("A_deletedoctor"));
		    webdriverutil.closeApplication();
		
	}	
	
}	
		    
		    
		    
