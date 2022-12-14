package pages;

import context.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//button[contains(.,'Masuk')]")
    WebElement btnMasuk;

    @FindBy(css = "input[name='username']")
    WebElement inpUsername;

    @FindBy(css = "input[type='password']")
    WebElement inpPassword;

    @FindBy(xpath = "//form/button[contains(.,'Masuk')]")
    WebElement btnLogin;

    @FindBy(css = "div.toasted")
    WebElement alertSuccessLogin;

    @FindBy(css = "div.font-bold.text-xxs")
    WebElement alertFormLogin;

    public HomePage(TestContext context) {
        super(context);
    }

    public void clickMasukButton() {
        btnMasuk.click();
    }

    public HomePage inputUsername(String username) {
        inpUsername.sendKeys(username);
        return this;
    }

    public void inputPassword(String password) {
        inpPassword.sendKeys(password);
    }

    public void andThenLogin() {
        btnLogin.click();
    }

    public String getTextAlertSuccessLogin() {
        return alertSuccessLogin.getText().replace("check", "").trim();
    }

    public String getTextAlertFormLogin() {
        return alertFormLogin.getText().trim();
    }

    public boolean isAlertSuccessLoginDisplayed() {
        return alertSuccessLogin.isDisplayed();
    }

    public boolean isAlertFormLoginDisplayed() {
        return alertFormLogin.isDisplayed();
    }
}
