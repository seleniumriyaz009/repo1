package regression;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ValidateRegistration2 {

	WebDriver driver;
	@BeforeMethod
	public void setUp()
	{
		driver=new ChromeDriver();
		
		//driver.get("http://newtours.demoaut.com/");
		
		driver.get("http://demo.guru99.com/test/newtours/index.php");
		
				
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.linkText("REGISTER")).click();
		
	}
	@Test
	public void validateRegistrationTest() throws IOException
	{
		
		FileInputStream f=new FileInputStream("E:\\COURSES\\7AM - 8AM Batch\\DataDrivenFramework\\src\\test\\resources\\testdata\\excelfiles\\registration.xlsx");
		
		XSSFWorkbook wb=new XSSFWorkbook(f);
		
		XSSFSheet ws=wb.getSheet("Sheet1");
		
		Iterator<Row> rows=ws.iterator();
		
		Row r=null;
		
		Cell c=null;
		
		rows.next();
		
		while(rows.hasNext())
		{
			
			r=rows.next();
			
			driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(r.getCell(0).getStringCellValue());
			driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys(r.getCell(1).getStringCellValue());
			driver.findElement(By.xpath("//input[@name='phone']")).sendKeys(r.getCell(2).getStringCellValue());
			driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(r.getCell(3).getStringCellValue());
			driver.findElement(By.xpath("//input[@name='address1']")).sendKeys(r.getCell(4).getStringCellValue());
			driver.findElement(By.xpath("//input[@name='city']")).sendKeys(r.getCell(5).getStringCellValue());
			driver.findElement(By.xpath("//input[@name='state']")).sendKeys(r.getCell(6).getStringCellValue());
			driver.findElement(By.xpath("//input[@name='postalCode']")).sendKeys(r.getCell(7).getStringCellValue());
			driver.findElement(By.xpath("//select[@name='country']")).sendKeys(r.getCell(8).getStringCellValue());
			driver.findElement(By.xpath("//input[@name='email']")).sendKeys(r.getCell(9).getStringCellValue());
			driver.findElement(By.xpath("//input[@name='password']")).sendKeys(r.getCell(10).getStringCellValue());
			driver.findElement(By.xpath("//input[@name='confirmPassword']")).sendKeys(r.getCell(11).getStringCellValue());
			
			driver.findElement(By.xpath("//input[@name='submit']")).click();
			
			driver.navigate().back();
			
			
			
			
		}
		
		
		
		
		
	}
	
}
