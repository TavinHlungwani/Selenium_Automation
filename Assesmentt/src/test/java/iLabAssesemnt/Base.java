package iLabAssesemnt;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Base {
	private LoginPage loginPage;
	private Properties testDataProperties;
	private WebDriver chromeDriver;

	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		chromeDriver = new ChromeDriver();
		testDataProperties = new Properties();
		chromeDriver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		chromeDriver.manage().window().maximize();
		loginPage = new LoginPage(chromeDriver);
	}

	@Test
	public void loginStep() {
		try {
			FileInputStream inputStream = new FileInputStream("data/data.properties");
			testDataProperties.load(inputStream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(testDataProperties.getProperty("login_url"));
		chromeDriver.get(testDataProperties.getProperty("login_url"));
		
	}

	@Test
	public void logout() {

	}

	@AfterClass
	public void cleanUp() {
		if (chromeDriver != null) {
			chromeDriver.quit();
		}
	}

}
