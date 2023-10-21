package trainer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
/**
 * Basic Selenium Framework with File.Properties as Test Data
 * @author Tavin Hlungwani
 *
 */
public class LoginChromeWebDriver {

	public static void main(String[] args) {
		//Set driver and specify location
		System.setProperty("webdriver.chrome.driver", "webdrivers/chromedriver.exe");
		
		//Declare webdriver
		WebDriver chromeDriver = new ChromeDriver();
		
		//File management
		Properties testData = new Properties();
		try {
			FileInputStream input = new FileInputStream("data/testdata.properties");
			testData.load(input);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Did we get the url from file.properties?
		System.out.println("Taking you to: " + testData.getProperty("test_url"));
		chromeDriver.get(testData.getProperty("test_url"));   //navigate to the url
		
		//Inspections
		WebElement usernameInput = chromeDriver.findElement(By.id("username"));
		WebElement passwordeInput = chromeDriver.findElement(By.id("password"));
		WebElement loginButton = chromeDriver.findElement(By.id("login"));
		
		//Storing the file.properties data to local variables
		String username = testData.getProperty("test_username");
		String password = testData.getProperty("test_password");
		
		//Did we really get the data from file.propeties?
		System.out.println("Username: " + username + "\nPassword: " + password);
		
		//Send the data to the form
		usernameInput.sendKeys(username);
		passwordeInput.sendKeys(password);
		
		//Hold it so we see what is happening
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			System.out.println("Ooopsie: " + e.getMessage().toString());
			e.printStackTrace();
		}
		
		//Action/execute....
		loginButton.click();
		
		System.out.println("Did you see the magic('_')?");
		
		//Close browser and quit session
		chromeDriver.quit();

	}

}
