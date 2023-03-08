package hms.practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;		
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AdminDoctorTest {
	public static void main(String[] args) throws IOException
	{
		
		String exptestScriptName="Adm_doctorModule";
		//String expKey="patient_name";
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
			
//		
//		String apphome= "Hospital Management system";
//		String admhome= "ADMIN | DASHBOARD";
//		String A_addspecialization= "ADMIN | ADD DOCTOR SPECIALIZATION";
//		String A_adddoctor= "ADMIN | ADD DOCTOR";
//		String A_managedoctor= "ADMIN | MANAGE DOCTORS";
//		String A_deletedoctor = "data deleted !!";
//		String DoctorEmail= new Random().nextInt(100)+"n@gmail.com";
//		
		FileInputStream fis1= new FileInputStream
				("./src/test/resources/commanData/addpat.properties");
		Properties prop = new Properties();
		prop.load(fis1);
		String appurl = prop.getProperty("url");
		String adm_un= prop.getProperty("A_UN");
		String adm_pw= prop.getProperty("A_PW");
//		fis.close();
//		prop.clear();
		
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(appurl);
			
			String home = driver.findElement(By.xpath("//a[.='Hospital Management system']")).getText();
			if(home.equals(map.get("apphome")))
			{
				System.out.println("application home page displayed");
			}
			else
			{
				System.out.println("application home page not displayed");
			}
			 driver.findElement(By.xpath("//a[@href='hms/admin']")).click();
			    driver.findElement(By.name("username")).sendKeys(adm_un);
			    driver.findElement(By.name("password")).sendKeys(adm_pw);
			    driver.findElement(By.xpath("//button[contains(text(), 'Login ')]")).click();
			    String admdash = driver.findElement(By.xpath("//h1[.='Admin | Dashboard']")).getText();
			    if(admdash.equals(map.get("admhome")))
			    {
			    	System.out.println("admin home page displayed");
			    }
			    else
			    {
			    	System.out.println("admin home page not displayed");
			    }
			    driver.findElement(By.xpath("//span[contains(text(), ' Doctors ')]")).click();
			    //add doc specialization
			    driver.findElement(By.xpath
			    		("//span[contains(text(), ' Doctor Specialization ')]")).click();
			    String addspec = driver.findElement(By.xpath("//h1[.='Admin | Add Doctor Specialization']")).getText();
			    if(addspec.equals(map.get("A_addspecialization")))
			    {
			    	System.out.println("add specializtion page is displayed");
			    }
			    else
			    {
			    	System.out.println("add specializtion page is not displayed");
			    }

			    driver.findElement(By.name("doctorspecilization")).sendKeys(map.get("doctor specialization"));
			    driver.findElement(By.name("submit")).click();
			    String spec_success = driver.findElement(By.xpath("//p[contains(text(), 'Specialization added successfully')]")).getText();
			    if(spec_success.equals(map.get("addspecialization_success")))
			    {
			    	System.out.println("specialzation added");
			    }
			    else
			    {
			    	System.out.println("specialzation not added");
			    }
			    //add doctor
			    driver.findElement(By.xpath("//span[contains(text(), ' Doctors ')]")).click();
			    driver.findElement(By.xpath("//span[contains(text(), ' Add Doctor')]")).click();
			    String adddoc = driver.findElement
			    		(By.xpath("//h1[.='Admin | Add Doctor']")).getText();
			    if(adddoc.equals(map.get("A_adddoctor")))
			    {
			    	System.out.println("add doctor page is displayed");
			    }
			    else
			    {
			    	System.out.println("add doctor page is displayed");
			    }
			    WebElement ds = driver.findElement(By.name("Doctorspecialization"));
			    Select s = new Select(ds);
			    s.selectByVisibleText("Cardiologist");
			    driver.findElement(By.name("docname")).sendKeys(map.get("doctor_name"));
			    driver.findElement(By.name("clinicaddress")).sendKeys(map.get("clinic_address"));
			    driver.findElement(By.name("docfees")).sendKeys(map.get("doctor _fees"));
			    driver.findElement(By.name("doccontact")).sendKeys(map.get("doctor_contactno"));
			    String DoctorMail= map.get("doc_email")+new Random().nextInt(100)+"@gmail.com";
			    driver.findElement(By.name("docemail")).sendKeys(DoctorMail);
			    driver.findElement(By.name("npass")).sendKeys(map.get("new_password"));
			    driver.findElement(By.name("cfpass")).sendKeys(map.get("confirm_password"));
			    driver.findElement(By.name("submit")).click();
			    driver.switchTo().alert().accept();
			    
			    //manage doctor
			    driver.findElement(By.xpath("//span[contains(text(), ' Doctors ')]")).click();
			    driver.findElement(By.xpath
			    			("//span[contains(text(), ' Manage Doctors ')]")).click();
			    String managedoc = driver.findElement
			    			(By.xpath("//h1[.='Admin | Manage Doctors']")).getText();
			    if(managedoc.equals(map.get("A_managedoctor")))
			    {
			    	System.out.println("manage doctor page is displayed");
			    }
			    else
			    {
			    	System.out.println("manage doctor page is displayed");
			    }
			    driver.findElement(By.xpath("(//i[@class='fa fa-pencil'])[last()]")).click();
	//			WebElement editds = driver.findElement(By.name("Doctorspecialization"));
	//			Select s1 = new Select(ds);
	//			s.selectByVisibleText("Cardiologist");
			    driver.findElement(By.name("docname")).clear();
			    driver.findElement(By.name("clinicaddress")).clear();
			    driver.findElement(By.name("docfees")).clear();
			    driver.findElement(By.name("doccontact")).clear();
			    driver.findElement(By.name("docname")).sendKeys(map.get("update_doctorname"));
			    driver.findElement(By.name("clinicaddress")).sendKeys(map.get("update_clinicaddress"));
			    driver.findElement(By.name("docfees")).sendKeys(map.get("update_doctorfees"));
			    driver.findElement(By.name("doccontact")).sendKeys(map.get("update_doctorcontact"));
			    driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
			    String doc_detailsupadte = driver.findElement
			    		(By.xpath("//h5[contains(text(), 'updated Successfully')]")).getText();
			    if(doc_detailsupadte.equals(map.get("doc_details_updated")))
			    {
			    	System.out.println("doctor details updated successfully");
			    }
			    else
			    {
			    	System.out.println("doctor details update not successful");
			    }
			    //del doctor
			    driver.findElement(By.xpath("//span[contains(text(), ' Doctors ')]")).click();
			    driver.findElement(By.xpath("//span[contains(text(), ' Manage Doctors ')]")).click();
			    driver.findElement(By.xpath("(//i[@class='fa fa-times fa fa-white'])[last()]")).click();
			    driver.switchTo().alert().accept();
			    String deldoc = driver.findElement(By.xpath("//p[contains(text(),'data del')]")).getText();
			    if(deldoc.equals(map.get("A_deletedoctor")))
			    {
			    	System.out.println("doctor deleted");
			    }
			    else
			    {
			    	System.out.println("doctor not deleted");
			    }
			   
			    driver.quit();
		}

	

}
