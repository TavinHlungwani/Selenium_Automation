package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoginTest {
    private WebDriver chromeDriver;
    private LoginPage loginPage;
    private Properties testDataProperties;
    @BeforeClass(description = "Setting up")
    void settingUp(){
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
        loginPage = new LoginPage(chromeDriver);
        testDataProperties = new Properties();
    }

    @Test(priority = 1, description = "Login to TakeALot")
    void login() throws InterruptedException {
        try {
            FileInputStream inputStream = new FileInputStream("data/data.properties");
            testDataProperties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        chromeDriver.get(testDataProperties.getProperty("login_url"));
        Thread.sleep(5000);
        loginPage.clickLoginLink();
        loginPage.captureUsername(testDataProperties.getProperty("login_username"));
        loginPage.capturePassword(testDataProperties.getProperty("login_password"));
        loginPage.clickLoginButton();
    }

    @Test(priority = 2, description = "Validate login page")
    void dashboard() throws InterruptedException {
        Thread.sleep(5000);
        loginPage.verifyErrorMessage();
    }

    @AfterClass(description = "Tear Down")
    void tearDown(){
        if(chromeDriver !=null){
            chromeDriver.quit();
        }
    }
}

