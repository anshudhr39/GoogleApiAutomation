package cucumberOptions;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith (Cucumber.class)
@CucumberOptions(
	features="src/test/java/feature",
	plugin="json:target/jsonReports/cucumber-report.json",
	glue="stepdef"
	)
public class TestRunner {

}
