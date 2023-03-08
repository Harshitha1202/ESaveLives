package hms.practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchDataFromExcel2 {
	public static void main(String[] args) throws IOException 
	{
		String exptestScriptName="patientLoginTest";
		String expKey="cred_name";
		
		// converts all the data to string irrespective of datatype
		DataFormatter df= new DataFormatter();
		//step 1 ..java readable
		FileInputStream fis= new FileInputStream("./src/test/resources/datafile.xlsx");
		//step 2... open excel
		Workbook wb = WorkbookFactory.create(fis);
		// step 3... control sheet
		Sheet sheet = wb.getSheet("medicalhistory");
		int rowCount= sheet.getLastRowNum();//index
		String value="";
		//System.out.println(rowCount);
		for(int i=0; i<=rowCount ; i++)
		{
			String testScriptName= df.formatCellValue(sheet.getRow(i).getCell(0));
			if(testScriptName.equals(exptestScriptName))
			{
				for (int j = 0; j < sheet.getRow(i).getLastCellNum(); j++) 
				{
				    String key = df.formatCellValue(sheet.getRow(i).getCell(j));
				    System.out.println(key);
					
				    if(key.equals(expKey))
				    {
				    	value=df.formatCellValue(sheet.getRow(i+1).getCell(j));
				    	break;
				    }
				}
				break;
			}
		}
		System.out.println(value);
		
		wb.close();
		fis.close();
	}

}
