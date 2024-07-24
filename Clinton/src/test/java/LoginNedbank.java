import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginNedbank {

	public static void main(String[] args) {
		// 1. Set up driver and specify location
		System.setProperty("webdriver.chrome.driver", "chromedriver/chromedriver.exe");

		// 2. Declare webdriver
		WebDriver chromeDriver = new ChromeDriver();

		// 3. File management (properties file or extent handler or anything that works
		// to avoid hard coding)
		Properties testData = new Properties();
		try {
			FileInputStream inputStream = new FileInputStream("testdata/data.properties");
			testData.load(inputStream);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 4. Load URL from properties file (extent handler)
		System.out.println("Did we receive URL from testdata variable: " + testData.getProperty("test_url"));
		System.out.println("test Username: " + testData.getProperty("test_username"));
		System.out.println("test Password: " + testData.getProperty("test_password"));
		chromeDriver.get(testData.getProperty("test_url"));
		chromeDriver.manage().window().maximize();  //Maximise browser

		// 5. Inspections
		WebElement loginUsernameElement = chromeDriver.findElement(By.id("username"));
		WebElement loginPasswordElement = chromeDriver.findElement(By.xpath("//input[@id='password']"));
		WebElement loginButtonElement = chromeDriver.findElement(By.xpath("//button[@id='login']"));

		// 6. Store file data into variables
		String strUsername = testData.getProperty("test_username");
		String strPassword = testData.getProperty("test_password");

		// 7. Send data to form
		loginUsernameElement.sendKeys(strUsername);
		loginPasswordElement.sendKeys(strPassword);

		// 7.1. Hold to see what happens - to be removed...
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 8. Do actions, i.e. clicks
		loginButtonElement.click();
		// Hold to see what happens - to be removed...
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// 9. Closer browser and do clean up
		// chromeDriver.close();
		chromeDriver.quit();
		System.out.println("Quiting browser and ending session compledted.....");
	}

}
