package com.fluentexpressqa.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(plugin = { "pretty", "html:target/cucumber-report",
		"json:target/cucumber.json", "rerun:target/rerun.txt" }, 
		tags = "@login, @signup",
		features = { "src/test/resources/com/fluentexpressqa/features" }, 
		glue = "com/fluentexpressqa/stepdefinitions",
		dryRun = false
)

public class CukesRunner extends AbstractTestNGCucumberTests {

}
