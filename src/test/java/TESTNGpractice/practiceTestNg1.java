package TESTNGpractice;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.reporters.jq.Main;

import com.tyss.Generic_Utility.ExcelUtility;
import com.tyss.Generic_Utility.JavaUtility;
import com.tyss.Generic_Utility.WebDriverUtility;
import com.tyss.Generic_Utility.Constants.FrameWorkConstants;
import com.tyss.Generic_Utility.Enums.AdminDashboardTabNames;
import com.tyss.Generic_Utility.Enums.ExcelSheet.PropertyKey;
import com.tyss.Generic_Utility.ExternalFileUtility.PropertyUtility;
import com.tyss.Generic_Utility.ExternalFileUtility.VerificationUtility;
import com.tyss.Generic_Utility.ExternalFileUtility.WaitUtility;
import com.tyss.Generic_Utility.Retry.SetTestParameter;

import hms.objectRepository_Admin.AddDoctorPage;
import hms.objectRepository_Admin.AddDoctorSpecializationPage;
import hms.objectRepository_Admin.AdminDashboardDXpathPage;
import hms.objectRepository_Admin.AdminDashboardPage;
import hms.objectRepository_Admin.AdminLoginPage;
import hms.objectRepository_Admin.EditDoctorPage;
import hms.objectRepository_Admin.ManageDoctorPage;
import hms.objectRepository_Application.HMSHomePage;
import hms.objectRepository_Doctor.AddPatientPage;
import hms.objectRepository_Doctor.DoctorDashboardPage;
import hms.objectRepository_Doctor.DoctorLoginPage;
import hms.objectRepository_Doctor.ManagePatientPage;
import hms.objectRepository_Doctor.MedicalHistoryPage;
import hms.objectRepository_Patient.PatientBookAppointmentPage;
import hms.objectRepository_Patient.PatientDashboardPage;
import hms.objectRepository_Patient.PatientLoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class practiceTestNg1 extends practiceBaseTestNg
{
	WebDriver driver;
	
	@BeforeMethod
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
	}
	
	@Test
	public void test1a()
	{
		System.out.println(Thread.currentThread().getId());
		driver.get("https://google.com");
	}
	
	@Test
	public void test1b()
	{
		System.out.println(Thread.currentThread().getId());
		driver.get("https://gmail.com");
		Assert.fail();
	}
	
	@Test
	public void test2a()
	{
		System.out.println(Thread.currentThread().getId());
		driver.get("https://google.com");
	}
	
	
}
