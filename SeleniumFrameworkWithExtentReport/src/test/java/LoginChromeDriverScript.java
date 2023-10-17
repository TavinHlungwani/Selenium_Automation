import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
/**
 * Basic Selenium Login Automation with TestNG and ChromeDriver
 * @author Tavin Hlungwani
 *
 */
public class LoginChromeDriverScript {
	
	private static Utilities utilities;
	
	public static void main(String[] args) {
		// 1. Setup driver location
		System.setProperty("webdriver.chrome.driver", "Webdriver/chromedriver.exe");

		// 2. Declare webdriver/Chromedriver
		WebDriver chromeDriver = new ChromeDriver();

		// 3. Setup file
		Properties testData = new Properties();
		try {
			FileInputStream inputStream = new FileInputStream("Data/login.properties");
			testData.load(inputStream);   // load the data into the properties var from the file
		} catch (FileNotFoundException e) {
			System.out.println("Ooops: " + e.getMessage().toString());
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Ooops: " + e.getMessage().toString());
			e.printStackTrace();
		}

		// 3.1. Get all file data into local variables
		String url = testData.getProperty("test_url");
		String username = testData.getProperty("test_username");
		String password = testData.getProperty("test_password");
		
		System.out.println("Url: " + url + "\nUsername: " + username + "\nPassword: " + password);  //let's see the data from the file?

		// 4. Load the url
		chromeDriver.get(url);
		
		// 5. Inspect the web page elements
		WebElement usernameInputText = chromeDriver.findElement(By.id("username"));
		WebElement passwordInputText = chromeDriver.findElement(By.id("password"));
		WebElement loginButton = chromeDriver.findElement(By.id("login"));
		
		// 6. Actions(fill form, hold and click button)
		usernameInputText.sendKeys(username);
		passwordInputText.sendKeys(password);
		
		utilities = new Utilities();    //get some help from external class
		utilities.waitSomeTime(5000);
		
		loginButton.click();   //anddddddd, action!
		

		// Clean up/closing browser
		chromeDriver.quit();

	}

}
