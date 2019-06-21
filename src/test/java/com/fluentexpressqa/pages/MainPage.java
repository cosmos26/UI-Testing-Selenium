package com.fluentexpressqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fluentexpressqa.utilities.Driver;

public class MainPage {
	private WebDriver driver;

	public String expectedPageTitle="Requests queue";


	public MainPage() {
		this.driver = Driver.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id=\"header\"]/div/nav/div[2]/a[5]")
	public WebElement loginButton;
	
}
