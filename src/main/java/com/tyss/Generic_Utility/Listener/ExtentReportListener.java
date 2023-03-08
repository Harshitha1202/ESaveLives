package com.tyss.Generic_Utility.Listener;

import java.lang.annotation.Annotation;

import org.openqa.selenium.WebDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.tyss.Generic_Utility.TestNextGenAnnotations;
import com.tyss.Generic_Utility.Constants.FrameWorkConstants;
import com.tyss.Generic_Utility.Constants.Report;
import com.tyss.Generic_Utility.Constants.ReportUtility;
import com.tyss.Generic_Utility.Constants.UtilityInstanceTransfer;
import com.tyss.Generic_Utility.Enums.ExcelSheet.PropertyKey;
import com.tyss.Generic_Utility.ExternalFileUtility.PropertyUtility;
import com.tyss.Generic_Utility.ExternalFileUtility.SystemDateUtility;
/**
 * This class is a listener
 * @author MBA-Student110
 *
 */
public class ExtentReportListener implements ITestListener, ISuiteListener
{

	private ReportUtility report;
	public static ReportUtility sreport;
	
	/**
	 * onFinish listener
	 */
	@Override
	public void onFinish(ISuite suite) 
	{
		System.out.println("onFinish");
	}
	
	/**
	 * onStart listener
	 */
	@Override
	public void onStart(ISuite suite) 
	{
		System.out.println("onStart-Suite");
		report= new ReportUtility();
		sreport=report;
	}

	/**
	 * onFinish listener to save the report
	 */
	@Override
	public void onFinish(ITestContext context) 
	{
	System.out.println("onFinish--test");
	report.saveReport();
	}

	/**
	 * onStart listener
	 */
	@Override
	public void onStart(ITestContext context) 
	{
		System.out.println("onStart-test");	
	}
	
	/**
	 * onTestFailedButWithinSuccessPercentage listener
	 */
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{
		System.out.println("onTestFailedButWithinSuccessPercentage");
	}

	/**
	 * onTestFailedWithTimeout listener
	 */
	@Override
	public void onTestFailedWithTimeout(ITestResult result) 
	{
	System.out.println("onTestFailedWithTimeout");
	}
	
	/**
	 * onTestFailure listener used to attach a screenshot to report for failed test scripts
	 */
	@Override
	public void onTestFailure(ITestResult result) 
	{
		System.out.println("onTestFailure");
		String screeenShotpath = null;
		report.fail(UtilityInstanceTransfer.getExtentTest(), result.getMethod().getMethodName()+ " is failed", result.getThrowable());
		Object classInstance=result.getMethod().getInstance();
		String screenShotpath = TestNextGenAnnotations.class.cast(classInstance).javautil.getScreenShot();
		report.attachScreenShot(UtilityInstanceTransfer.getExtentTest(), screenShotpath, result.getMethod().getMethodName(), "base64");
	}
	
	/**
	 * onTestSkipped listener
	 */
	@Override
	public void onTestSkipped(ITestResult result) 
	{
		System.err.println("onTestSkipped");
		report.fail(UtilityInstanceTransfer.getExtentTest(), result.getMethod().getMethodName()+ " is failed", result.getThrowable());
	}
	
	/**
	 * onTestStart listener used to fetch and print author and category
	 */
	@Override
	public void onTestStart(ITestResult result) 
	{
		System.out.println("onTestStart");
		report.createTest(result.getMethod().getMethodName());
		Report reportAnnotation = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(Report.class);
		System.out.println(reportAnnotation.author());
		System.out.println(reportAnnotation.category());
		report.addAuthor(UtilityInstanceTransfer.getExtentTest(), reportAnnotation.author());
		report.addAuthor(UtilityInstanceTransfer.getExtentTest(), reportAnnotation.category());
	}
	
	/**
	 * onTestSuccess listener
	 */
	@Override
	public void onTestSuccess(ITestResult result) 
	{
		System.out.println("onTestSuccess");
		report.pass(UtilityInstanceTransfer.getExtentTest(), result.getMethod().getMethodName()+ " is pass");
	}
	

}
