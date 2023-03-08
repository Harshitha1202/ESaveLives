package com.tyss.Generic_Utility.Constants;

import java.awt.Desktop;
import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
//import com.sun.org.apache.xml.internal.security.Init;
import com.tyss.Generic_Utility.Enums.ExcelSheet.PropertyKey;
import com.tyss.Generic_Utility.Enums.ExtentReportPropertyKey;
import com.tyss.Generic_Utility.ExternalFileUtility.PropertyUtility;
import com.tyss.Generic_Utility.ExternalFileUtility.SystemDateUtility;
/**
 * this class is used to set the properties and theme for the report
 * @author MBA-Student110
 *
 */
public class ReportUtility {

	private ExtentReports report;
	private String extentReportPath;
	
	/**
	 * constructor
	 */
	public ReportUtility()
	{
		init();
	}
	/**
	 * this is the method to initialize the properties of the report 
	 */
	public void init()
	{
		
		PropertyUtility propertyutil= new PropertyUtility(FrameWorkConstants.TEST_PROPERTY_FILEPATH);
		String overrideOrNot= propertyutil.getPropertyData(PropertyKey.OVERRIDEREPORT);
		String randomName="";
		if(overrideOrNot.equalsIgnoreCase("no"))
		{
			randomName= "_"+new SystemDateUtility().getCurrentDateAndTime();
		}
		extentReportPath = FrameWorkConstants.EXTENT_REPORT_PATH+"extentReport"+randomName+".html";
		ExtentSparkReporter spark = new ExtentSparkReporter(extentReportPath);
		spark.config().setDocumentTitle(propertyutil.getPropertyData(PropertyKey.EXTENTREPORTTITLE));
		spark.config().setReportName(propertyutil.getPropertyData(PropertyKey.EXTENTREPORTNAME));
		spark.config().setTheme(Theme.DARK);
		
		report= new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("Browesr", propertyutil.getPropertyData(PropertyKey.BROWSER));
		report.setSystemInfo("OS", System.getProperty("os.name"));
	}
	
	/**
	 * this method is used to create the different test or scripts 
	 * @param testName
	 */
	public void createTest(String testName)
	{
		ExtentTest test = report.createTest(testName);
		UtilityInstanceTransfer.setExtentTest(test);
	}
	
	/**
	 * this method is used print the error message when the script fails
	 * @param test
	 * @param message
	 * @param errormessage
	 */
	public void fail(ExtentTest test, String message, Throwable errormessage)
	{
		test.fail(message);
		test.fail(errormessage);
		System.out.println(message);
	}
	/**
	 * this method is used to print the author name in the report
	 * @param test
	 * @param names
	 */
	public void addAuthor(ExtentTest test, String... names)
	{
		test.assignAuthor(names);
	}
	/**
	 * this method is used to print the category name of the test scripts in the report
	 * @param test
	 * @param names
	 */
	public void addCategory(ExtentTest test, String... names)
	{
		test.assignCategory(names);
	}
	
	/**
	 * this method is used print the  message when the script is passed
	 * @param test
	 * @param message
	 */
	
	public void pass(ExtentTest test, String message)
	{
		test.pass(message);
		System.out.println(message);
	}
	
	/**
	 * this method is used print the warning message
	 * @param test
	 * @param message
	 */
	public void warn(ExtentTest test, String message)
	{
		test.warning(message);
		System.out.println(message);
		
		
	}
	/**
	 * this method is used to print the message is the test script is skipped
	 * @param test
	 * @param message
	 * @param errorMessage
	 */
	public void skip(ExtentTest test, String message, Throwable errorMessage)
	{
		test.skip(message);
		test.skip(errorMessage);
		System.out.println(message);
	}
	
	/**
	 * this method is used to print the information about the test script
	 * @param test
	 * @param message
	 */
	public void info(ExtentTest test, String message)
	{
		test.info(message);
		System.out.println(message);
	}
	/**
	 * this method is used to attach a screen shot when the test script fails
	 * @param test
	 * @param screenShotPath
	 * @param title
	 * @param strategy
	 */
	public void attachScreenShot(ExtentTest test, String screenShotPath, String title, String strategy)
	{
		if(strategy.equals("base64"))
			test.addScreenCaptureFromBase64String(screenShotPath, title);
		else
			test.addScreenCaptureFromPath(screenShotPath, title);
	}
	
	/**
	 * this method is used to save the reports 
	 */
	public void saveReport() {
		report.flush();
		report.getAttribSubject();
		try {
			Desktop.getDesktop().browse(new File(extentReportPath).toURI());
	
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}
