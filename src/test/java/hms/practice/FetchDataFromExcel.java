package hms.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchDataFromExcel {

	public static void main(String[] args) throws IOException 
	{
		// converts all the data to string irrespective of datatype
		DataFormatter df= new DataFormatter();
		//step 1 ..java readable
		FileInputStream fis= new FileInputStream("./src/test/resources/datafile.xlsx");
		//step 2... open excel
		Workbook wb = WorkbookFactory.create(fis);
		// step 3... control sheet
		Sheet sheet = wb.getSheet("med1");
		//step 4... control row
		Row row = sheet.getRow(2);
		//step 5.. control cell
		Cell cell = row.getCell(1);
		//step 6 .. fetch data
		String fetched_data = df.formatCellValue(cell);
		//step 7 
		System.out.println(fetched_data);
		// close WB and FS
		wb.close();
		fis.close();
		
	}

}
