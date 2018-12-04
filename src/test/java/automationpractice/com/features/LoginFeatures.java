package automationpractice.com.features;

import automationpractice.com.pages.HeaderBox;
import automationpractice.com.pages.HomePage;
import automationpractice.com.pages.LoginPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.SoftAssertions;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginFeatures {

    final private String login = "maciej.stafijowski@solsfot.pl";
    final private String password = "12345678";

    private HomePage homePage;
    private HeaderBox headerBox;
    private LoginPage loginPage;


    @Given("^customer is on home page$")
    public void customerIsOnHomePage() {
        homePage.open();
    }

    @When("^he logs in using correct credentials$")
    public void heLogsInUsingCorrectCredentials() {
        loginWithCredentials(login, password);
    }


    @Then("^he is logged in$")
    public void heIsLoggedIn() {
        final boolean isSignOutButtonVisible = headerBox.isSignOutButtonVisible();
        assertThat(isSignOutButtonVisible).isTrue();
    }

    @When("^he tries to log in using wrong password$")
    public void heTriesToLogInUsingWrongPassword() {
        loginWithCredentials(login, "3213");
    }

    private void loginWithCredentials(String login, String password) {
        headerBox.clickOnSignIn();
        loginPage.typeLogin(login);
        loginPage.typePassword(password);
        loginPage.clickOnSignIn();
    }

    @Then("^he is not logged in$")
    public void heIsNotLoggedIn() {
        final boolean isValidationMessageDisplayed = loginPage.isValidationMessageDisplayed();
        final boolean isSignOutButtonVisible = headerBox.isSignOutButtonVisible();
        final SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(isValidationMessageDisplayed).isTrue();
        softAssertions.assertThat(isSignOutButtonVisible).isFalse();
        softAssertions.assertAll();
    }

    @Given("^logged in customer is on home page$")
    public void loggedInCustomerIsOnHomePage() {
        homePage.open();
        loginWithCredentials(login, password);
    }

    @When("^he logs out$")
    public void heLogsOut() {
        headerBox.clickOnSignOut();
    }

    @Then("^he is logged out$")
    public void heIsLoggedOut() {
        final boolean isSignInButtonDisplayed = headerBox.isSignInButtonVisible();
        assertThat(isSignInButtonDisplayed).isTrue();
    }

    @When("^he tries to log in using wrong login$")
    public void heTriesToLogInUsingWrongLogin() {
        loginWithCredentials("bla@bla.bla", password);
    }

}
