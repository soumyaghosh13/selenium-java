package com.HRA.testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = "src/test/resources/features",
        glue = {"com/HRA/stepdefinitions"},
        plugin = {
                "pretty",
                "html:target/cucumber-reports/cucumber.html",
                "json:target/cucumber-reports/cucumber.json",
        },
        dryRun = false,
        monochrome = true,
        tags = "@DisableIssueSubjectAndIssueDisposition or @CreateExcelData or @EndToEnd or @CoreEndToEnd"

)

public class TestRunner extends AbstractTestNGCucumberTests {

}