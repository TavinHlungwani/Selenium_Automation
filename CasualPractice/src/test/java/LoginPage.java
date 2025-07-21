import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private final WebDriver chromeDriver;

    public LoginPage(WebDriver driver){
        this.chromeDriver = driver;
    }

    public void clickSignIn(){
        WebElement btnSignIn = chromeDriver.findElement(By.cssSelector(".primary"));
        btnSignIn.click();
    }

    public void captureUsername(String username){
        WebElement txtUsername = chromeDriver.findElement(By.xpath("//input[@name='pf.username']"));
        txtUsername.sendKeys(username);
    }

    public void clickFormSignIn(){
        WebElement btnSignIn = chromeDriver.findElement(By.id("signon"));
        btnSignIn.click();
    }
}
