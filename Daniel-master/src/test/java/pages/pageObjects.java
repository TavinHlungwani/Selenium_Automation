package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.testng.Assert.assertTrue;

public class pageObjects {

    WebDriver webDriver;

    public pageObjects(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(name = "q")
    private WebElement search;

    public void setSearch(String searchw){
        if (search.isDisplayed() == true){
            assertTrue(true);
            search.sendKeys(searchw);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            search.sendKeys(Keys.ENTER);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }else
            assertTrue(false);
    }
}
