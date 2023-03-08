package hms.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FectchDataFromExcelMap 
{

	public static void main(String[] args) throws IOException 
	{
		String exptestScriptName="add_patient";
		String expKey="patient_name";
		String sheetname="testscriptdata";
		
		DataFormatter df= new DataFormatter();
		FileInputStream fis= new FileInputStream("./src/test/resources/datafile.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(sheetname);
		int rowCount= sheet.getLastRowNum();//index
		Map<String,String> map= new HashMap<>();
		for (int i = 1; i < rowCount; i++) 
		{
			String testScriptName= df.formatCellValue(sheet.getRow(i).getCell(0));
			if(testScriptName.equals(exptestScriptName))
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
		System.out.println(map.get(expKey));
	}
}