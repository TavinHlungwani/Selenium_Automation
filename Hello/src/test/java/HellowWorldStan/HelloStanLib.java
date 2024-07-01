package HellowWorldStan;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HelloStanLib {

	public static void main(String[] args) {
		//1. Setting location of webdriver
		System.setProperty("webdriver.chrome.driver", "webdriver/chromedriver.exe");
		
		//2. Setup up webdriver
		WebDriver chromeDriver = new ChromeDriver();
		
		//3. File System
		Properties testDataProperties = new Properties();
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
		
		//4. Navigate to URL
		System.out.println("URL Received: " + testDataProperties.getProperty("test_url"));
		chromeDriver.get(testDataProperties.getProperty("test_url"));
		chromeDriver.manage().window().maximize();   //Maximise window?
		
		//5. Inspections
		WebElement loginUsernameElementm = chromeDriver.findElement(By.id("login-username"));
		WebElement loginPasswordElement = chromeDriver.findElement(By.cssSelector("#login-password"));
		WebElement loginPasswordVisibilityElement = chromeDriver.findElement(By.xpath("//img[@id='hide-show-password']"));
		WebElement loginButtonElement = chromeDriver.findElement(By.id("login-submit"));
		
		//6. Save data into variables
		String strUsernameString = testDataProperties.getProperty("test_username");
		String strPasswordString = testDataProperties.getProperty("test_password");
		
		//7. Send to form
		loginUsernameElementm.sendKeys(strUsernameString);
		loginPasswordElement.sendKeys(strPasswordString);
		
		//8. Hold on to see what the form shows
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//9. Actions and Clicks
		loginPasswordVisibilityElement.click();
		loginButtonElement.click();
		
		//10. Quit and Close browser
		chromeDriver.quit();
	}

}
