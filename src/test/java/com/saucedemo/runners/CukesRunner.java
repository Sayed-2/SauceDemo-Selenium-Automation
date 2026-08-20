package com.saucedemo.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = "html:target/cucumber-reports.html",
        features = "src/test/resources/features",
        glue = "com/saucedemo/step_definitions",
        dryRun = false
)
public class CukesRunner extends AbstractTestNGCucumberTests {
}
