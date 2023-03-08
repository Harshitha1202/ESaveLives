package hms.practice;

import java.io.FileInputStream;
import java.io.IOException;

import javax.swing.plaf.synth.SynthStyleFactory;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchDataFromExcel_1 
{
	public static void main(String[] args) throws IOException 
	{
		// converts all the data to string irrespective of data type
		DataFormatter df= new DataFormatter();
		//step 1 ..java readable
		FileInputStream fis= new FileInputStream("./src/test/resources/datafile.xlsx");
		//step 2... open excel
		Workbook wb = WorkbookFactory.create(fis);
		// step 3... control sheet
		Sheet sheet = wb.getSheet("med1");
		int rowCount= sheet.getLastRowNum();
		System.out.println(rowCount);
		for (int i = 0; i <= rowCount; i++) 
		{
			short cellCount = sheet.getRow(i).getLastCellNum();
			System.out.println(cellCount);
			for (int j = 0; j < cellCount; j++)
			{
				System.out.println(df.formatCellValue(sheet.getRow(i).getCell(j)));
			}
		}
		// close WB and FS
		wb.close(); 
		fis.close();
		
	}

}
