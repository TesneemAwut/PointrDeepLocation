package com.pointr.cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin={"pretty","html:target/cucumber-run","json:target/cucumber-report/cucumber.json"},
        features={"src/test/resources"},
        tags="@PointrTech"
)

public class CucumberRunner {

}
