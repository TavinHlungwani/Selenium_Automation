package trainer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest {
	WebDriver chromeDriver;
	Properties testDataProperties;
	//PageObject pageObject;
	
	@BeforeTest(description = "Setting up")
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		chromeDriver = new ChromeDriver();
		chromeDriver.manage().window().maximize();
		testDataProperties = new Properties();
		//property = new Property();
		//pageObject = new PageObject();
		//chromeDriver.get(property.getProperty("test_url"));
		try {
			FileInputStream inputStream = new FileInputStream("data/testdata.properties");
			testDataProperties.load(inputStream);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		chromeDriver.get(testDataProperties.getProperty("test_url"));
		
	}
	
	@Test(priority = 1, description = "Login")
	public void login() {
		
	}
	
	@Test(priority = 2, description = "Logout")
	public void logout() {
		
	}
	
	@AfterTest(description = "Cleaning up")
	public void cleanUp() {
		chromeDriver.close();
		chromeDriver.quit();
	}
}
