import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.GeckoDriverInfo;
/**
 * 
 * @author T540p
 *
 */
public class LoginGeckoDriverScript {

	public static void main(String[] args) {
		// 1. Setup driver location
		System.setProperty("webdriver.chrome.driver", "C:/automation/web_drivers/geckodriver.exe"); //using the geckodriver gives some error I am lazy to fix

		// 2. Initialise webdriver/Firefox driver and firefox options
		FirefoxOptions options = new FirefoxOptions();
		//options.setBinary("C:/automation/web_drivers/FirefoxSetup.exe");
		WebDriver geckoDriver = new FirefoxDriver(options);

		// 3. Setup file
		Properties testData = new Properties();
		try {
			FileInputStream inputStream = new FileInputStream("Data/login.properties");
			testData.load(inputStream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 3.1. Get all file data into local variables
		String url = testData.getProperty("test_url");
		String username = testData.getProperty("test_username");
		String password = testData.getProperty("test_password");
		System.out.println("Url: " + url + "\nUsername: " + username + "\nPassword: " + password);

		// 4. Instantiate the webdriver
		geckoDriver.get(url);
		
		// 5. Inspect the web page
		WebElement usernameInputText = geckoDriver.findElement(By.id("username"));
		WebElement passwordInputText = geckoDriver.findElement(By.id("password"));
		WebElement loginButton = geckoDriver.findElement(By.id("login"));
		
		// 6. Actions(fill form and click button)
		usernameInputText.sendKeys(username);
		passwordInputText.sendKeys(password);
		waitSomeTime(5000);
		loginButton.click();
		

		// Clean up
		geckoDriver.quit();

	}
	
	/**
	 * Utility for holding execution
	 * @param seconds
	 */
	private static void waitSomeTime(long seconds) {
		try {
			Thread.sleep(seconds);
			System.out.println("I believe you saw the magic?('_')");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
