package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions( // annotation for the class itself
        features = "src/test/resources/features",
        glue = "stepDefinitions",
        dryRun = true,
        tags ="@token",
        monochrome = true, // no jebresh , let us rad directly in console
        plugin = {"pretty", "html:target/cucumber-html.html"}



)

public class Runner extends AbstractTestNGCucumberTests { //comes from testNG







}
