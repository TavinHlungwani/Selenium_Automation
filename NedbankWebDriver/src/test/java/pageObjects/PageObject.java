package pageObjects;

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
	
	@FindBy(xpath = "//body[@class='page basicpage']")
	private WebElement searchLink;
	
	public void searchName(String name) {
		if(searchLink.isDisplayed() == true) {
			searchLink.click();
			assertTrue(true);
			try {
				Thread.sleep(25000);
			}catch(Exception e) {
				System.out.println("Ooops: " + e.toString());
			}
		}else {
			assertTrue(false);
		}
			
	}
	

	

}
