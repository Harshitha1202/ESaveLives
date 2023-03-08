package TESTNGpractice;

import java.util.Map;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tyss.Generic_Utility.TestNextGenAnnotations;
import com.tyss.Generic_Utility.Constants.Report;

import hms.objectRepository_Admin.AddDoctorPage;
import hms.objectRepository_Admin.AddDoctorSpecializationPage;
import hms.objectRepository_Admin.AdminDashboardPage;
import hms.objectRepository_Admin.AdminLoginPage;
import hms.objectRepository_Admin.EditDoctorPage;
import hms.objectRepository_Admin.ManageDoctorPage;
import hms.objectRepository_Application.HMSHomePage;

public class AdminDoctorModuleTestNgTest extends TestNextGenAnnotations{
	
	@Report(author= "Harshitha")
	@Test
	public void adminDoctorModule()
	{
	//fetch data from excel
			String exptestCaseName= "Adm_doctorModule";
			String sheetName= "testscriptdata";
			Map<String, String> map = excelutil.getData(sheetName, exptestCaseName);
			

				//Home page
			Assert.assertEquals(hmshome.ApplicationHomeTitleVerificationAction(), map.get("apphome"));
				
				//admin login
				hmshome.Home_AdminAction();
				alogin.AdminLoginAction(adminUserName, adminPassword);
				Assert.assertEquals(mainadmdash.AdminHomePageVerificationAction(), map.get("admhome"));
			    mainadmdash.AdminDoctorAction();
			    
			    //add doc specialization
			    mainadmdash.AddSpecializationAction();
			    String addspec = driver.findElement(By.xpath("//h1[.='Admin | Add Doctor Specialization']")).getText();
			    Assert.assertEquals(addspec, map.get("A_addspecialization"));
			    adddoctorspec.AddDoctorSpecializationAction(map.get("doctor specialization"));
			    Assert.assertEquals(adddoctorspec.AddSpecializationSuccessVerification(), map.get("addspecialization_success"));
			    
			    //add doctor
			    mainadmdash.AdminDoctorAction();
			    mainadmdash.AddDoctorAction();
			    Assert.assertEquals(adddocpage.AddDoctorPageVerification(), map.get("A_adddoctor"));
			    adddocpage.SelectDoctorDropDownAction(webdriverutil, "Cardiologist");
			    String D_Email = map.get("doc_email")+javautil.getRandomNumber(1000)+"@gmail.com";
			    adddocpage.AddDoctorAction(map.get("doctor_name"), map.get("clinic_address"), map.get("doctor _fees"), 
			    		map.get("doctor_contactno"), D_Email, map.get("new_password"), map.get("confirm_password"));
			    webdriverutil.handleAlertAccept(driver);
			    
			    //manage doctor
			    mainadmdash.AdminDoctorAction();
			    waitutil.webDriverWait(mainadmdash.ManageDoctorButton, driver);
			    mainadmdash.ManageDoctorAction();
			    Assert.assertEquals(managedoctor.ManageDoctorPageVerificationAction(), map.get("A_managedoctor"));
			    managedoctor.EditDoctorAction();
			    editdoctor.EditDoctorAction(map.get("update_doctorname"), map.get("update_clinicaddress"), 
			    		map.get("update_doctorfees"), map.get("update_doctorcontact"));
			    Assert.assertEquals(editdoctor.DoctorDetailsUpdateVerificationAction(), map.get("doc_details_updated"));
			    
			    //del doctor
			    mainadmdash.AdminDoctorAction();
			    waitutil.webDriverWait(mainadmdash.ManageDoctorButton, driver);
			    mainadmdash.ManageDoctorAction();
			    managedoctor.DeleteDoctorAction();
			    webdriverutil.handleAlertAccept(driver);
			    String deldoc = driver.findElement(By.xpath("//p[contains(text(),'data del')]")).getText();
			    Assert.assertEquals(deldoc, map.get("A_deletedoctor"));

	}

}