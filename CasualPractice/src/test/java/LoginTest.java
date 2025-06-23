import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LoginTest {
    private WebDriver chromeDriver;
    private LoginPage loginPage;
    private Properties testData;
    @BeforeClass(description = "Setting Up Drivers and Pages")
    void setUp(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
        loginPage = new LoginPage(chromeDriver);
        testData = new Properties();
        try {
            FileInputStream inputStream = new FileInputStream("data/testdata.properties");
            testData.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test(priority = 1, description = "Login Test")
    void login(){
        chromeDriver.get(testData.getProperty("login_url"));
        loginPage.clickSignIn();
        loginPage.captureUsername(testData.getProperty("login_username"));
        loginPage.clickFormSignIn();
    }

    @AfterClass(description = "Tear Down")
    void tearDown(){
        if(chromeDriver != null){
            chromeDriver.quit();
        }
    }
}