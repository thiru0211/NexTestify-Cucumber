package runnerClass;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\thirumaran\\eclipse-workspace\\NexTestify_Cucumber\\src\\test\\resources\\FeatureFiles\\3_OEP_StudyMaterial.feature", glue = "stepDefinition", monochrome = true,
//dryRun = true,
//tags="@Test",
		plugin = { "pretty", "html:Reports/TestReport.html", 
//				"json:target/cucumber/cucumber.json",
//				"html:Reports/cucumber-reports.html",
//				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
				 })
public class OEP_3_StudyMaterialRunnerTest {

	
}
