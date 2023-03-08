package com.tyss.Generic_Utility.Listener;

import org.testng.IClassListener;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestClass;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.internal.annotations.IListeners;

public class ListenerImplementation implements ITestListener, ISuiteListener, IClassListener
{

	@Override
	public void onAfterClass(ITestClass testClass) {
		System.out.println("onAfterClass");
		
	}

	@Override
	public void onBeforeClass(ITestClass testClass) {
		System.out.println("onBeforeClass");
		
	}

	@Override
	public void onFinish(ISuite suite) {
		System.out.println("onFinish-Suite");
		
	}

	@Override
	public void onStart(ISuite suite) {
		System.out.println("onStart-suite");
		
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("onFinish");
		
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("onStart");
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("onTestFailedButWithinSuccessPercentage");
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		System.out.println("onTestFailedWithTimeout");
	}

	@Override
	public void onTestFailure(ITestResult result) {
	System.out.println("onTestFailure");
	ListenerBaseClass base = ListenerBaseClass.class.cast(result.getMethod().getInstance());
	base.javautil.capturePageScreenShot( result.getMethod().
		getRealClass().getSimpleName(), base.systemdateutil);
	
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("onTestSkipped");
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("onTestStart");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("onTestSuccess");
	}
	

}
