package automationpractice.com.features;

import automationpractice.com.pages.HeaderBox;
import automationpractice.com.pages.HomePage;
import automationpractice.com.pages.LoginPage;
import automationpractice.com.pages.RegistrationPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;

import static org.assertj.core.api.Assertions.assertThat;

public class RegisterFeatures {

    final private String randomString = RandomStringUtils.randomAlphanumeric(13);
    final private String randomEmail = String.format("%s@gmai.com", randomString);

    private HomePage homePage;
    private HeaderBox headerBox;
    private LoginPage loginPage;
    private LoginPage email;
    private RegistrationPage registrationPage;


    @Given("^User is on home page$")
    public void userIsOnHomePage() {
        homePage.open();
    }


    @When("^he types unique e-mail$")
    public void heTypesUniqueEMail() {
        loginPage.typeEmailRegistration(randomEmail);
    }

    private void typeUniqueEmail(String email) {
        headerBox.clickOnSignIn();
        loginPage.typeEmailRegistration(email);
        loginPage.clickOnCreateAnAccount();
    }

    @When("^on second registration page he submits fields with correct data$")
    public void onSecondRegistrationPageHeSubmitsFieldsWithCorrectData() {
        registrationPage.clickOnTitle();
        registrationPage.typeFirstName();
        registrationPage.typeLastName();
        registrationPage.typeEmail();
        registrationPage.typePasswd();
        registrationPage.clickDayList();
        registrationPage.clickDaySelect();
        registrationPage.clickMonthsList();
        registrationPage.clickMonthsSelect();
        registrationPage.clickYearsList();
        registrationPage.clickYearsSelect();
        registrationPage.typeFirstNameAddress();
        registrationPage.typeLastNameAddress();
        registrationPage.typeAddress();
        registrationPage.typeCity();
        registrationPage.clickStateList();
        registrationPage.clickStateSelect();
        registrationPage.typePostCode();
        registrationPage.clickCountryList();
        registrationPage.clickCountrySelect();
        registrationPage.typeMobilePhone();
        registrationPage.clickRegisterButton();
    }

    @Then("^new user is registered$")
    public void newUserIsRegistered() {
        final boolean isSignOutButtonDisplayed = headerBox.isSignOutButtonVisible();
        assertThat(isSignOutButtonDisplayed).isTrue();
    }

    @When("^he submits form with incorrect e-mail$")
    public void heSubmitsFormWithIncorrectEMail() {
        loginPage.
    }
}
