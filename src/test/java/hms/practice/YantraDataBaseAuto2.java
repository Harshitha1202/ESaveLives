package hms.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class YantraDataBaseAuto2 {

	public static void main(String[] args) throws SQLException {

		DriverManager.registerDriver(new Driver());
		Connection connection = null;

		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		//datas
		String url="http://rmgtestingserver:8084/";
		String userName = "rmgyantra";
		String password = "rmgy@9999";
		String prjManagerName = "Job";
		String projecId = "TY_PROJ_"+new Random().nextInt(100);
		String query = "insert into project values('"+projecId+"','"+prjManagerName+"','07/02/2023', 'selenium', 'Created', '3');";

		try {
			connection=DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");
			Statement statement = connection.createStatement();
			//			ResultSet result = statement.executeQuery("select * from project;");
			//			int size= result.getMetaData().getColumnCount();
			//			for(int i=1; i<=size; i++) {
			//				System.out.println(result.getMetaData().getColumnName(i));
			//			}
			statement.executeUpdate(query);
		}
		finally {
			connection.close();
			System.out.println("Connection closed");
		}
		
		driver.get(url);
		driver.findElement(By.id("usernmae")).sendKeys(userName);
		driver.findElement(By.id("inputPassword")).sendKeys(password);
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		String actWelcomePage=driver.findElement(By.xpath("//h2[text()='Welcome To Project Management System']")).getText();

		if(actWelcomePage.contains("Welcome To Project Management System")) {
			System.out.println("User signed in successfully");
		}else {
			System.out.println("User not signed in successfully");
		}

		driver.findElement(By.xpath("//a[text()='Projects']")).click();
		String projectPage = driver.getCurrentUrl();

		if(projectPage.contains("projects")) {
			System.out.println("Project page displayed successfully");
		}else {
			System.out.println("Project page not displayed successfully");
		}

		WebElement projectManagerName = driver.findElement(By.xpath("//th[text()='Project Manager']/ancestor::table//tbody/child::tr/td[text()='"+prjManagerName+"']"));

		if(prjManagerName.equals(projectManagerName.getText())) {
			System.out.println("Data inserted successfully and TC pass");
		}else {
			System.out.println("Data not inserted successfully and TC fail");
		}
		driver.close();
	}
}
