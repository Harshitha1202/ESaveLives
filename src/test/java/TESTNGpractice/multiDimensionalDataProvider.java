package TESTNGpractice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tyss.Generic_Utility.ExcelUtility;
import com.tyss.Generic_Utility.TestNextGenAnnotations;
import com.tyss.Generic_Utility.Constants.FrameWorkConstants;

public class multiDimensionalDataProvider extends TestNextGenAnnotations{
	
	@Test(dataProvider = "data")
	public void test(String patient_name, String patient_contact, String patient_email, String pat_address)
	{
		System.out.println(patient_name+"  "+patient_contact);
		System.out.println("from add_patient");
	}


	@DataProvider
	public String[][] data()
	{
		ExcelUtility excelutil= new ExcelUtility(FrameWorkConstants.EXCEL_PATH);
		return excelutil.getData("test");
	}
	
}



