package baseTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.PageObject;

public class BaseTest {

	WebDriver webDriver;
	
	protected PageObject pageObject;
	
	@BeforeTest
	public void setup() {
		
		WebDriverManager.chromedriver().setup();
		webDriver = new ChromeDriver();
		webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		webDriver.manage().window().maximize();
		webDriver.get("url"); //properties file needed here
		
		//Innitiate Page Object
		pageObject = new PageObject(webDriver);
	}
	
	
	
	
	
	@AfterTest
	public void teardown() {
		webDriver.close();
	}
	
}
