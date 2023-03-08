package hms.practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
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

public class PatientApointBookingTest {
	public static void main(String[] args) throws IOException 
	{
		String exptestScriptName="bookAppointment";
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
//		String dochome= "Dashboard";
//		String pathome= "USER | DASHBOARD";
		
		FileInputStream fis1= new FileInputStream
				("./src/test/resources/commanData/addpat.properties");
		Properties prop = new Properties();
		prop.load(fis1);
		String appurl = prop.getProperty("url");
		String doc_un= prop.getProperty("D_UN");
		String doc_pw= prop.getProperty("D_PW");
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
			driver.findElement(By.xpath("//a[@href='hms/user-login.php']")).click();
		    driver.findElement(By.name("username")).sendKeys(pat_un);
		    driver.findElement(By.name("password")).sendKeys(pat_pw);
		    driver.findElement(By.name("submit")).click();
		    String patdash = driver.findElement(By.xpath("//h1[text()='User | Dashboard']")).getText();
		    if(patdash.equals(map.get("patient_homepage")))
			{
				System.out.println("patient home page displayed");
			}
			else
			{
				System.out.println("patient home page not displayed");
			}
		    driver.findElement(By.xpath 
		    		("//span[contains(text(), ' Book Appointment ')]")).click();
		    WebElement spec = driver.findElement(By.name("Doctorspecialization"));
		    // to select from drop down
		    Select s = new Select(spec);
		    s.selectByVisibleText("General Physician");
		    WebElement doc = driver.findElement(By.name("doctor"));
		    Select s1 = new Select(doc);
		    s1.selectByVisibleText("Dr. Doctor");
		    driver.findElement(By.name("appdate")).click();
		    driver.findElement(By.name("appdate")).sendKeys(map.get("appointment_date"));
		    driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		    //handle pop up
		    driver.switchTo().alert().accept();
		    driver.findElement(By.xpath("//i[@class=\"ti-angle-down\"]")).click();
		    driver.findElement(By.xpath("//a[contains(text(), 'Log Out')]")).click();
		    //doctor login
		    driver.findElement(By.xpath("//a[@href='hms/doctor/']")).click();
		    driver.findElement(By.name("username")).sendKeys(doc_un);
		    driver.findElement(By.name("password")).sendKeys(doc_pw);
		    driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		    String docdash = driver.findElement(By.xpath("//span[.='Dashboard']")).getText();
		    if(docdash.equals(map.get("doctor_homepage")))
		    {
		    	System.out.println("Doc Dashboard page is displayed");
		    }
		    else
		    {
		    	System.out.println("Doc Dashboard page not displayed");
		    }
		    driver.findElement(By.xpath("//a[@href='appointment-history.php']")).click();
		    //driver.switchTo().alert().accept();
		    driver.quit();

	}


}
