package regression;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ValidateLogin {
	
	WebDriver driver;
	
	@Test(dataProvider="getData")
	public void validateLoginTest(String u,String p)
	{
		
		driver=new ChromeDriver();
		
		driver.get("http://demo.guru99.com/test/newtours/index.php");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(u);
		
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(p);
		
		driver.findElement(By.xpath("//input[@name='submit']")).click();
		
		String expData="Login Successfully";
		
		String actData=driver.findElement(By.xpath("//tbody/tr/td/h3")).getText();
		
		Assert.assertEquals(expData, actData);
			
		
		
	}
	
	
	
	@DataProvider
	public Object[][] getData()
	{
		
		Object[][]  obj=new Object[3][2];
		
		obj[0][0]="qshore";
		obj[0][1]="qshore123";
		
		obj[1][0]="reyaz";
		obj[1][1]="reyaaz123";
		
		obj[2][0]="qshore";
		obj[2][1]="abcd123";
		
		return obj;
		
		
	}
	

}
