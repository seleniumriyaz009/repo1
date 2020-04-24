package regression;

import java.io.FileInputStream;
import java.io.FileOutputStream;
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
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ValidateRegistration3 {

	WebDriver driver;
	@BeforeMethod
	public void setUp()
	{
		driver=new ChromeDriver();
		
		//driver.get("http://newtours.demoaut.com/");
		
		driver.get("http://demo.guru99.com/test/newtours/");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.linkText("REGISTER")).click();
		
	}
	
	@Test(dataProvider="getData")
	public void validateRegistrationTest(String fn,String ln,String ph,String email,String add1,String city,String state,String pc,String country,String un,String pass,String cpass) throws IOException
	{
		
		
		
	
			
			driver.findElement(By.xpath("//input[@name='firstName']")).clear();
			driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(fn);
			driver.findElement(By.xpath("//input[@name='lastName']")).clear();
			driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys(ln);
			driver.findElement(By.xpath("//input[@name='phone']")).clear();
			driver.findElement(By.xpath("//input[@name='phone']")).sendKeys(ph);
			driver.findElement(By.xpath("//input[@name='userName']")).clear();
			driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(email);
			driver.findElement(By.xpath("//input[@name='address1']")).clear();
			driver.findElement(By.xpath("//input[@name='address1']")).sendKeys(add1);
			driver.findElement(By.xpath("//input[@name='city']")).clear();
			driver.findElement(By.xpath("//input[@name='city']")).sendKeys(city);
			driver.findElement(By.xpath("//input[@name='state']")).clear();
			driver.findElement(By.xpath("//input[@name='state']")).sendKeys(state);
			driver.findElement(By.xpath("//input[@name='postalCode']")).clear();
			driver.findElement(By.xpath("//input[@name='postalCode']")).sendKeys(pc);
			driver.findElement(By.xpath("//select[@name='country']")).sendKeys(country);
			driver.findElement(By.xpath("//input[@name='email']")).clear();
			driver.findElement(By.xpath("//input[@name='email']")).sendKeys(un);
			driver.findElement(By.xpath("//input[@name='password']")).clear();
			driver.findElement(By.xpath("//input[@name='password']")).sendKeys(pass);
			driver.findElement(By.xpath("//input[@name='confirmPassword']")).clear();
			driver.findElement(By.xpath("//input[@name='confirmPassword']")).sendKeys(cpass);
			
			driver.findElement(By.xpath("//input[@name='submit']")).click();
			
			String expText=un;
			
			String actText=driver.findElement(By.xpath("(//font/b)[2]")).getText();
			
			boolean b=false;
			
			if(actText.contains(expText))
			{
				
				b=true;
			}
			else
			{
				b=false;
			}
			
			
			Assert.assertTrue(b);
			
		}
		
		
		
		
		

	
	@DataProvider
	public Object[][] getData() throws IOException
	{
		FileInputStream f=new FileInputStream("E:\\COURSES\\7AM - 8AM Batch\\DataDrivenFramework\\src\\test\\resources\\testdata\\excelfiles\\registration.xlsx");
		
		XSSFWorkbook wb=new XSSFWorkbook(f);
		
		XSSFSheet ws=wb.getSheet("Sheet1");
		
		System.out.println(ws.getLastRowNum());
		
		Object[][] obj=new Object[ws.getLastRowNum()][12];
		
		for(int i=0;i<= ws.getLastRowNum()-1;i++)
		{
			obj[i][0]=ws.getRow(i+1).getCell(0).getStringCellValue();
			obj[i][1]=ws.getRow(i+1).getCell(1).getStringCellValue();
			obj[i][2]=ws.getRow(i+1).getCell(2).getStringCellValue();
			obj[i][3]=ws.getRow(i+1).getCell(3).getStringCellValue();
			obj[i][4]=ws.getRow(i+1).getCell(4).getStringCellValue();
			obj[i][5]=ws.getRow(i+1).getCell(5).getStringCellValue();
			obj[i][6]=ws.getRow(i+1).getCell(6).getStringCellValue();
			obj[i][7]=ws.getRow(i+1).getCell(7).getStringCellValue();
			obj[i][8]=ws.getRow(i+1).getCell(8).getStringCellValue();
			obj[i][9]=ws.getRow(i+1).getCell(9).getStringCellValue();
			obj[i][10]=ws.getRow(i+1).getCell(10).getStringCellValue();
			obj[i][11]=ws.getRow(i+1).getCell(11).getStringCellValue();
			
			
			
		}
		
		return obj;
	}
	
}
