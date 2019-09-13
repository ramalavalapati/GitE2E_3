package utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {

	{
		System.setProperty("atu.reporter.config", "atu.properties");
	}
	
	protected WebDriver driver;
	
	public void setup (String Browser, String version, String os_version) {
		DataHandling envData = new DataHandling();
		
		driver.get(envData.getProperty("url"));
		
		driver.manage().window();
		
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		
		
		 {
		if (Browser.equalsIgnoreCase("chrome"))	{
			System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if (Browser.equalsIgnoreCase("ff")) {
			System.setProperty("webdriver.chrome.driver", "resources/geckodriver.exe");
			driver = new FirefoxDriver();
			
		}
		
		}
	}

}
