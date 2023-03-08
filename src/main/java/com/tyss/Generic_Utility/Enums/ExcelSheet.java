package com.tyss.Generic_Utility.Enums;

public enum ExcelSheet {
	//sheet names
	MEDICALHISTORY("medicalhistory"), MED1("med1"), TESTSCRIPTDATA("testscriptdata");
	String key;
	
	private ExcelSheet(String key)
	{
		this.key=key;
	}
	
	private String getSheetName()
	{
		return key;
	}
	
	public enum PropertyKey
	{
		BROWSER, TIMEOUT, URL, DOCTOR_USERNAME, DOCTOR_PASSWORD, ADMIN_USERNAME, ADMIN_PASSWORD,
		PATIENT_USERNAME, PATIENT_PASSWORD, EXTENTREPORTTITLE, EXTENTREPORTNAME, OVERRIDEREPORT;
	}
	
	

}
