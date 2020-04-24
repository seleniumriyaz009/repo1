package regression;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GmailUsingProperties {
	
	WebDriver driver;
	@BeforeMethod
	public void setUp()
	{
		driver=new ChromeDriver();
		
		//driver.get("http://newtours.demoaut.com/");
		
		driver.get("http://gmail.com");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		
	}
	
	@Test
	public void gmailUsingPropertiesTest() throws IOException
	{
		FileInputStream f=new FileInputStream("GmailProperties.properties");
		
		Properties pr=new Properties();
		
		pr.load(f);
		
		driver.findElement(By.xpath(pr.getProperty("txt_email"))).sendKeys("selenium.riyaz009");
		
		driver.findElement(By.xpath(pr.getProperty("btn_next"))).click();
		
		driver.findElement(By.xpath(pr.getProperty("txt_password"))).sendKeys("abcde1234");
		
		driver.findElement(By.xpath(pr.getProperty("btn_passnext"))).click();
		
	}
}
