import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class finalTonightAutomation {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:/automation/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		Properties testData = new Properties();
		try {
			FileInputStream input = new FileInputStream("data/testdata.properties");
			testData.load(input);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		driver.get(testData.getProperty("test_url"));
		
		WebElement usernameInput = driver.findElement(By.id("username"));
		WebElement passwordInput = driver.findElement(By.id("password"));
		WebElement loginButton = driver.findElement(By.id("login"));
		
		usernameInput.sendKeys(testData.getProperty("test_username"));
		System.out.println(testData.getProperty("test_username") + testData.getProperty("test_password"));
		passwordInput.sendKeys(testData.getProperty("test_password"));
		
		loginButton.click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.quit();

	}

}
