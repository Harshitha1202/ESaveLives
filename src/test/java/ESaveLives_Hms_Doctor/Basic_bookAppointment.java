package ESaveLives_Hms_Doctor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Basic_bookAppointment {

	public static void main(String[] args) throws IOException 
	{

		String apphome= "Hospital Management system";
		String dochome= "Dashboard";
		String pathome= "USER | DASHBOARD";
		
		FileInputStream fis= new FileInputStream
				("./src/test/resources/commanData/addpat.properties");
		Properties prop = new Properties();
		prop.load(fis);
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
		if(home.equals(apphome))
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
		    if(patdash.equals(pathome))
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
		    driver.findElement(By.name("appdate")).sendKeys("2023-02-14");
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
		    if(docdash.equals(dochome))
		    {
		    	System.out.println("Doc Dashboard page is displayed");
		    }
		    else
		    {
		    	System.out.println("Doc Dashboard page not displayed");
		    }
		    driver.findElement(By.xpath("//a[@href='appointment-history.php']")).click();
		    //driver.switchTo().alert().accept();

	}

}
