package testRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "C://projects//testCucumberEndava//Features//AddProduct.feature",
        glue = "stepDefinitions",
        plugin = {"pretty", "html:test-output"}
)
public class TestRunner {

}
