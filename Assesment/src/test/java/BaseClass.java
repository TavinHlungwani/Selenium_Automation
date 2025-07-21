import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BaseClass {
	WebDriver chromeDriver;
	PageObject pageObject;
	FileManagement fileManagement;
	
	@BeforeClass(description = "Setting Up")
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		fileManagement = new FileManagement();
		chromeDriver = new ChromeDriver();
		chromeDriver.manage().window().maximize();
		//chromeDriver.get(fileManagement.getProperty("ilab_url"));
		System.out.println("Hellow:" + fileManagement.getProperty("ilab_url"));
	}
	
	@Test(priority = 1, description = "Logging In")
	public void login() {
		
	}
	
	@Test(priority = 2, description = "Fill in form")
	public void fillForm() {
		
	}
	
	@Test(priority = 3, description = "Logging out")
	public void logout() {
		
	}
	
	@AfterTest(description = "Cleaning up")
	public void cleanUp() {
		
	}
}
