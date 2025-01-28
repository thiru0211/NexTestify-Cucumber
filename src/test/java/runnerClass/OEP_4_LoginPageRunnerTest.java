package runnerClass;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features ="C:\\Users\\thirumaran\\eclipse-workspace\\NexTestify_Cucumber\\src\\test\\resources\\FeatureFiles\\4_OEP_Login.feature",
glue = "stepDefinition",
monochrome = true,
//dryRun = true,
//tags="@TC_17",
plugin = {"pretty",
//		"html:target/Login Page_cucumber-html-report.html",
//		"html:Reports/TestReport.html",
//		"json:target/cucumber/cucumber.json",
//		"html:Reports/cucumber-reports.html",
		"html:target/cucumber/Login Page_cucumberhtml-report.html",
		"json:target/cucumber/Login Page_cucumber.json",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
		})
public class OEP_4_LoginPageRunnerTest {

	
}
