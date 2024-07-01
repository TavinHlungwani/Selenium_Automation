package HellowStanlibLoginForm;

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
		// TODO Auto-generated method stub
		//1. Setting location of webdriver
		System.setProperty("webdriver.chrome.driver", "webdriver/chromedriver.exe");
		
		//2. innitiate Webdriver
		WebDriver chromeDriver = new ChromeDriver();
		
		//3. File Management
		Properties testDataProperties = new Properties();
		try {
			FileInputStream inputStream = new FileInputStream("testdata/testdata.properties");
			testDataProperties.load(inputStream);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//4. Get the Url and load it up
		System.out.println("URL from Properties: " + testDataProperties.getProperty("test_url"));
		chromeDriver.get(testDataProperties.getProperty("test_url"));
		chromeDriver.manage().window().maximize(); //maximise the window
		
		//5. Inspections
		WebElement loginUsernamElement = chromeDriver.findElement(By.id("login-username"));
		WebElement loginPasswordElement	= chromeDriver.findElement(By.cssSelector("#login-password"));
		WebElement loginPasswordVisibilityIconElement = chromeDriver.findElement(By.id("hide-show-password"));
		WebElement loginButtonlElement	= chromeDriver.findElement(By.xpath("//button[@id='login-submit']"));
		
		//6. Store data into variables
		String usernameString = testDataProperties.getProperty("test_username");
		String passwordString = testDataProperties.getProperty("test_password");
		
		//7. Send creds to form
		loginUsernamElement.sendKeys(usernameString);
		loginPasswordElement.sendKeys(passwordString);
		
		//8. hold for a second to see what is happening, bad practise, to be ommited
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//9. Actions, clicking stuff
		loginPasswordVisibilityIconElement.click();
		loginButtonlElement.click();
		
		System.out.println("Saw the magic?");
		
		//10. Done, Close and Quit
		chromeDriver.quit();

	}

}
