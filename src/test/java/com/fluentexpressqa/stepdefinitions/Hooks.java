package com.fluentexpressqa.stepdefinitions;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import com.fluentexpressqa.utilities.ConfigurationReader;
import org.openqa.selenium.*;

import com.fluentexpressqa.utilities.Driver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Hooks {
	private static WebDriver driver;
	@Before
	public void setUp(Scenario scenario) throws MalformedURLException {
		driver = Driver.getDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}


	@After
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			// taking a screenshot
			final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
			// adding the screenshot to the report
			scenario.embed(screenshot, "image/png");
		}
		 Driver.closeDriver();
	}
}