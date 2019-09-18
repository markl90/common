package com.netbuilder.test.common.step;

import com.netbuilder.test.common.session.TestBase;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/resources/feature",
        dryRun = false,
        monochrome = true,
        glue = { "com.netbuilder.test.common.step" },
        tags = { "@test" },
        plugin = { "pretty", "html:target/test-reports", "json:target/cucumber-reports/Cucumber.json"}
)
public class TestRunner extends TestBase {

}