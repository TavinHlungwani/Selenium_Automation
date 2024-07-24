package OneX;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;

public class OneXAssesment {

	public static void main(String[] args) {
		//1. Set driver location
		System.setProperty("webdriver.chrome.driver", "webdriver/chromedriver.exe");
		
		//2. WebDriver Setup, we use ChromeDriver
		WebDriver chromeWebDriver = new ChromeDriver();
		
		//3. File Management, we need Test Data from this file, no hard coding
		Properties testDatProperties = new Properties();
		try {
			FileInputStream inputStream = new FileInputStream("testdata/testdata.properties");
			testDatProperties.load(inputStream);   //load the properties data into properties var
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//4. Launch URL, from the testdata file
		System.out.println("The url: " + (testDatProperties.getProperty("test_url")));  //check if we found the URL from file
		chromeWebDriver.get(testDatProperties.getProperty("test_url"));
		chromeWebDriver.manage().window().maximize();   //maximise browser
		
		//5. Inspections - verifications and clicks
		WebElement resourcesTextElement = chromeWebDriver.findElement(By.cssSelector(".elementor-element-b08427e .elementor-heading-title"));
		((JavascriptExecutor) chromeWebDriver).executeScript("arguments[0].scrollIntoView(true);", resourcesTextElement); //scroll to Resources text
		WebElement whitePapersBookslinkElement = chromeWebDriver.findElement(By.cssSelector(".elementor-element-e728c17 [href='https://www.kurtosys.com/white-papers/'] > .elementor-icon-list-text")); //click this
		
		whitePapersBookslinkElement.click();
		
		WebElement whitePapersTextElement = chromeWebDriver.findElement(By.cssSelector(".elementor-element-7456037")); 
		System.out.println("Verifying: " + whitePapersTextElement.getText().toString().equals("White Papers"));  //verify the Text is "White Papers" and return boolean value
		WebElement WhitePaperTileElement = chromeWebDriver.findElement(By.xpath("//a[contains(.,'Institutional reporting survey')]"));  //click this
		WhitePaperTileElement.click();
		
		// Inspections
		WebElement firstNameInputElement = chromeWebDriver.findElement(By.id("form-field-firstname"));
		WebElement lastNameInputElement = chromeWebDriver.findElement(By.id("form-field-lastname"));
		WebElement companyNameInputElement = chromeWebDriver.findElement(By.id("form-field-company"));
		WebElement industryNameDropDownElement = chromeWebDriver.findElement(By.cssSelector("#form-field-industry")); //click dropdown
		WebElement industryNameDropDownItemElement = chromeWebDriver.findElement(By.cssSelector("[value='Financial Consultant']"));
		WebElement proceedButtonElement = chromeWebDriver.findElement(By.xpath("//span[.='Proceed to download']"));
		
		//inputs and clicks
		firstNameInputElement.sendKeys(testDatProperties.getProperty("test_first_name"));
		lastNameInputElement.sendKeys(testDatProperties.getProperty("test_last_name"));
		companyNameInputElement.sendKeys(testDatProperties.getProperty("test_company_name"));
		((JavascriptExecutor) chromeWebDriver).executeScript("arguments[0].scrollIntoView(true);", firstNameInputElement); //scroll to reveal stuff
		industryNameDropDownElement.click();   //industry dropdown
		industryNameDropDownItemElement.click();    //choose from list
		proceedButtonElement.click();
		
		//Hold to see what happened: To be removed.....
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//To be removed.....
		
		//6. Take Screenshot and save it
		System.out.println("taking screenshot and saving it...");
		File screenshot = ((TakesScreenshot) chromeWebDriver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File("screenshots/screenshot.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }		
		
		//8. Close Browser and Quit
		System.out.println("Closing browser and quiting session...");
		chromeWebDriver.close();
		chromeWebDriver.quit();
	}

}
