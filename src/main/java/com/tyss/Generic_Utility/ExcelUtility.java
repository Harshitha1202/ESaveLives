package com.tyss.Generic_Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility 
{
	DataFormatter df;
	Workbook wb;
	
	/**
	 * Constructor with no parameter
	 */
	public ExcelUtility()
	{
		
	}
	
	public ExcelUtility(String fileName) throws EncryptedDocumentException
	{
		try {
			initiallize(fileName);
		} catch (IOException e) 
		{
			
		}
		
	}
	/**
	 * 
	 * @param fileName
	 * @throws IOException 
	 * @throws EncryptedDocumentException 
	 */
	private void initiallize(String filePath) throws EncryptedDocumentException, IOException 
	{
		df = new DataFormatter();
		FileInputStream fisExcel = new FileInputStream(filePath);
		wb=WorkbookFactory.create(fisExcel);
		fisExcel.close();
	}

	public Map<String, String> getData(String sheetName, String exptestCaseName)
	{
		Sheet sheet = wb.getSheet(sheetName);
		int rowCount= sheet.getLastRowNum();//index
		Map<String,String> map= new HashMap<>();
		for (int i = 1; i < rowCount; i++) 
		{
			String testScriptName= df.formatCellValue(sheet.getRow(i).getCell(0));
			if(testScriptName.equals(exptestCaseName))
			{
				for (int j = 0; j < sheet.getRow(i).getLastCellNum(); j++) 
				{
					String key = df.formatCellValue(sheet.getRow(i).getCell(j));
					String value = df.formatCellValue(sheet.getRow(i+1).getCell(j));
					map.put(key, value);
				}
				break;
			}
		}
		return map;
	}
	
	
	/**
	 * This method is used to get the data and returns value
	 * @param sheetName
	 * @param exptestCaseName
	 * @param expectedkey
	 * @return
	 */
	public String getData(String sheetName, String exptestCaseName, String expectedkey)
	{
		Sheet sheet = wb.getSheet(sheetName);
		int rowCount= sheet.getLastRowNum();//index
		String value="";
		int testScriptCounter= 0;
		int keyCounter=0;
		for (int i = 1; i < rowCount; i++) 
		{
			String testScriptName= df.formatCellValue(sheet.getRow(i).getCell(0));
			if(testScriptName.equals(exptestCaseName))
			{
				testScriptCounter++;
				for (int j = 0; j < sheet.getRow(i).getLastCellNum(); j++) 
				{
					String key = df.formatCellValue(sheet.getRow(i).getCell(j));
					if(key.equals(expectedkey))
					{
						keyCounter++;
						value=df.formatCellValue(sheet.getRow(i+1).getCell(j));
						break;
					}
				}
				break;
			}
		}
		if(keyCounter==0)
		{ 
			if(testScriptCounter==0)
			{
				value="please give proper testscript key'"+exptestCaseName+"'";
			}
			else
			{
				value="please give proper testscript key'"+expectedkey+"'";	
			}
		}
		System.out.println("value fetched from excel--> "+value);
		return value;
	}
	
	/**
	 * this method is used to get multidimensional data from the excel
	 * @param sheetName
	 * @return
	 */
	public String[][] getData(String sheetName)
	{
		Sheet sheet= wb.getSheet(sheetName);
		int rowCount= sheet.getLastRowNum();
		String[][] arr= new String[rowCount][sheet.getRow(0).getLastCellNum()];
		for (int i=1; i<=rowCount; i++)
		{
			for(int j=0; j<sheet.getRow(i).getLastCellNum(); j++)
			{
				arr[i-1][j]=df.formatCellValue(sheet.getRow(i).getCell(j));
			}
		}
		return arr;
	}
	
	/**
	 * this methods returns the value
	 * @param sheetName
	 * @param rowIndex
	 * @param cellIndex
	 * @return
	 */
	public String getData(String sheetName, int rowIndex, int cellIndex)
	{
		String value = df.formatCellValue(wb.getSheet(sheetName).getRow(rowIndex).getCell(cellIndex));
		return value;
		
	}
	/**
	 * this method is used to close the workbook
	 */
	public void close()
	{
		try {
			wb.close();
		} catch (IOException e) {
			
		}
	}

	/**
	 * this method is used to write the data
	 * @param sheetName
	 * @param rowIndex
	 * @param cellIndex
	 */
	public void setData(String sheetName, int rowIndex, int cellIndex)
	{
		wb.getSheet(sheetName).getRow(rowIndex).createCell(cellIndex);
	}
	
	/**
	 * this method is used to save the data
	 * @param fileOutputPath
	 */
	public void saveData(String fileOutputPath)
	{
		try 
		{
			wb.write(new FileOutputStream(fileOutputPath));
		} catch (Throwable e) {
			
		}
	}
}










