package com.fluentexpressqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fluentexpressqa.utilities.Driver;

public class SignupPage {

	public String expectedPageTitle = "Sign up for fluent.express";

	private WebDriver driver;

	public SignupPage() {
		this.driver = Driver.getDriver();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div/nav/div[2]/a[4]")
	public WebElement signupButton;

}
