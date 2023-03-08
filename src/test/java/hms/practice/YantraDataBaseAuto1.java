package hms.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class YantraDataBaseAuto1 {

		public static void main(String[] args) throws SQLException 
		{
			 String SignInPage= "Sign In";
			 String WelcomePage = "Welcome To Project Management System";
			 String url= "http://rmgtestingserver:8084/";
			 String UN= "rmgyantra";
			 String PW= "rmgy@9999";
			
			 WebDriverManager.chromedriver().setup();
			 WebDriver driver = new ChromeDriver();
			 driver.manage().window().maximize();
			 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			 driver.get(url);
			 String signIn = driver.findElement(By.xpath("//h5[text()= 'Sign In']")).getText();
			 if(signIn.equals(SignInPage))
			 {
				 System.out.println("sign in page displayed");
			 }
			 else
			 {
				 System.out.println("sign in page not displayed");
			 }
			 driver.findElement(By.id("usernmae")).sendKeys(UN);
			 driver.findElement(By.id("inputPassword")).sendKeys(PW);
			 driver.findElement(By.xpath("//button[text()='Sign in']")).click();
			 
			 WelcomePage=driver.findElement(By.xpath("//h2[text()= 'Welcome To Project Management System']")).getText();
			 if(WelcomePage.equals(WelcomePage))
			 {
				 System.out.println("welcome page displayed");
			 }
			 else
			 {
				 System.out.println("welcome page not displayed");
			 }
			 driver.findElement(By.xpath("//a[text()='Projects']")).click();
			 driver.findElement(By.xpath("//span[text()='Create Project']")).click();
			 //////SWITCHING WINDOW//////
			 Set<String> parentwindow = driver.getWindowHandles();
			 for (String projectcreatepage : parentwindow) 
			 {
				driver.switchTo().window(projectcreatepage);
			 }
			 
			 driver.findElement(By.name("projectName")).sendKeys("HMS_06 +new Random().nextInt(100);");
			 driver.findElement(By.name("createdBy")).sendKeys("Mohan");
			 WebElement ele = driver.findElement(By.xpath
					 ("//label[.= 'Project Status ']/following-sibling::select"));
			 Select s = new Select(ele);
			 s.selectByValue("On Going");
			 driver.findElement(By.xpath("//input[@class='btn btn-success']")).click();
			 
			 // STEP 1
			 Driver dbDriver= new Driver();
			 DriverManager.registerDriver(dbDriver);
			 Connection connection=null;
			 try {
			 // STEP 2-url:jdbc:mysql://localhost:3306/mydb, un, pw
			 connection = DriverManager.getConnection
						 ("jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");
			 // STEP 3
			 Statement statement = connection.createStatement();
			 ResultSet result = statement.executeQuery
					 ("select * from project where project_name='HMS_06';");
			 int size = result.getMetaData().getColumnCount();
			 for(int i = 1; i <=size; i++)
			 {
				System.out.println(result.getMetaData().getColumnName(i));
			 }
					 
			 // iterate data
			 while(result.next())
			 {
				String manager = result.getString("created_by");
				String projectName = result.getString("project_name");
				String projectID = result.getString("project_id");
				String status = result.getString("status");
				String createdOn = result.getString("created_on");
				String teamSize = result.getString("team_size");
				System.out.println
	            (manager+" "+projectName+" "+projectName+" "+status+" "+status+" "+createdOn+" "+teamSize);
						
			 }
		     }
					
			 finally 
			 {
				//step 6
				connection.close();
				System.out.println("closed connection");
						
			 }
				
		}
			 
}
