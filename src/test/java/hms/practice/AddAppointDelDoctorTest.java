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

public class AddAppointDelDoctorTest 
{
	public static void main(String[] args) throws IOException 
	{
		String exptestScriptName="addAppointmentDelDoc";
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
		
//		String apphome= "Hospital Management system";
//		String pathome= "USER | DASHBOARD";
//		String admhome= "ADMIN | DASHBOARD";
//		String DocEmail = new Random().nextInt(100)+"suresh@gmail.com";
		
		FileInputStream fis1= new FileInputStream
				("./src/test/resources/commanData/addpat.properties");
		Properties prop = new Properties();
		prop.load(fis1);
		String appurl = prop.getProperty("url");
		String adm_un= prop.getProperty("A_UN");
		String adm_pw= prop.getProperty("A_PW");
		String pat_un= prop.getProperty("P_UN");
		String pat_pw= prop.getProperty("P_PW");
		fis.close();
		prop.clear();
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(appurl);
		String home = driver.findElement(By.xpath("//a[.='Hospital Management system']")).getText();
		if(home.equals(map.get("application_homepage")))
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
	    if(admdash.equals(map.get("admin_homepage")))
	    {
	    	System.out.println("admin home page displayed");
	    }
	    else
	    {
	    	System.out.println("admin home page not displayed");
	    }
	    
	    //add doctor
	    driver.findElement(By.xpath("//span[contains(text(), ' Doctors ')]")).click();
	    driver.findElement(By.xpath("//span[contains(text(), ' Add Doctor')]")).click();
	    WebElement ds = driver.findElement(By.name("Doctorspecialization"));
	    Select s = new Select(ds);
	    s.selectByVisibleText("Oncologist");
	    driver.findElement(By.name("docname")).sendKeys(map.get("doctor_name"));
	    driver.findElement(By.name("clinicaddress")).sendKeys(map.get("clinic_address"));
	    driver.findElement(By.name("docfees")).sendKeys(map.get("doctor _fees"));
	    driver.findElement(By.name("doccontact")).sendKeys(map.get("doctor_contactno"));
	    String DocEmail = map.get("docter_email")+new Random().nextInt(100)+"@gmail.com";
	    driver.findElement(By.name("docemail")).sendKeys(DocEmail);
	    driver.findElement(By.name("npass")).sendKeys(map.get("new_password"));
	    driver.findElement(By.name("cfpass")).sendKeys(map.get("confirm_password"));
	    driver.findElement(By.name("submit")).click();
	    driver.switchTo().alert().accept();
	    driver.findElement(By.xpath("//i[@class='ti-angle-down']")).click();
	    driver.findElement(By.xpath("//a[contains(text(), 'Log Out')]")).click();
	    //login as patient
	    driver.findElement(By.xpath("//a[@href='hms/user-login.php']")).click();
	    driver.findElement(By.name("username")).sendKeys(pat_un);
	    driver.findElement(By.name("password")).sendKeys(pat_pw);
	    driver.findElement(By.name("submit")).click();
	    String patdash = driver.findElement(By.xpath("//h1[text()='User | Dashboard']")).getText();
	    if(patdash.equals(map.get("patient_homepage")))
		{
			System.out.println("patient logged in, home page displayed");
		}
		else
		{
			System.out.println("patient not logged in, home page not displayed");
		}
	    driver.findElement(By.xpath
	    		("//span[contains(text(), ' Book Appointment ')]")).click();
	    WebElement spec = driver.findElement(By.xpath("//select[@name='Doctorspecialization']"));
	    // to select from drop down
	    Select sp = new Select(spec);
	    sp.selectByVisibleText("Oncologist");
	    WebElement doc = driver.findElement(By.name("doctor"));
	    Select s1 = new Select(doc);
	    s1.selectByVisibleText("Suresh");
	    driver.findElement(By.name("appdate")).click();
	    driver.findElement(By.name("appdate")).sendKeys(map.get("appointment_date"));
//	    driver.findElement(By.xpath("//td[contains(text(), '7')")).click();
	    driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
	    //handle pop up
	    driver.switchTo().alert().accept();
	    driver.findElement(By.xpath("//i[@class=\"ti-angle-down\"]")).click();
	    driver.findElement(By.xpath("//a[contains(text(), 'Log Out')]")).click();
	    //admin login
	    driver.findElement(By.xpath("//a[@href='hms/admin']")).click();
	    driver.findElement(By.name("username")).sendKeys(adm_un);
	    driver.findElement(By.name("password")).sendKeys(adm_pw);
	    driver.findElement(By.xpath("//button[contains(text(), 'Login ')]")).click();
	    String admdash2 = driver.findElement(By.xpath("//h1[.='Admin | Dashboard']")).getText();
	    if(admdash2.equals(map.get("admin_homepage")))
	    {
	    	System.out.println("admin home page displayed");
	    }
	    else
	    {
	    	System.out.println("admin home page not displayed");
	    }
	    //del doctor
	    driver.findElement(By.xpath("//span[contains(text(), ' Doctors ')]")).click();
	    driver.findElement(By.xpath("//span[contains(text(), ' Manage Doctors ')]")).click();
	    driver.findElement(By.xpath("(//i[@class='fa fa-times fa fa-white'])[last()]")).click();
	    driver.switchTo().alert().accept();
	    String deldoc = driver.findElement(By.xpath("//p[contains(text(),'data del')]")).getText();
	    if(deldoc.equals(map.get("delete_doctor")))
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
