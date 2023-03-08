package TESTNGpractice;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinksPractice {
	
	@Test
	public void test()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.get("https://demowebshop.tricentis.com/");
		List<WebElement> linkList = driver.findElements(By.xpath("//a"));
		List<String> listUrl= new ArrayList<>();
		List<String> brokenUrl= new ArrayList<>();
		for(WebElement linkEle:linkList)
		{
			String url= linkEle.getAttribute("href");
			listUrl.add(url);
		}
		for(String u: listUrl)
		{
			try {
				URL url= new URL(u);
				URLConnection urlConn= url.openConnection();
				HttpURLConnection httpUrlConnection= (HttpURLConnection) urlConn;
				int statusCode= httpUrlConnection.getResponseCode();
				String statusMessage= httpUrlConnection.getResponseMessage();
				if(statusCode!=200)
				{
					brokenUrl.add(u + statusMessage);
				}
					
			}catch (Exception e) {
				brokenUrl.add(u + "==> No message");
				
			}
		}
	
	}
}
