package TestRunners;

import Util.DriverFactory;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.WebDriver;

@CucumberOptions(
        features = {"src\\test\\java\\Features"},
        glue = {"StepDefinitions","Util"},
        tags = "@AmazonLoginSuccessAndSale",
        plugin = {
                "summary",
                "pretty",
                "html:Reports/SauceDemo/Reports.html"
        }
)

public class Runner extends AbstractTestNGCucumberTests { static WebDriver driver = DriverFactory.getDriver(); }