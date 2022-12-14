package hooks;

import context.TestContext;
import driver.WebDriverInstance;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class WebDriverHooks {
    WebDriver driver;
    final TestContext context;

    public WebDriverHooks(TestContext context) {
        this.context = context;
    }

    @Before
    public void before() {
        driver = WebDriverInstance.initialize(Boolean.parseBoolean(System.getProperty("running-on-hub", "false")));
        context.driver = driver;
    }

    @After
    public void after(Scenario scenario) {
        scenario.attach(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES),
                "image/png", "evidence-test");
        driver.quit();
    }
}
