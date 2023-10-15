import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.*;
import java.io.*;

public class LoginAutomation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1. Set Chrome Driver Property
		System.setProperty("webdriver.chrome.driver", "C:/automation/chromedriver.exe");
		
		//2. Instantiate Web Driver
		WebDriver chromeDriver = new ChromeDriver();
		
		//3. Setup file properties
		Properties testData = new Properties();
		try {
			FileInputStream inputData = new FileInputStream("data/testdata.properties");
			testData.load(inputData);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage().toString());
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//4. Get the Url
		String url = testData.getProperty("test_url");
		chromeDriver.get(url);
		
		//5. Inspections
		WebElement usernameInput = chromeDriver.findElement(By.id("username"));
		WebElement passwordInput = chromeDriver.findElement(By.xpath("//input[@id='password']"));
		WebElement loginButton = chromeDriver.findElement(By.id("login"));
		
		//5.1. Get the data from file
		String username = testData.getProperty("test_username");
		String password = testData.getProperty("test_password");
		
		
		//6. Actions
		usernameInput.sendKeys(username);
		passwordInput.sendKeys(password);
		
		loginButton.click();
		
		//7. Hold it
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage().toString());
		}
		
		//8. Clean up
		chromeDriver.quit();

	}

}
