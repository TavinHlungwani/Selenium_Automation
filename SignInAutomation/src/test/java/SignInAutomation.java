import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SignInAutomation {

	public static void main(String[] args) {
		//1. Chromedriver path
		System.setProperty("webdriver.chrome.driver",  "C:/automation/chromedriver.exe");
		
		
		//2. Setup WebDriver and open url
		WebDriver chromeDriver = new ChromeDriver();
		
		chromeDriver.get("http://tutorials.gamechangersites.co.za/");
		
		//3. Inspections
		WebElement username = chromeDriver.findElement(By.xpath("//input[@id='username']"));
		WebElement password = chromeDriver.findElement(By.id("password"));
		WebElement SignInbutton = chromeDriver.findElement(By.id("login"));
		
		//4. Send Keys to page, click buttons
		username.sendKeys("steven@email.com");
		password.sendKeys("12345!!");
		
		SignInbutton.click();
		
		
		//5. Hold on a bit to see effect
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//6. Close
		chromeDriver.close();   //close driver
		chromeDriver.quit();    //terminate
	}

}
