package regression;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class GmailLoginGrid {
	
	public static final String USERNAME = "seleniumriyaz009";

	  public static final String ACCESS_KEY = "2af7772a-61aa-4adf-8226-62e2bf68e02f";

	  public static final String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";
	
	@Test
	public void gmailLoginGridTest() throws MalformedURLException
	{
		/*DesiredCapabilities caps=new DesiredCapabilities();
		
		caps.setBrowserName("chrome");
		caps.setPlatform(Platform.WINDOWS);*/
		
		MutableCapabilities sauceOptions = new MutableCapabilities();

		InternetExplorerOptions browserOptions = new InternetExplorerOptions();
		browserOptions.setCapability("platformName", "Windows 10");
		browserOptions.setCapability("browserVersion", "11.285");
		browserOptions.setCapability("sauce:options", sauceOptions);
		
		RemoteWebDriver driver=new RemoteWebDriver(new URL(URL), browserOptions);
		
		driver.get("http://www.imgur.com");
		
		System.out.println(driver.getTitle());
		
		driver.close();
		
		driver.quit();
		
		
	}

}
