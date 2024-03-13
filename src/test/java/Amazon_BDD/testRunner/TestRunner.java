package Amazon_BDD.testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/java/Amazon_BDD/features"},
        glue = {"Amazon_BDD.stepDefinations"})
public class TestRunner {
}
