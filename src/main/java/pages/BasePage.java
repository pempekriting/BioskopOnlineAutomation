package pages;

import context.TestContext;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class BasePage {

    final WebDriver driver;
    static final Duration EXPLICIT_TIMEOUT = Duration.ofSeconds(10);
    static final Duration POLLING_TIME = Duration.ofMillis(1);

    public BasePage(TestContext context) {
        driver = context.driver;
        PageFactory.initElements(context.driver, this);
    }

    public FluentWait<WebDriver> fluentWait() {
        return new FluentWait<>(driver)
                .withTimeout(EXPLICIT_TIMEOUT)
                .pollingEvery(POLLING_TIME)
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);
    }
}
