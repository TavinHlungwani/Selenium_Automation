import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class stanlibLogin {

	public static void main(String[] args) {
		//1. Set up driver and specify location
		System.setProperty("webdriver.chrome.driver", "webdriver/chromedriver.exe");
		
		//2. Declare webdriver
		WebDriver chromeDriver = new ChromeDriver();
		
		//3. File Management
		Properties testData = new Properties();
		try {
			FileInputStream inputStream = new FileInputStream("data/testdata.properties");
			testData.load(inputStream);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//4. Load URL from properties file
		System.out.println("URL: " + testData.getProperty("test_url"));
		chromeDriver.get(testData.getProperty("test_url"));
		
		//5. Inspections
		WebElement loginInputElement = chromeDriver.findElement(By.id("username"));
		WebElement loginPasswordElement = chromeDriver.findElement(By.xpath("//input[@id='password']"));
		WebElement loginButtonElement = chromeDriver.findElement(By.cssSelector("#login"));
		
		//6. Store properties data into variables
		String usernameString = testData.getProperty("test_username");
		String passString = testData.getProperty("test_password");
		
		//7. Send data to form
		loginInputElement.sendKeys(usernameString);
		loginPasswordElement.sendKeys(passString);
		
		//8. Hold to see what is happening
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//9. Action
		loginButtonElement.click();
		
		//10. Close browser and quit
		chromeDriver.quit();
		
	}

}
