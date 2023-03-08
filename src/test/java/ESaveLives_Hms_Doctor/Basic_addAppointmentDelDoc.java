package ESaveLives_Hms_Doctor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

public class Basic_addAppointmentDelDoc {

	public static void main(String[] args) throws IOException 
	{
		String apphome= "Hospital Management system";
		String pathome= "USER | DASHBOARD";
		String admhome= "ADMIN | DASHBOARD";
		String DocEmail = new Random().nextInt(100)+"suresh@gmail.com";
		
		FileInputStream fis= new FileInputStream
				("./src/test/resources/commanData/addpat.properties");
		Properties prop = new Properties();
		prop.load(fis);
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
	 
	    //add doctor
	    driver.findElement(By.xpath("//span[contains(text(), ' Doctors ')]")).click();
	    driver.findElement(By.xpath("//span[contains(text(), ' Add Doctor')]")).click();
	    WebElement ds = driver.findElement(By.name("Doctorspecialization"));
	    Select s = new Select(ds);
	    s.selectByVisibleText("Oncologist");
	    driver.findElement(By.name("docname")).sendKeys("Suresh");
	    driver.findElement(By.name("clinicaddress")).sendKeys("Bangalore");
	    driver.findElement(By.name("docfees")).sendKeys("1000");
	    driver.findElement(By.name("doccontact")).sendKeys("9812345678");
	    driver.findElement(By.name("docemail")).sendKeys(DocEmail);
	    driver.findElement(By.name("npass")).sendKeys("suresh");
	    driver.findElement(By.name("cfpass")).sendKeys("suresh");
	    driver.findElement(By.name("submit")).click();
	    driver.switchTo().alert().accept();
	    driver.findElement(By.xpath("//i[@class='ti-angle-down']")).click();
	    driver.findElement(By.xpath("//a[contains(text(), 'Log Out')]")).click();
	    //login as patient
	    driver.findElement(By.xpath("(//a[contains(text(), 'Click Here')])[1]")).click();
	    driver.findElement(By.name("username")).sendKeys(pat_un);
	    driver.findElement(By.name("password")).sendKeys(pat_pw);
	    driver.findElement(By.name("submit")).click();
	    String patdash = driver.findElement(By.xpath("//h1[text()='User | Dashboard']")).getText();
	    if(patdash.equals(pathome))
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
	    driver.findElement(By.name("appdate")).sendKeys("2023-02-14");
//	    driver.findElement(By.xpath("//td[contains(text(), '7')")).click();
	    driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
	    //handle pop up
	    driver.switchTo().alert().accept();
	    driver.findElement(By.xpath("//i[@class=\"ti-angle-down\"]")).click();
	    driver.findElement(By.xpath("//a[contains(text(), 'Log Out')]")).click();
	    //admin login
	    driver.findElement(By.xpath("(//a[contains(text(), 'Click Here')])[3]")).click();
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
	    //del doctor
	    driver.findElement(By.xpath("//span[contains(text(), ' Doctors ')]")).click();
	    driver.findElement(By.xpath("//span[contains(text(), ' Manage Doctors ')]")).click();
	    driver.findElement(By.xpath("(//i[@class='fa fa-times fa fa-white'])[last()]")).click();
	    driver.switchTo().alert().accept();
	    
	    
	}

}
