package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import utils.Browsers;
import utils.Driver;

@CucumberOptions(
        features = {"src/test/java/features/Feature.feature"},
        glue = {"stepdefs"},
        tags = "@opencart",
        plugin = { "pretty",
                "json:test-output/cucumber-reports/Cucumber.json",
                "html:test-output/cucumber-reports/Cucumber.html"}
)
public class Runner1 extends AbstractTestNGCucumberTests {
    @BeforeTest
    @Parameters("browser")
    public  void beforeTest( @Optional String browser){
        if (browser!=null){
            Driver.getDriver(Browsers.valueOf(browser));
        }else {
            Driver.getDriver(Browsers.chrome);
        }

    }
}
