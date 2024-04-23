import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Selenium Login Automation with extent report and ChromeDriver
 * @author Tavin Hlungwani
 * Chrome Driver Link: https://googlechromelabs.github.io/chrome-for-testing/
 *
 */
public class LoginChromeDriverScriptExtentReport {
	
	private static Utilities utilities;
	private static ExtentReport extentReport;
    
	public static void main(String... args) {
		//Setup driver location
		System.setProperty("webdriver.chrome.driver", "Webdriver/chromedriver.exe");

		//Instantiate Objects
		extentReport = new ExtentReport();
		utilities = new Utilities();
		
		//Declare webdriver/Chromedriver
		WebDriver chromeDriver = new ChromeDriver();

		//Setup Test Data file and read from it
		Properties testData = new Properties();
		try {
			FileInputStream inputStream = new FileInputStream("Data/login.properties");
			testData.load(inputStream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		//Get all file data into local variables
		String url = testData.getProperty("test_url");
		String username = testData.getProperty("test_username");
		String password = testData.getProperty("test_password");
		System.out.println("Url: " + url + "\nUsername: " + username + "\nPassword: " + password);

		//Instantiate the webdriver
		extentReport.testNameMethod("Launch Browser");
		chromeDriver.get(url);
		chromeDriver.manage().window().maximize();
		extentReport.passedTestMethod();
		
		//Inspect the web page
		extentReport.testNameMethod("Perform Inspections"); 
		WebElement usernameInputText = chromeDriver.findElement(By.id("username"));
		WebElement passwordInputText = chromeDriver.findElement(By.id("password"));
		WebElement loginButton = chromeDriver.findElement(By.id("login"));
		extentReport.passedTestMethod();
		
		//extentReport.captureScreenshot(chromeDriver);//
		
		//Actions(fill form, hold and click button)
		extentReport.testNameMethod("Perform Actions");
		usernameInputText.sendKeys(username);
		passwordInputText.sendKeys(password);
		utilities.waitSomeTime(5000);
		loginButton.click();
		extentReport.passedTestMethod();
		
		// Clean up
		extentReport.testNameMethod("Close Browser");
		chromeDriver.quit();
		extentReport.passedTestMethod();
		
		//Save Report
		extentReport.saveReport();
	}

}
