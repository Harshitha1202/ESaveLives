package hms.practice;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchDataFromExcel_4 
{

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
		List<String> dataList = new ArrayList<>();
		for (int i = 1; i < rowCount; i++) 
		{
			String testScriptName= df.formatCellValue(sheet.getRow(i).getCell(0));
			if(testScriptName.equals(exptestScriptName))
			{
				for (int j = 0; j < sheet.getRow(i).getLastCellNum(); j++) 
				{
					String key = df.formatCellValue(sheet.getRow(i).getCell(j));
					if(key.equals(expKey))
					{
						for (int k = i+1; ; k++) 
						{
							String data = df.formatCellValue(sheet.getRow(k).getCell(j));
							if(data.equals(""))
							{
								break;
							}
							else
							{
								dataList.add(data);
							}
						}
						break;
					}
				
				}
				break;
			}
			
		}
		System.out.println(dataList);
	}
}