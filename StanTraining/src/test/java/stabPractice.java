import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class stabPractice {

	public static void main(String[] args) {
		//1. Set location of driver
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
		
		//4. Load URL from file properties
		System.out.println("URL Latest: " + testData.getProperty("test_url"));
		chromeDriver.get(testData.getProperty("test_url"));
		
		//5. Inspections
		WebElement loginInputUsername = chromeDriver.findElement(By.id("username"));
		WebElement loginInputPassword = chromeDriver.findElement(By.cssSelector("#password"));
		WebElement loginButttonElement = chromeDriver.findElement(By.xpath("//input[@id='password']"));
		
		//6. Store properties into vars?
		String strUsernameString = testData.getProperty("test_username");
		String strPasswordString = testData.getProperty("test_password");
		
		//7. Send to form
		loginInputUsername.sendKeys(strUsernameString);
		loginInputPassword.sendKeys(strPasswordString);
		
		//8. Hold on a second to see what is happening
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//9. Action, yeah click some stuff
		loginButttonElement.click();
		
		//10. Close browser and quit
		chromeDriver.quit();
		

	}

}
