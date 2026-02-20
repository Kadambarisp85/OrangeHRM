package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags="",features= {"src/test/resources/Feature"},
glue= {"TestCase"},
plugin= {"pretty","html:target/HTMLReport.html"})

public class RunnerClass extends AbstractTestNGCucumberTests {

}
