import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginBasics {

	public static void main(String... args) {
		
		System.setProperty("webdriver.chrome.driver", "webdriver/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		Properties testData = new Properties();
		try {
			FileInputStream input = new FileInputStream("data/login.properties");
			testData.load(input);
		} catch (FileNotFoundException e) {
			System.out.println("Ooops: " + e.getMessage().toString());
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Ooops: " + e.getMessage().toString());
			e.printStackTrace();
		}
	
		System.out.println(testData.getProperty("url"));
		//load the url
		driver.get(testData.getProperty("url"));
		
		WebElement usernameInput = driver.findElement(By.id("username"));
		WebElement passwordInput = driver.findElement(By.id("password"));
		WebElement loginButton = driver.findElement(By.id("login"));
		
		//
		usernameInput.sendKeys(testData.getProperty("username"));
		passwordInput.sendKeys(testData.getProperty("password"));
		System.out.println("Username: " + testData.getProperty("username") + "/nPassword: " + testData.getProperty("password"));  //show data fetched
		//Hold it
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			System.out.println("Ooops: " + e.getMessage().toString());
			e.printStackTrace();
		}
		
		loginButton.click(); //click login button
		
		//quit and close browser
		driver.quit();
		

	}

}
