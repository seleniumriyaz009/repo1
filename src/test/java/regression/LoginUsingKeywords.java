package regression;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import keyword.LoginKeywords;

public class LoginUsingKeywords {
	
	
	WebDriver driver;
	
	
	@Test
	public void gmailUsingPropertiesTest() throws IOException
	{
		FileInputStream f=new FileInputStream("GmailProperties.properties");
		
		Properties pr=new Properties();
		
		pr.load(f);
		
		FileInputStream f1=new FileInputStream("src\\test\\resources\\testdata\\excelfiles\\LoginKeywords.xlsx");
		
		XSSFWorkbook wb=new XSSFWorkbook(f1);
		
		XSSFSheet ws=wb.getSheet("Sheet1");
		
		Iterator<Row> rows=ws.iterator();
		
		rows.next();
		
		LoginKeywords keys=new LoginKeywords();
		
		while(rows.hasNext())
		{
			
			String action=rows.next().getCell(3).getStringCellValue();
			
			if(action.equals("launchBrowser"))
			{
				keys.launchBrowser();
				
			}
			else if(action.equals("navigate"))
			{
				keys.navigate();
			}
			else if(action.equals("enterUsername"))
			{
				keys.enterUsername(pr.getProperty("txt_email"));
				
			}
			else if(action.equals("clickNext"))
			{
				keys.clickNext(pr.getProperty("btn_next"));
				
			}
			else if(action.equals("enterPassword"))
			{
				keys.enterPassword(pr.getProperty("txt_password"));
				
			}
			else if(action.equals("clickLogin"))
			{
				keys.clickLogin(pr.getProperty("btn_passnext"));
				
			}
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
