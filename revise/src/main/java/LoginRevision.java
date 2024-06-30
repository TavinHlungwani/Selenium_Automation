import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
/**
 * Basic Selenium Login Automation with TestNG and ChromeDriver
 * @author Tavin Hlungwani
 *
 */
public class LoginRevision {

	public static void main(String[] args) {
		//1. Set web driver
		System.setProperty("webdriver.chrome.driver", "webdrivers/chromedriver.exe");

		//2. initialise web driver
		WebDriver driver = (WebDriver) new ChromeDriver();
		
		//3. File properties
		Properties testData = new Properties();
		try {
			FileInputStream input = new FileInputStream("data/testdata.properties");
			testData.load(input);
			System.out.println("Did we get the url?: " + testData.getProperty("test_url"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//4. Get website and go to it, more like lunch browser and navigate to website
		String url = testData.getProperty("test_url");
		driver.get(url);
		
		//5. Inspections bluh bluh bluh
		WebElement txtUsername = driver.findElement(By.id("username"));
		WebElement txtPassword = driver.findElement(By.id("password"));
		WebElement btnLogin = driver.findElement(By.id("login"));
		
		//6. Get data from the file and send keys
		String username = testData.getProperty("test_username");
		String password = testData.getProperty("test_password");
		
		//did we get the data from the properties file??
		System.out.println("Url: " + url +"\nUsername: " + username + "\nPassword: " + password);
		
		//7. Send keys to form now
		txtUsername.sendKeys(username);
		txtPassword.sendKeys(password);
		
		//optional hold to see it happening
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//8. Action, Execute, Click, whatever you wanna call this
		btnLogin.click();
		
		
		//9. Terminate
		driver.quit();
		
	}

}
