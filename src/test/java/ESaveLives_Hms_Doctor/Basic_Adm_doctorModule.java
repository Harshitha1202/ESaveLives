package ESaveLives_Hms_Doctor;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Basic_Adm_doctorModule {

	public static void main(String[] args) throws IOException
	{
		String apphome= "Hospital Management system";
		String admhome= "ADMIN | DASHBOARD";
		String A_addspecialization= "ADMIN | ADD DOCTOR SPECIALIZATION";
		String A_adddoctor= "ADMIN | ADD DOCTOR";
		String A_managedoctor= "ADMIN | MANAGE DOCTORS";
		String A_deletedoctor = "data deleted !!";
		String DoctorEmail= new Random().nextInt(100)+"n@gmail.com";
		
		FileInputStream fis= new FileInputStream
				("./src/test/resources/commanData/addpat.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String appurl = prop.getProperty("url");
		String adm_un= prop.getProperty("A_UN");
		String adm_pw= prop.getProperty("A_PW");
		fis.close();
		prop.clear();
		
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(appurl);
			String home = driver.findElement(By.xpath("//a[.='Hospital Management system']")).getText();
			if(home.equals(apphome))
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
			    if(admdash.equals(admhome))
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
			    if(addspec.equals(A_addspecialization))
			    {
			    	System.out.println("add specializtion page is displayed");
			    }
			    else
			    {
			    	System.out.println("add specializtion page is not displayed");
			    }

			    driver.findElement(By.name("doctorspecilization")).sendKeys("Cardiologist");
			    driver.findElement(By.name("submit")).click();
			    //add doctor
			    driver.findElement(By.xpath("//span[contains(text(), ' Doctors ')]")).click();
			    driver.findElement(By.xpath("//span[contains(text(), ' Add Doctor')]")).click();
			    String adddoc = driver.findElement
			    		(By.xpath("//h1[.='Admin | Add Doctor']")).getText();
			    if(adddoc.equals(A_adddoctor))
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
			    driver.findElement(By.name("docname")).sendKeys("Nagesh");
			    driver.findElement(By.name("clinicaddress")).sendKeys("Bangalore");
			    driver.findElement(By.name("docfees")).sendKeys("1000");
			    driver.findElement(By.name("doccontact")).sendKeys("9123456789");
			    driver.findElement(By.name("docemail")).sendKeys(DoctorEmail);
			    driver.findElement(By.name("npass")).sendKeys("nagesh");
			    driver.findElement(By.name("cfpass")).sendKeys("nagesh");
			    driver.findElement(By.name("submit")).click();
			    driver.switchTo().alert().accept();
			    //manage doctor
			    driver.findElement(By.xpath("//span[contains(text(), ' Doctors ')]")).click();
			    driver.findElement(By.xpath
			    			("//span[contains(text(), ' Manage Doctors ')]")).click();
			    String managedoc = driver.findElement
			    			(By.xpath("//h1[.='Admin | Manage Doctors']")).getText();
			    if(managedoc.equals(A_managedoctor))
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
			    driver.findElement(By.name("docname")).sendKeys("Dr. Nagesh");
			    driver.findElement(By.name("clinicaddress")).sendKeys("Bangalore");
			    driver.findElement(By.name("docfees")).sendKeys("1000");
			    driver.findElement(By.name("doccontact")).sendKeys("9123456789");
			    driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
			    //del doctor
			    driver.findElement(By.xpath("//span[contains(text(), ' Doctors ')]")).click();
			    driver.findElement(By.xpath("//span[contains(text(), ' Manage Doctors ')]")).click();
			    driver.findElement(By.xpath("(//i[@class='fa fa-times fa fa-white'])[last()]")).click();
			    driver.switchTo().alert().accept();
			    String deldoc = driver.findElement(By.xpath("//p[contains(text(),'data del')]")).getText();
			    if(deldoc.equals(A_deletedoctor))
			    {
			    	System.out.println("doctor deleted");
			    }
			    else
			    {
			    	System.out.println("doctor not deleted");
			    }
			   
			    
		}

}
