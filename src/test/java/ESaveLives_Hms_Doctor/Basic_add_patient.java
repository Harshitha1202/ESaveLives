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

import io.github.bonigarcia.wdm.WebDriverManager;

public class Basic_add_patient {
	public static void main(String[] args) throws IOException 
	{
		String apphome= "Hospital Management system";
		String dochome= "Dashboard";
		String PatEmail= new Random().nextInt(100)+"h@gmail.com";
		
		FileInputStream fis= new FileInputStream
				("./src/test/resources/commanData/addpat.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String appurl = prop.getProperty("url");
		String doc_un= prop.getProperty("D_UN");
		String doc_pw= prop.getProperty("D_PW");
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
		    driver.findElement(By.xpath
		    		("//span[contains(text(), \" Patients \")]")).click();
		    driver.findElement(By.xpath
		    		("//span[contains(text(), \" Add Patient\")]")).click();
		    driver.findElement(By.name("patname")).sendKeys("harshitha");
		    driver.findElement(By.name("patcontact")).sendKeys("9876543211");
		    driver.findElement(By.id("patemail")).sendKeys(PatEmail);
		    driver.findElement(By.xpath("//label[@for=\"rg-female\"]")).isSelected();
		    driver.findElement(By.name("pataddress")).sendKeys("mysore");
		    driver.findElement(By.name("patage")).sendKeys("25");
		    driver.findElement(By.name("medhis")).sendKeys("normal");
		    driver.findElement(By.id("submit")).click();
		   
		    driver.findElement(By.xpath
		    		("//span[contains(text(), \" Patients \")]")).click();
		    driver.findElement(By.xpath
		    		("//span[contains(text(),  'Manage Patient')]")).click();
		    driver.findElement(By.xpath("(//i[@class=\"fa fa-eye\"])[last()]")).click();
		    driver.findElement(By.xpath
		    		("//button[contains(text(), 'Add Medical History')]")).click();
		    driver.findElement(By.name("bp")).sendKeys("120/80mmHg");
		    driver.findElement(By.name("bs")).sendKeys("100mg/dL");
		    driver.findElement(By.name("weight")).sendKeys("80");
		    driver.findElement(By.name("temp")).sendKeys("95F");
		    driver.findElement(By.name("pres")).sendKeys("regular diet");
		    driver.findElement(By.xpath("//button[contains(text(), 'Submit')]")).click();
		    driver.switchTo().alert().accept();
		    
	}

}
