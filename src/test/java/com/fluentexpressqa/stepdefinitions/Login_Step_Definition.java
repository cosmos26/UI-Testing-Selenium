package com.fluentexpressqa.stepdefinitions;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.JavascriptExecutor;

import com.fluentexpressqa.pages.GmailLoginPage;
import com.fluentexpressqa.pages.LoginPage;
import com.fluentexpressqa.pages.MainPage;
import com.fluentexpressqa.utilities.BrowserUtils;
import com.fluentexpressqa.utilities.ConfigurationReader;
import com.fluentexpressqa.utilities.Driver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Login_Step_Definition {

	MainPage mainPage = new MainPage();
	LoginPage loginPage = new LoginPage();
	GmailLoginPage gmailLoginPage = new GmailLoginPage();

	@Given("User navigates to Main Page")
	public void user_navigates_to_Main_Page() {

		Driver.getDriver().get(ConfigurationReader.getProperty("url"));

	}

	@When("User click login button, Login Page should be opened")
	public void user_click_login_button_Login_Page_should_be_opened() {

		mainPage.loginButton.click();
		String actualPageTitle = Driver.getDriver().getTitle(); // Actual result

		System.out.println("Expected = " + loginPage.expectedPageTitle);
		System.out.println("Actual = " + actualPageTitle);
		assertEquals(loginPage.expectedPageTitle, actualPageTitle);

	}

	@When("User enter username")
	public void user_enter_username() {

		loginPage.userName.sendKeys(ConfigurationReader.getProperty("username"));
	}

	@When("User enter password")
	public void user_enter_password() {

		loginPage.passWord.sendKeys(ConfigurationReader.getProperty("password"));

	}

	@When("User click login button")
	public void user_click_login_button() {

		loginPage.loginButton.click();

	}

	@Then("User should login Home page successfully")
	public void user_should_login_Home_page_successfully() {
		
		
		String actualPageTitle = Driver.getDriver().getTitle();
		System.out.println("Expected = " + mainPage.expectedPageTitle);
		System.out.println("Actual = " + actualPageTitle);
		assertEquals(mainPage.expectedPageTitle, actualPageTitle);
	}

	@Then("User cannot login Home Page because of empty fields")
	public void user_cannot_login_Home_Page() {
		String actualPageTitle = Driver.getDriver().getTitle(); // Actual result
		assertEquals(loginPage.expectedPageTitle, actualPageTitle); // We are still on LoginPage

		JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();  
		boolean isRequired = (Boolean) js.executeScript("return arguments[0].required;",loginPage.userName);
		if(isRequired )
		{
		   //element is required and validation error will popup if the field is empty.
			System.out.println(loginPage.fieldNotFilledErrorMessage);
		}else {
			System.out.println("it is not required");
		}
		//assertEquals(loginPage.fieldNotFilledErrorMessage, loginPage.errorMessage.getText()); // error message when not
																								// all required fields
		assertEquals(true, isRequired);																						// are filled
		
	}

	@When("User enter invalid password")
	public void user_enter_invalid_password() {
		loginPage.passWord.sendKeys("invalid_password_01"); // invalid password
	}

	@When("User enter invalid username")
	public void user_enter_invalid_username() {
		loginPage.userName.sendKeys("invalid@username.com"); // invalid username
	}

	@Then("^User cannot login Home Page because of wrong credentials$")
	public void userCannotLoginHomePageBecauseInvalidData() throws Throwable {
		String actualPageTitle = Driver.getDriver().getTitle(); // Actual result
		assertEquals(loginPage.expectedPageTitle, actualPageTitle); // We are still on LoginPage

		assertEquals(loginPage.loginDataWrongErrorMessage, loginPage.errorMessage.getText()); // error message when the
																								// user entered the
																								// wrong credentials

	}

	@When("User click login in with Google button")
	public void user_click_login_in_with_Google_button() {

		loginPage.loginWithGoogle.click();

	}

	@When("Gmail login page should be open")
	public void gmail_login_page_should_be_open() {
		
		BrowserUtils.waitForVisibility(gmailLoginPage.element, 2); //We will wait until page is loaded
		String actualPageTitle=Driver.getDriver().getTitle();  // Actual result
		assertEquals(gmailLoginPage.expectedPageTitle, actualPageTitle);
		
	}

	@When("User enter gmail username")
	public void user_enter_gmail_username() {
	   
		gmailLoginPage.email.sendKeys(ConfigurationReader.getProperty("gmailUsername"));
		
	}

	
	
	@Then("User click first next button")
	public void user_click_first_next_button() {

		gmailLoginPage.firstNextButton.click();
		
	}

	
	
	@When("User enter gmail password")
	public void user_enter_gmail_password() {

		gmailLoginPage.password.sendKeys(ConfigurationReader.getProperty("gmailPassword"));
		
	}
	
	@Then("User click second next button")
	public void user_click_second_next_button() {
	    
		BrowserUtils.waitForClickablility(gmailLoginPage.secondNextButton, 2);
		gmailLoginPage.secondNextButton.click();
		
	}
}