package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.Assertion;

public class LoginPage {
    private WebDriver chromeDriver;

    public LoginPage(WebDriver chromeDriver) {
        this.chromeDriver = chromeDriver;
    }

    public void clickLoginLink(){
        WebElement loginLink = chromeDriver.findElement(By.xpath("//a[.='Login']"));
        loginLink.click();
    }

    public void captureUsername(String username){
        WebElement inputUsername = chromeDriver.findElement(By.id("customer_login_email"));
        inputUsername.sendKeys(username);
    }

    public void capturePassword(String password){
        WebElement inputPassword = chromeDriver.findElement(By.id("customer_login_password"));
        inputPassword.sendKeys(password);
    }

    public void clickLoginButton(){
        WebElement btnLogin = chromeDriver.findElement(By.cssSelector(".submit-action"));
        btnLogin.click();
    }

    public void verifyErrorMessage(){
        WebElement txtErrorMessage = chromeDriver.findElement(By.id(".message"));
        boolean txtDisplayed = txtErrorMessage.isDisplayed();
        if(txtDisplayed){
            Assert.assertTrue(true);
            System.out.println("Text Is Displayed and Test Passed");
        }else {
            System.out.println("Text Not Displayed");
        }

    }


}
