import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoginTest {
    private WebDriver chromeDriver;
    private LoginPage loginPage;
    private Properties testData;

    @BeforeClass
    void setUp(){
        System.setProperty("webdriver.chrome.driver", "webdriver/chromedriver");
        chromeDriver = new ChromeDriver();
        loginPage = new LoginPage(chromeDriver);
        testData = new Properties();

        try {
            FileInputStream inputStream = new FileInputStream("data/testdata.properties");
            testData.load(inputStream);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("URL: " + testData.getProperty("test_url"));
        chromeDriver.get(testData.getProperty("test_url"));
        chromeDriver.manage().window().maximize();
        //Bad Practice, rather wait for web to load all elements using elenium await
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //Bad Practice, rather wait for web to load all elements using elenium await
    }

    @Test(priority = 1, description = "Click Login URL")
    void clickLogin(){
        loginPage.clickLoginUrl();
    }

    @Test(priority = 2, description = "Capture Email Address")
    void captureEmailAddress(){
        loginPage.captureEmailAddress(testData.getProperty("test_username"));
    }

    @Test(priority = 3, description = "Capture Password")
    void capturePassword(){
        loginPage.capturePassword(testData.getProperty("test_password"));
    }

    @Test(priority = 4, description = "Click View and Hide Password")
    void clickViewHidePassword(){
        loginPage.clickViewHidePassword();
        loginPage.clickViewHidePassword();
    }

    @Test(priority = 5, description = "Click Login Button")
    void clickLoginButton(){
    loginPage.clickLoginButton();
    }

    @AfterClass(description = "Tearing Down")
    void tearDown(){
        if(chromeDriver != null){
            chromeDriver.quit();
        }
    }
}
