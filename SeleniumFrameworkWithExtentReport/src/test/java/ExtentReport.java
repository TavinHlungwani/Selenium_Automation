import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
/**
 * This class is for assisitng in creating and populating the extent report
 * @author T540p
 *
 */
public class ExtentReport {
	
	private static ExtentReports extent;
    private static ExtentTest test;
    private ExtentHtmlReporter htmlReporter;
    
    /**
     * Constructor
     */
	public ExtentReport() {
		 htmlReporter = new ExtentHtmlReporter("Report/testreport.html");
	     extent = new ExtentReports();
	     extent.attachReporter(htmlReporter);
	}
	
	/**
	 * Function to create a Test Name on the report
	 * @param testName
	 */
	public void testNameMethod(String testName) {
		test = extent.createTest(testName); // Create a test entry in the report
	}
	
	/**
	 * Test Information Method
	 */
	public void informationMethod(String message) {
		test.log(Status.INFO, "Information: " + message);	//log the pass message
	}
	
	/**
	 * Test Passed Method
	 */
	public void passedTestMethod() {
		test.log(Status.PASS, "This step passed successfully.");	//log the pass message
	}
	
	/**
	 * Failed Test Method
	 */
	public void failedTestMethod() {
		test.log(Status.FAIL, "This step failed badly.");	//log the fail message
	}
	
	/**
	 * Save Report - Flush the report to save it
	 */
	public void saveReport() {
		extent.flush(); // Flush the report to save it
	}
	
	//=========================DOES NOT WORK============================//
	/**
	 * Methods to capture screenhsot and add it to report
	 * @param driver - web driver to be used
	 * @throws IOException - in case the file has issues
	 */
	
	public void addScreenshorToReport(WebDriver driver) {
		driver = new ChromeDriver();
		String screenshotPath = captureScreenshot(driver); // Capture the screenshot
        try {
			test.log(Status.INFO, "Screenshot: " + test.addScreenCaptureFromPath(screenshotPath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String captureScreenshot(WebDriver driver) {
        // Capture a screenshot using Selenium WebDriver
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        
        // Define a path to save the screenshot
        String screenshotPath = "Screenshort/screenshot.png"; // Replace with your desired path

        // Copy the screenshot file to the specified location
        try {
			FileUtils.copyFile(screenshot, new File(screenshotPath));
			test.log(Status.INFO, "Screenshot: " + test.addScreenCaptureFromPath(screenshotPath));
		} catch (IOException e) {
			System.out.println("I could not work with screenshot: "+ e.getMessage().toString());
			e.printStackTrace();
		}
        return screenshotPath;
    }
	
}
