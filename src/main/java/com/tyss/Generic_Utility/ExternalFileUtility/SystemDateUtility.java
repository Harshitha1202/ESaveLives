package com.tyss.Generic_Utility.ExternalFileUtility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SystemDateUtility {
	/**
	 * this method is used to fetch current date and time
	 * @return 
	 */
	public String getCurrentDateAndTime()
	{
		SimpleDateFormat sdf=new SimpleDateFormat("dd_MM_yyyy");
		String date= sdf.format(new Date());
		return date;
	}
	
	
	/**
	 * this method is used to fetch current date with pattern dd_MM_yyyy
	 * @return 
	 */
	public String getCurrentDate(String pattern)
	{
		SimpleDateFormat sdf=new SimpleDateFormat(pattern);
		String date= sdf.format(new Date());
		return date;
	}
	
	/**
	 * this method is used to add days with the current date
	 * @return 
	 */
	public String addAndSubWithCurrentDate(int days)
	{
		SimpleDateFormat sdf=new SimpleDateFormat("dd_MM_yyyy");
		Calendar cal= Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, days);
		String date = sdf.format(cal.getTime());
		return date;
	}
	
	/**
	 * this method is used to add days with the current date in the pattern dd_MM_yyyy or dd_MMM_yyyy
	 * @return 
	 */
	public String addAndSubWithCurrentDate(String pattern, int days)
	{
		SimpleDateFormat sdf=new SimpleDateFormat(pattern);
		Calendar cal= Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, days);
		String date = sdf.format(cal.getTime());
		return date;
	}
	
	/**
	 * this method is used to add and sub days along with the specified dates
	 * @return 
	 */
	public String addAndSubWithParseDate(String parseDate, int days)
	{
		
		SimpleDateFormat sdf=new SimpleDateFormat("dd_MM_yyyy");
		Calendar cal= Calendar.getInstance();
		try {
			cal.setTime(sdf.parse(parseDate));
		} catch (ParseException e) {
			
		}
		cal.add(cal.DAY_OF_MONTH, days);
		String date = sdf.format(cal.getTime());
		return date;	 
	}
	/**
	 * this method is used to add days along with the specified dates in the pattern dd_MM_yyyy or dd_MMM_yyyy
	 * @return 
	 */
	public String addAndSubWithParseDate(String pattern, String parseDate, int days)
	{

		SimpleDateFormat sdf=new SimpleDateFormat(pattern);
		Calendar cal= Calendar.getInstance();
		try {
			cal.setTime(sdf.parse(parseDate));
		} catch (ParseException e) {
			
		}
		cal.add(cal.DAY_OF_MONTH, days);
		String date = sdf.format(cal.getTime());
		return date;	
	}
	
}
