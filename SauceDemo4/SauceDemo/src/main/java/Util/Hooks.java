package Util;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import java.util.Properties;

public class Hooks {
    WebDriver driver;
    Properties propertires;

    @Before
    public void before() {
        String browser= Reporter
                .getCurrentTestResult()
                .getTestContext()
                .getCurrentXmlTest()
                .getParameter("browser");

        propertires = ConfigReader.initialize_Properties();

        driver = DriverFactory.initialize_Driver(browser);
    }

    @After
    public void after() throws InterruptedException {
        Thread.sleep(3000);

        driver.quit();
    }
}
