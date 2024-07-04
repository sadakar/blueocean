/*
 * Copyright (c) 2003 - 2023 Inovalon Inc. All Rights Reserved.
 *
 * This computer program is CONFIDENTIAL and a TRADE SECRET of ABILITY Network Inc.
 * The receipt or possession of this program does not convey any rights to use,
 * reproduce or disclose its contents in whole or in part, without the specific
 * written consent of ABILITY Network Inc. Any use, reproduction or disclosure of
 * this program without the express written consent of ABILITY Network Inc. is a
 * violation of the copyright laws and may subject you to criminal prosecution.
 */
package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pagefactory.SiginInSignOut;
import pagefactory.Inventory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import driverfactory.WebDriverFactory;

public class SignInSignOutSD {


	private WebDriver driver;
	private SiginInSignOut signinSignOut;
	private Inventory inventory;

	public SignInSignOutSD() {
		this.driver = WebDriverFactory.getDriver(); 
		this.signinSignOut = new SiginInSignOut(driver);
		this.inventory = new Inventory(driver);
	}

	@Given("User is on the Swag Labs login page")
	public void loginPage() {
		WebDriverFactory.getDriver().get("https://www.saucedemo.com/v1/index.html");
	}
	@When("User enters valid username and password")
	public void enterUserNamePassword() throws InterruptedException {
		signinSignOut.enterUser();
		signinSignOut.enterPassword();
		
	}
	@And("User clicks on the login button")
	public void clickLoginButton() throws InterruptedException {
		signinSignOut.clickSignIn();
	}
	@Then("User should be logged in successfully")
	public void verifyLogin() throws InterruptedException {
		
		String expectedURL = "https://www.saucedemo.com/v1/inventory.html";
		String actualURL = driver.getCurrentUrl();
		Thread.sleep(3000); // not recommened to use 
		Assert.assertEquals(actualURL, expectedURL);
		System.out.println("Login Successful");
	}

	@Then("User clicks on the menu icon")
	public void clickMenuIcon() throws InterruptedException {
		inventory.menuButtonClick();
	}
	@And("User selects the logout option")
	public void clickLogOutOption() throws InterruptedException {
		
		Thread.sleep(2000);// not recommended 
		inventory.logOutSideBarLinkClick();
	}
	@Then("User should be logged out successfully")
	public void verifyLogout() throws InterruptedException {
		Thread.sleep(2000);
		String expectedURL ="https://www.saucedemo.com/v1/index.html";
		String actualURL = driver.getCurrentUrl();
		Assert.assertEquals(actualURL, expectedURL);
	}

	  
	     
	    
	
	
	

}
