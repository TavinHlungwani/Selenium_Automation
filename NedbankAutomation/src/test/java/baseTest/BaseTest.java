package baseTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObject.PageObject;

public class BaseTest {
	
	WebDriver webDriver;
	
	PageObject pageOject;

	@BeforeTest
	public void setup() {
		System.out.println("Started....");
		WebDriverManager.chromedriver().setup();
		System.out.println("Started....");
		webDriver = new ChromeDriver();
		webDriver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		webDriver.manage().window().maximize();
		webDriver.get("www.eqaroloflow.co.za/wp/");
		
		pageOject = new PageObject(webDriver);
	}
	
	
	@AfterTest
	public void tearDown() {
		webDriver.close();
	}
}
