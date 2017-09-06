package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features={"src/test/java/features"},glue="steps",
        format={"pretty","json:target/json/output.json","html:target/html/"}
)


public class RunnerTest extends AbstractTestNGCucumberTests{

}
