package automationpractice.com.features.login;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.assertj.core.api.SoftAssertions;

import static org.assertj.core.api.Assertions.assertThat;


public class LoginFeatures {
    private String user = "aa";
    private HomePage homePage;
    private LoginPanel loginPanel;

    @Steps
    private LoginSteps loginSteps;

    @Given("^customer is on home page$")
    public void customerIsOnHomePage() {
        homePage.open();
    }

    @Given("^logged in customer is on home page$")
    public void loggedInCustomerIsOnHomePage() {
        loginSteps.openHomePageAndLogIn();
    }

    @When("^he logs in using correct credentials$")
    public void heLogsInUsingCorrectCredentials() {
        loginSteps.login();
    }

    @When("^he tries to log in using wrong password$")
    public void heTriesToLogInUsingWrongPassword() {
        loginSteps.login(Users.WITH_OBJECT_NUMBER.getLogin(), "wrongPassword");
    }

    @When("^he logs out$")
    public void heLogsOut() {
        loginSteps.logOut();
    }

    @Then("^he is logged in$")
    public void heIsLoggedIn() {
        assertThat(loginPanel.isLogoutButtonVisible()).isTrue();
    }

    @Then("^he is not logged in$")
    public void heIsNotLoggedIn() {
        final SoftAssertions assertions = new SoftAssertions();
        assertions.assertThat(loginPanel.isLoginButtonVisible()).isTrue();
        assertions.assertThat(loginPanel.isLogoutButtonVisible()).isFalse();
        assertions.assertAll();
    }

    @Then("^he is logged out$")
    public void heIsLoggedOut() {
        final SoftAssertions assertions = new SoftAssertions();
        assertions.assertThat(loginPanel.isLogoutButtonVisible()).isFalse();
        assertions.assertThat(loginPanel.isShoppingCartVisible()).isFalse();
        assertions.assertAll();
    }
}
