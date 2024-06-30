package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class loginPage {
	WebDriver driver;
	WebElement txtUsername, txtPassword, btnLogin;
	
	public loginPage() {
		//5. Inspections and stuff
		driver = new ChromeDriver();
		txtUsername = driver.findElement(By.id("username"));
		txtPassword = driver.findElement(By.id("password"));
		btnLogin = driver.findElement(By.xpath("//input[@id='login']"));
	}

}
