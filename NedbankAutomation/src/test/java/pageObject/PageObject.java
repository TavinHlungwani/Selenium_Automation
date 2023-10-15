package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.testng.Assert.assertTrue;

public class PageObject {

	WebDriver webDriver;

	public PageObject(WebDriver webDriver) {
		this.webDriver = webDriver;
		PageFactory.initElements(webDriver, this);
	}

	@FindBy(xpath = "//span[.='My account']")
	private WebElement accountBtn;

	// click account
	public void clickAccount() {
		if (accountBtn.isDisplayed() == true) {
			accountBtn.click();
			assertTrue(true);
			try {
				Thread.sleep(3500);
			} catch (Exception e) {
				System.out.println("Oops: " + e.getLocalizedMessage());
			}
		} else {
			assertTrue(false);
			System.out.println("Ooops");
		}
	}

	@FindBy(xpath = "//input[@id='username']")
	private WebElement usernameInput;

	public void captureUsername(String userName) {
		if (usernameInput.isDisplayed() == true) {
			usernameInput.click();
			usernameInput.sendKeys(userName);
			assertTrue(true);
			try {
				Thread.sleep(3500);
			} catch (Exception e) {
				System.out.println("Oops: " + e.getLocalizedMessage());
			}
		} else {
			assertTrue(false);
			System.out.println("Ooops");
		}
	}

	@FindBy(xpath = "//input[@id='password']")
	private WebElement passwordInput;

	public void capturePassword(String password) {
		if (passwordInput.isDisplayed() == true) {
			passwordInput.click();
			passwordInput.sendKeys(password);
			assertTrue(true);
			try {
				Thread.sleep(3500);
			} catch (Exception e) {
				System.out.println("Oops: " + e.getLocalizedMessage());
			}
		} else {
			assertTrue(false);
			System.out.println("Ooops");
		}
	}

	@FindBy(xpath = "//button[@name='login']")
	private WebElement loginBtn;

	public void clickLogin() {
		if (loginBtn.isDisplayed() == true) {
			loginBtn.click();
			assertTrue(true);
			try {
				Thread.sleep(3500);
			} catch (Exception e) {
				System.out.println("Oops: " + e.getLocalizedMessage());
			}
		} else {
			assertTrue(false);
			System.out.println("Ooops");
		}
	}
	
	
	@FindBy(xpath = "//spashopButtonn[.='Shop']")
	private WebElement shopBtn;
	
	@FindBy(xpath = "//h2[contains(.,'Wine (8)')]")
	private WebElement clickWine;
	
	
	public void clickShopandWine() {
		if (shopBtn.isDisplayed() == true) {
			shopBtn.click();
			assertTrue(true);
			try {
				Thread.sleep(3500);
			} catch (Exception e) {
				System.out.println("Oops: " + e.getLocalizedMessage());
			}
			
		} else {
			assertTrue(false);
			System.out.println("Ooops");
		}
		
		if (clickWine.isDisplayed() == true) {
			clickWine.click();
			assertTrue(true);
			try {
				Thread.sleep(3500);
			} catch (Exception e) {
				System.out.println("Oops: " + e.getLocalizedMessage());
			}
			
		} else {
			assertTrue(false);
			System.out.println("Ooops");
		}
	}
	
	
	
	

}
