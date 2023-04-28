package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/java/features/Feature.feature"},
        glue = {"stepdefs"},
        tags = "@opencart",
        plugin = { "pretty",
                "json:test-output/cucumber-reports/Cucumber.json",
                "html:test-output/cucumber-reports/Cucumber.html"}
)
public class Runner1 extends AbstractTestNGCucumberTests {

}
