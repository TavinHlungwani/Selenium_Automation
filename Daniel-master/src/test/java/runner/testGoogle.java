package runner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.pageObjects;
import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.PropertyReader;

import java.util.concurrent.TimeUnit;

public class testGoogle {

    WebDriver webDriver;
    pageObjects objects;
    PropertyReader prop;

    @BeforeTest
    public void setup(){

        prop = new PropertyReader();
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webDriver.get(prop.readItem("url"));
        objects = new pageObjects(webDriver);


    }

    @Test(priority = 1, description = "Search Daniel on Google")
    public void search(){
        System.out.println("Test Case : Search Daniel On Google");

        objects.setSearch(prop.readItem("search"));

    }

    @AfterTest
    public void close(){
        webDriver.close();
    }

}
