package checkTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import page.loginPage;

public class LoginTest {
	static loginPage loginPage;
	
	public static void main(String[] args) {
		//1. Setup webdriver location
		System.setProperty("webdriver.chrome.driver", "webdriver/chromedriver.exe");
		
		//2. initialise web driver
		WebDriver driver = (WebDriver) new ChromeDriver();
		
		//3. Setup file properties
		Properties testData = new Properties();
		try {
			FileInputStream input = new FileInputStream("data/testdata.properties");
			testData.load(input);
			System.out.println("======: " + testData.getProperty("test_url"));
		} catch (FileNotFoundException e) {
			System.out.println("Oooops: No File Here: " + e.getMessage().toString());
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Oooops: IO Exception Here: " + e.getMessage().toString());
			e.printStackTrace();
		}
		
		//4. Get website and load it up
		String strUrl = testData.getProperty("test_url");
		driver.get(strUrl);
		
//		//5. Inspections and stuff
//		WebElement txtUsername = driver.findElement(By.id("username"));
//		WebElement txtPassword = driver.findElement(By.id("password"));
//		WebElement btnLogin = driver.findElement(By.xpath("//input[@id='login']"))
		
		
		//6. Save file props to vars
		String strUsername = testData.getProperty("test_username");
		String strPassword = testData.getProperty("test_password");
		
		//did we manage to get the data from file?
		System.out.println("Username: " + strUsername + "  \nPassword: " + strPassword);
		
		//7. Send Keys or data from file to form
		loginPage.sendKeys(strUsername);
		txtPassword.sendKeys(strPassword);
		
		//wanna hold a second? not for Prod Automation though
		try {
			Thread.sleep(3500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//8. Actions or Execute
		btnLogin.click();
		
		//9. Terminate?
		driver.close();
		
		

	}

}
