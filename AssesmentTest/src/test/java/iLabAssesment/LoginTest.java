package iLabAssesment;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LoginTest {
    WebDriver chromeDriver;
    Properties testData;
    LoginPage loginPage;

    @BeforeClass(description = "Setting Up Driver and Initiating")
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
        testData = new Properties();
        loginPage = new LoginPage(chromeDriver);
    }

    @Test(priority = 1, description = "Logging In")
    public void login(){
        try {
            FileInputStream inputStream = new FileInputStream("data/data.properties");
            testData.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("URL :" + testData.getProperty("login_url"));
        chromeDriver.get(testData.getProperty("login_url"));
        loginPage.clickGlobalLoginButton();
        loginPage.captureUsername(testData.getProperty("login_username"));
        loginPage.capturePassword(testData.getProperty("login_password"));
        loginPage.clickFormLogin();
    }

    @Test(priority = 2, description = "Assertion")
    void validateError(){

    }
    @AfterClass(description = "Cleaning up and Tearing down")
    public void cleanUp(){
        if(chromeDriver != null){
            chromeDriver.quit();
        }
    }
}
