package regression;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DBTesting2 {
	
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
	
	//public void validateRegistrationTest(String fn,String ln,String ph,String email,String add1,String city,String state,String pc,String country,String un,String pass,String cpass) throws IOException
	//public void validateRegistrationTest(ResultSet rs) throws SQLException
	
	@Test(dataProvider= "getData")
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
		
		
		/*driver.findElement(By.xpath("//input[@name='firstName']")).clear();
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(rs.getString(1));
		driver.findElement(By.xpath("//input[@name='lastName']")).clear();
		driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys(rs.getString(2));
		driver.findElement(By.xpath("//input[@name='phone']")).clear();
		driver.findElement(By.xpath("//input[@name='phone']")).sendKeys(rs.getString(3));
		driver.findElement(By.xpath("//input[@name='userName']")).clear();
		driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(rs.getString(4));
		driver.findElement(By.xpath("//input[@name='address1']")).clear();
		driver.findElement(By.xpath("//input[@name='address1']")).sendKeys(rs.getString(5));
		driver.findElement(By.xpath("//input[@name='city']")).clear();
		driver.findElement(By.xpath("//input[@name='city']")).sendKeys(rs.getString(6));
		driver.findElement(By.xpath("//input[@name='state']")).clear();
		driver.findElement(By.xpath("//input[@name='state']")).sendKeys(rs.getString(7));
		driver.findElement(By.xpath("//input[@name='postalCode']")).clear();
		driver.findElement(By.xpath("//input[@name='postalCode']")).sendKeys(rs.getString(8));
		driver.findElement(By.xpath("//select[@name='country']")).sendKeys(rs.getString(9));
		driver.findElement(By.xpath("//input[@name='email']")).clear();
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(rs.getString(10));
		driver.findElement(By.xpath("//input[@name='password']")).clear();
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(rs.getString(11));
		driver.findElement(By.xpath("//input[@name='confirmPassword']")).clear();
		driver.findElement(By.xpath("//input[@name='confirmPassword']")).sendKeys(rs.getString(12));*/
			
			driver.findElement(By.xpath("//input[@name='submit']")).click();
			
			//String expText=rs.getString(10);
			
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
		
	
	@SuppressWarnings("null")
	@DataProvider
	public Object[][] getData() throws SQLException
	{
		String dbName="reyazdb";
		String username="root";
		String password="reyaz123";
		String url="jdbc:mysql://localhost:3306/";
		
		Connection conn=DriverManager.getConnection(url+dbName, username, password);
		
		PreparedStatement psmt=conn.prepareStatement("select * from register");
		
		ResultSet rs=psmt.executeQuery();
		
		//Object[][] obj=new Object[2][12];
		
		Object[][] obj=null;
		
		/*int j=0;
		for(int i=0;j<2;j++)
		{
			System.out.println(rs.next());
			//obj[i][j]=rs.next();
			
			
		}*/
		
		obj=new Object[2][12];
		int j=0;
		
		System.out.println(rs);
		for(int i=0;i<2;i++)
		{
			rs.next();
			
			obj[i][0]=rs.getString("Firstname");
			obj[i][1]=rs.getString("Lastname");
			obj[i][2]=rs.getString("Phone");
			obj[i][3]=rs.getString("Email");
			obj[i][4]=rs.getString("Address1");
			obj[i][5]=rs.getString("City");
			obj[i][6]=rs.getString("State");
			obj[i][7]=rs.getString("Postalcode");
			obj[i][8]=rs.getString("Country");
			obj[i][9]=rs.getString("Username");
			obj[i][10]=rs.getString("Password");
			obj[i][11]=rs.getString("Confirmpassword");
			
			
		}
			
			
			
		
		
		
		return obj;
		
	}

}
