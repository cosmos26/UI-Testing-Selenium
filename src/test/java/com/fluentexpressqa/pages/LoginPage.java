package com.fluentexpressqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fluentexpressqa.utilities.Driver;

public class LoginPage {
	private WebDriver driver;

	public  String expectedPageTitle = "Log in to fluent.express";
	public  String fieldNotFilledErrorMessage = "Fill all the fields!";
	public  String loginDataWrongErrorMessage = "A user with such email and password does not exist!";
	public  String expectedGmailPageTitle="Sign in - Google Accounts";
	

	public LoginPage() {
		this.driver = Driver.getDriver();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "/html/body/main/div/div/form/div[1]/input")
	public WebElement userName;

	@FindBy(xpath = "/html/body/main/div/div/form/div[2]/input")
	public WebElement passWord;

	@FindBy(xpath = "/html/body/main/div/div/form/div[4]/button")
	public WebElement loginButton;

	@FindBy(xpath = "/html/body/main/div/div/form/div[3]/p")
	public WebElement errorMessage;

	@FindBy(linkText = "Log in with Google")
	public WebElement loginWithGoogle;


}
