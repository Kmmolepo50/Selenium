package TestRunners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = {"src/test/java/Features"},
        glue={"StepDefinition"}
)
public class TestingRunner extends AbstractTestNGCucumberTests {
}
