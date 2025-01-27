package runnerClass;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\thirumaran\\eclipse-workspace\\NexTestify_Cucumber\\src\\test\\resources\\FeatureFiles\\2_OEP_QuestionManager.feature", glue = "stepDefinition", monochrome = true,
//dryRun = true,
//tags="@TC_72",
		plugin = {"pretty",
				"html:target/cucumber-html-report",
				"html:Reports/TestReport.html",
				"json:target/cucumber/cucumber.json",
				"html:Reports/cucumber-reports.html",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
				})
public class OEP_2_QuestionManagerRunnerTest {

	
}
