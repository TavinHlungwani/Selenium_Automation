import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class LoginAutomationmac {

	public static void main(String[] args) {
		//1. Set Chrome Driver Property
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
		
		//2. Instantiate Web Driver
		WebDriver chromeDriver = new ChromeDriver();
		System.out.println("Web Driver Chrome Driver Innitiated....");

		//3. Setup file properties
		Properties testData = new Properties();
		try {
			FileInputStream inputData = new FileInputStream("data/testdata.properties");
			testData.load(inputData);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//4. Get the Url
		String url = testData.getProperty("test_url");
		System.out.println("URL from properties file: " + url);
		chromeDriver.get(url);
		
		//5. Inspections
		WebElement usernameInput = chromeDriver.findElement(By.id("investecId"));
		WebElement passwordInput = chromeDriver.findElement(By.id("password"));
		WebElement loginButton = chromeDriver.findElement(By.xpath("//button[@class='btn btn-primary btn-block btn-default']"));
		System.out.println("Inspections Completed....");

		//6. Actions
		usernameInput.sendKeys(testData.getProperty("test_username"));
		passwordInput.sendKeys(testData.getProperty("test_password"));
		loginButton.click();
		
		//7. Hold it, remove once done with check
		/*try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}*/
		// or do it Explicitely for 10 seconds timeout, so called Explicit Wait, wait until specific element appearss
		//WebDriverWait wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(10));
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#loginLogoutButton")));

		// Take the screenshot and save it
		File screenshotFile = ((TakesScreenshot) chromeDriver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.moveFile(screenshotFile, new File("report/screenshots.png"));
			System.out.println("Screenshot taken and saved successfully");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//8. Clean up
		chromeDriver.quit();
		chromeDriver.quit();

	}

}
