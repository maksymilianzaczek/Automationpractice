package automationpractice.com.features;

import automationpractice.com.pages.HeaderBox;
import automationpractice.com.pages.HomePage;
import automationpractice.com.pages.LoginPage;
import automationpractice.com.pages.RegistrationPage;
import automationpractice.com.steps.RegistrationSteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.assertj.core.api.SoftAssertions;

import static org.assertj.core.api.Assertions.assertThat;

public class RegisterFeatures {

    private HomePage homePage;
    private HeaderBox headerBox;
    private LoginPage loginPage;
    private LoginPage email;
    private RegistrationPage registrationPage;
    @Steps
    private RegistrationSteps registrationSteps;


    @Given("^User is on login page$")
    public void userIsOnLoginPage() {
        homePage.open();
        headerBox.clickOnSignIn();
    }

    @When("^he submits form with unique e-mail$")
    public void heTypesUniqueEmail() {
        registrationSteps.createNewAccount();
    }

    @When("^on second registration page he submits fields with correct data$")
    public void onSecondRegistrationPageHeSubmitsFieldsWithCorrectData() {
        registrationSteps.fillRegistrationForm();
    }

    @Then("^new user is registered$")
    public void newUserIsRegistered() {
        final boolean isSignOutButtonDisplayed = headerBox.isSignOutButtonVisible();
        assertThat(isSignOutButtonDisplayed).isTrue();
    }

    @When("^he submits form with incorrect e-mail$")
    public void heSubmitsFormWithIncorrectEmail() {
        loginPage.typeEmailRegistration("####@!!!.com");
        loginPage.clickOnCreateAnAccount();
    }

    @When("^incorrectly submits form on second registration page$")
    public void incorrectlySubmitsFormOnSecondRegistrationPage() {
        registrationPage.typePostCode("402140214");
        registrationPage.clickRegisterButton();
    }

    @Then("^error message is displayed on login page$")
    public void errorMessageIsDisplayedOnLoginPage() {
        final boolean isValidationMessageDisplayed = loginPage.isValidationMessageDisplayed();
        final boolean isSignInButtonVisible = headerBox.isSignInButtonVisible();
        final SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(isValidationMessageDisplayed).isFalse();
        softAssertions.assertThat(isSignInButtonVisible).isTrue();
        softAssertions.assertAll();
    }

    @Then("^error message is displayed on home page$")
    public void errorMessageIsDisplayedOnHomePage() {
        final boolean isValidationMessageDisplayed = loginPage.isValidationMessageDisplayed();
        final boolean isSignInButtonVisible = headerBox.isSignInButtonVisible();
        final SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(isValidationMessageDisplayed).isTrue();
        softAssertions.assertThat(isSignInButtonVisible).isTrue();
        softAssertions.assertAll();
    }
}
