package com.fluentexpressqa.stepdefinitions;

import com.fluentexpressqa.pages.SignupPage;
import com.fluentexpressqa.utilities.BrowserUtils;
import com.fluentexpressqa.utilities.Driver;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Signup_Step_Definition {
	
	SignupPage signupPage = new SignupPage();
	
	
	@When("User click signup button")
	public void user_click_signup_button() {
		BrowserUtils.fluentWait(signupPage.signupButton, 2);
		signupPage.signupButton.click();
	    
	}

	@Then("User should login Signup page successfully")
	public void user_should_login_Signup_page_successfully() {
	    
		String actualPageTitle = Driver.getDriver().getTitle();
		System.out.println("Expected = " + signupPage.expectedPageTitle);
		System.out.println("Actual = " + actualPageTitle);
		
		
	}
	
	

}
