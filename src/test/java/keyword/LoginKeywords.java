package keyword;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginKeywords {
	
	WebDriver driver;
	
	public void launchBrowser()
	{
		driver=new ChromeDriver();
		
		
	}
	
	
	public void navigate()
	{
		
		driver.get("http://gmail.com");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		
	}
	
	public void enterUsername(String locator)
	{
		
		driver.findElement(By.xpath(locator)).sendKeys("selenium.riyaz009");
		
	}
	
	public void clickNext(String locator)
	{
		
		driver.findElement(By.xpath(locator)).click();
	}
	
	
	public void enterPassword(String locator)
	{
		
		driver.findElement(By.xpath(locator)).sendKeys("abcd1234");
		
	}
	public void clickLogin(String loctaor)
	{
		
		driver.findElement(By.xpath(loctaor)).click();
	}
	
	

}
