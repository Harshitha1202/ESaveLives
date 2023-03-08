package com.tyss.Generic_Utility.Enums;

public enum AdminDashboardTabNames {

	DOCTOR("Doctors"),
	DOCTOR_SPECIALIZATION("Doctor Specialization"),
	ADD_DOCTOR("Add Doctor"),
	MANAGE_DOCTOR("Manage Doctors");
	
	private String tabName;
	
	private AdminDashboardTabNames(String tabName)
	{
		this.tabName=tabName;
	}
	
	public String getTab()
	{
		return tabName;
	}
}
