package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = "src/test/resources/features/CreateAccountFeature.feature",
        plugin = {"pretty", "json:target/cucumber-html-reports/CreateAccountFeature.json"},
        glue = {"steps"}
)

public class CreateAccountRunner extends AbstractTestNGCucumberTests {
}
