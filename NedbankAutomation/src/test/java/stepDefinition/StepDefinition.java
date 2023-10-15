package stepDefinition;

import org.testng.annotations.Test;

import baseTest.BaseTest;
import pageObject.PageObject;

public class StepDefinition extends BaseTest{
	private PageObject pageObject;
	
	@Test(priority = 1, description = "Login")
	public void login() {
		System.out.println("Click Login Button");
		pageObject.clickAccount();
		try {
			Thread.sleep(25000);
		}catch(Exception e) {
			System.out.println("Ooops: " + e.getMessage());
		}
		
		
		System.out.println("Capture Username");
		pageObject.captureUsername("TestUser");
		try {
			Thread.sleep(25000);
		}catch(Exception e) {
			System.out.println("Ooops: " + e.getMessage());
		}
		
		System.out.println("Capture Password");
		pageObject.capturePassword("Tester5027#");
		try {
			Thread.sleep(25000);
		}catch(Exception e) {
			System.out.println("Ooops: " + e.getMessage());
		}
		
	}
	
	@Test(priority = 2, description = "Searching for Bottle of Beyerskloof Pinotage 2019 wine")
	public void clickShopAndWine() {
		System.out.println("Click SHop Button");
		pageObject.clickShopandWine();
		try {
			Thread.sleep(25000);
		}catch(Exception e) {
			System.out.println("Ooops: " + e.getMessage());
		}
		
	}
	
	
}
