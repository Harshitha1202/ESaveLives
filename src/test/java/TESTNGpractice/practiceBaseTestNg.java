package TESTNGpractice;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.tyss.Generic_Utility.ExcelUtility;
import com.tyss.Generic_Utility.JavaUtility;
import com.tyss.Generic_Utility.WebDriverUtility;
import com.tyss.Generic_Utility.Constants.FrameWorkConstants;
import com.tyss.Generic_Utility.Enums.ExcelSheet.PropertyKey;
import com.tyss.Generic_Utility.ExternalFileUtility.PropertyUtility;
import com.tyss.Generic_Utility.ExternalFileUtility.SystemDateUtility;
import com.tyss.Generic_Utility.ExternalFileUtility.VerificationUtility;
import com.tyss.Generic_Utility.ExternalFileUtility.WaitUtility;

public class practiceBaseTestNg{
	
	@BeforeSuite
	public void suitesetup()
	{
		System.out.println("beforesuite");
	}
	
	@BeforeTest
	public void testsetup()
	{
		System.out.println("beforetest");
	}
	
	@BeforeClass
	public void classsetup()
	{
		System.out.println("beforeclass");
	}
	
	@BeforeMethod
	public void methodsetup()
	{
		System.out.println("beforemethod");
	}
	
	@AfterMethod
	public void methodteardown()
	{
		System.out.println("aftermethod");
	}
	
	@AfterClass
	public void classteardown()
	{
		System.out.println("afterclass");
	}

	@AfterTest
	public void testteardown()
	{
		System.out.println("aftertest");
	}
	
	@AfterSuite
	public void suiteteardown()
	{
		System.out.println("aftersuite");
	}

}
		

