package automationpractice.com.features;

import automationpractice.com.pages.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

public class AddressFeatures {

    final private String login = "maciej.stafijowski@solsoft.pl";
    final private String password = "12345678";

    private HomePage homePage;
    private HeaderBox headerBox;
    private LoginPage loginPage;
    private MyAccountPage myAccountPage;
    private NewAddressPage newAddressPage;
    private AddressPage addressPage;

    @Given("^logged in customer is on address page$")
    public void loggedInCustomerIsOnAddressPage() {
        homePage.open();
        headerBox.clickOnSignIn();
        loginPage.typeLogin(login);
        loginPage.typePassword(password);
        loginPage.clickOnSignIn();
        myAccountPage.clickMyAddresses();
    }


    @When("^he opens new address page and adds new address with proper data$")
    public void heOpensNewAddressPageAndAddsNewAddressWithProperData() {
        addressPage.clickAddNewAddressButton();
        newAddressPage.typeAddressFirstName();
        newAddressPage.typeAddressLastName();
        newAddressPage.typeAddress();
        newAddressPage.typeCity();
        newAddressPage.typePostalCode();
        newAddressPage.clickCountryList();
        newAddressPage.clickCountrySelect();
        newAddressPage.typeMobilePhone();
        newAddressPage.typeTitle("Title");
        newAddressPage.clickStateList();
        newAddressPage.clickStateSelect();
        newAddressPage.clickSaveNewAddressButton();
    }

    @Then("^new address is created$")
    public void newAddressIsCreated() {
        final boolean isNewAddressNameDisplayed = addressPage.isNewAddressNameVisible();
        assertThat(isNewAddressNameDisplayed).isTrue();
    }

    @And("^new created address is deleted$")
    public void newCreatedAddressIsDeleted() {
        addressPage.clickDeleteButton();
        final boolean isNewAddressNameDisplayed = addressPage.isNewAddressNameVisible();
        assertThat(isNewAddressNameDisplayed).isFalse();
    }


    @When("^he tries to add new address with empty fields$")
    public void heTriesToAddNewAddressWithEmptyFields() {
        addressPage.clickAddNewAddressButton();
        newAddressPage.clickSaveNewAddressButton();
    }

    @Then("^new address is not created$")
    public void newAddressIsNotCreated() {
        final boolean isErrorMessageForCreateNewAddressDisplayed = newAddressPage.isErrorMessageForNewAddressVisible();
        assertThat(isErrorMessageForCreateNewAddressDisplayed).isTrue();
    }
}
