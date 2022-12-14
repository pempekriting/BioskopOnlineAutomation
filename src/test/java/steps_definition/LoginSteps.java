package steps_definition;

import context.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.HomePage;

import static org.assertj.core.api.Assertions.assertThat;
public class LoginSteps {

    final HomePage homePage;

    public LoginSteps(TestContext testContext) {
        homePage = new HomePage(testContext);
    }

    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage() {
        homePage.clickMasukButton();
    }

    @When("the user enters a valid {string} and password")
    public void theUserEntersAValidUsernameAndPassword(String credentials) {
        if (credentials.equals("email")) {
            homePage.inputUsername("kgs.azzam@gmail.com")
                    .inputPassword("AkunTesting123");
        } else if (credentials.equals("phone number")) {
            homePage.inputUsername("081314914609")
                    .inputPassword("AkunTesting123");
        }
    }

    @And("clicks the login button")
    public void clicksTheLoginButton() {
        homePage.andThenLogin();
    }

    @When("the user enters an valid {string} and invalid {string}")
    public void theUserEntersAnInvalidUsernameAndPassword(String validField, String invalidField) {
        if (validField.equals("email") && invalidField.equals("password")) {
            homePage.inputUsername("kgs.azzam@gmail.com")
                    .inputPassword("wrongpassword");
        } else if (validField.equals("phone number") && invalidField.equals("password")) {
            homePage.inputUsername("081314914609")
                    .inputPassword("wrongpassword");
        } else if (validField.equals("password") && invalidField.equals("email")) {
            homePage.inputUsername("kgs.azzam@mailinator.com")
                    .inputPassword("AkunTesting123");
        } else if (validField.equals("password") && invalidField.equals("phone number")) {
            homePage.inputUsername("081321854102")
                    .inputPassword("AkunTesting123");
        }
    }

    @Then("an error message should be displayed")
    public void anErrorMessageShouldBeDisplayed() {
        Assert.assertTrue(homePage.isAlertFormLoginDisplayed());
        assertThat(homePage.getTextAlertFormLogin()).contains("kamu salah");
    }

    @Then("the user should be successfully login")
    public void theUserShouldBeRedirectedToTheHomePage() {
        Assert.assertTrue(homePage.isAlertSuccessLoginDisplayed());
        Assert.assertEquals(homePage.getTextAlertSuccessLogin(), "Masuk berhasil");
    }
}
