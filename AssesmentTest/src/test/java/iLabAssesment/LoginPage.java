package iLabAssesment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private final WebDriver chromeDriver;

    public LoginPage(WebDriver driver){
        this.chromeDriver = driver;
    }

    public void clickGlobalLoginButton(){
        WebElement btnLogin = chromeDriver.findElement(By.xpath("//button[@class='global-login-btn']"));
        btnLogin.click();
    }

    public void captureUsername(String username){
        WebElement usernameInput = chromeDriver.findElement(By.id("username"));
        usernameInput.sendKeys(username);
    }

    public void capturePassword(String password){
        WebElement passwordInput = chromeDriver.findElement(By.xpath("//input[@id='password']"));
        passwordInput.sendKeys(password);
    }

    public void clickFormLogin(){
        WebElement btnLogin = chromeDriver.findElement(By.xpath("//input[@value='Log in']"));
        btnLogin.click();
    }
}
