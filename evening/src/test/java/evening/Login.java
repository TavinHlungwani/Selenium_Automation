package evening;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Login {

	public static void main(String[] args) {
		//Setup driver
		System.setProperty("driver.web.chromedriver", "webdriver/chromedriver.exe");
		
		//Initialise driver
		WebDriver driver = new ChromeDriver();
		
		//Setup file properties
		Properties input = new Properties();
		try {
			FileInputStream testData = new FileInputStream("data/testdata.properties");
			input.load(testData);
			System.out.println(input.getProperty("test_url"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		//Open browser
		driver.get(input.getProperty("test_url"));
		
		//Inspections
		WebElement txtUsernameElement = driver.findElement(By.xpath("//input[@id='username']"));
		WebElement txtPasswordElement = driver.findElement(By.id("password"));
		WebElement btnLoginElement = driver.findElement(By.id("login"));
		
		//Send keys to form
		txtUsernameElement.sendKeys(input.getProperty("test_username"));
		txtPasswordElement.sendKeys(input.getProperty("test_password"));
		
		//Hold to see what is happenng
		try {
			Thread.sleep(3500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Actions or Clicks
		btnLoginElement.click();
		
		//Terminate
		driver.close();

	}

}
