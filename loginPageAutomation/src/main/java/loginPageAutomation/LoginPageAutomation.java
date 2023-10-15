package loginPageAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPageAutomation {

	public static void main(String[] args) {
		//1. Path of the Driver
		System.setProperty("webdriver.chrome.driver", "C:/automation/chromedriver.exe");

		//2. Declare the webdriver
		WebDriver driver = new ChromeDriver();
		
		//3. Now let's get it, navigate and wait
		//driver.get("https://www.login.com/login.html");
		driver.get("http://tutorials.gamechangersites.co.za/index.html");
		
		//4. Elements/Inspection
		WebElement usernameTextField = driver.findElement(By.id("username"));
		WebElement passwordTextField = driver.findElement(By.id("password"));
		WebElement loginButton = driver.findElement(By.id("login"));
		
		//5. Capture details
		usernameTextField.sendKeys("Steve@investec.com");
		passwordTextField.sendKeys("12345!");
		
		//6. Let's get in....
		loginButton.click();
		
		//Hold on a second to see the landing page?
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("We have a problem here: " + e.getMessage().toString());
		}
		
		//7. Cleanup
		driver.close(); //close it
		driver.quit();   //session over
		System.out.println("Did you see the miracle?('_')");
		
		
		
	}

}
