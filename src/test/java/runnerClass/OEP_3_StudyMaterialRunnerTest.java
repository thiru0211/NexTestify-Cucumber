package runnerClass;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\thirumaran\\eclipse-workspace\\NexTestify_Cucumber\\src\\test\\resources\\FeatureFiles\\3_OEP_StudyMaterial.feature", glue = "stepDefinition", monochrome = true,
//dryRun = true,
//tags="@Test",
		plugin = {"pretty",
//				"html:target/Study Material_cucumber-html-report.html",
//				"html:Reports/TestReport.html",
//				"json:target/cucumber/cucumber.json",
//				"html:Reports/cucumber-reports.html",
				"html:target/cucumber/Study Material_cucumberhtml-report.html",
				"json:target/cucumber/Study Material_cucumber.json",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
				})
public class OEP_3_StudyMaterialRunnerTest {

	
}
