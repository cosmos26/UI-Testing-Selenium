package com.fluentexpressqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fluentexpressqa.utilities.Driver;

public class GmailLoginPage {
	private WebDriver driver;
	
	public String expectedPageTitle="Sign in - Google Accounts";
	
	public GmailLoginPage() {
		this.driver = Driver.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	/*
	 * We will use this element when we check page is loaded
	 */
	@FindBy(className="Fmgc2c")
	public WebElement element; 
	
	@FindBy(xpath = "//*[@id=\"identifierId\"]")
	public WebElement email;

	@FindBy(xpath = "//*[@id=\"identifierNext\"]/span/span") 
	public WebElement firstNextButton;

	@FindBy(xpath = "//*[@id=\"password\"]/div[1]/div/div[1]/input")
	public WebElement password;
	
	@FindBy(xpath = "//*[@id=\"passwordNext\"]/span/span") 
	public WebElement secondNextButton;
}
