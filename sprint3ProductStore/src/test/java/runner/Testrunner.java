package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features",
        glue = {"glue"},
        snippets = CAMELCASE,
        plugin= {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)
public class Testrunner {
}