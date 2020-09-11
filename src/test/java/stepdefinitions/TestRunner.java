package stepdefinitions;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.*;

@RunWith(Cucumber.class) 
@CucumberOptions(features="src/test/resources/Features",
glue={"stepdefinitions"},
tags= "@End2End",
plugin={"pretty","html:target/HTMLReports.html"}
)

public class TestRunner {

}
