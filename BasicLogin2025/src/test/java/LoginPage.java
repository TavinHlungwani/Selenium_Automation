import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Page Object Model
 * Page for elements inspections and functionalities
 */
public class LoginPage {

    public WebDriver chromeDriver;

    public LoginPage(WebDriver driver){
        this.chromeDriver = driver;
    }

    public void clickLoginUrl(){
        WebElement loginUrl = chromeDriver.findElement(By.xpath("//a[.='Login']"));
        loginUrl.click();
    }

    public void captureEmailAddress(String email){
        WebElement textInputEmail = chromeDriver.findElement(By.id("customer_login_email"));
        textInputEmail.sendKeys(email);
    }

    public void capturePassword(String password){
        WebElement textInputPassword = chromeDriver.findElement(By.id("customer_login_password"));
        textInputPassword.sendKeys(password);
    }

    public void clickViewHidePassword(){
        WebElement toggleViewHidePassword = chromeDriver.findElement(By.cssSelector(".unmask-icon"));
        toggleViewHidePassword.click();
    }

    public void clickLoginButton(){
        WebElement buttonLogin = chromeDriver.findElement(By.cssSelector(".submit-action"));
        buttonLogin.click();
    }
}
