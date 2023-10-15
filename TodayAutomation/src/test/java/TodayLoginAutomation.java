import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TodayLoginAutomation {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:/automation/chromedriver.exe");
		
		WebDriver chromeDriver = new ChromeDriver();
		
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
		
		chromeDriver.get(testData.getProperty("test_url"));
		
		WebElement usernameTextField = chromeDriver.findElement(By.id("username"));
		WebElement passwordTextField = chromeDriver.findElement(By.id("password"));
		WebElement loginButton = chromeDriver.findElement(By.id("login"));
		
		usernameTextField.sendKeys(testData.getProperty("test_username"));
		passwordTextField.sendKeys(testData.getProperty("test_password"));
		
		loginButton.click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		chromeDriver.close();
		
		chromeDriver.quit();

	}

}
