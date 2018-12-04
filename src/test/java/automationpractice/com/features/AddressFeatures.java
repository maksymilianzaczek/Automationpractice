package automationpractice.com.features;

import automationpractice.com.data.NewAddressInformations;
import automationpractice.com.domain.NewAddressData;
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
    private NewAddressInformations newAddressInformations;
    private NewAddressData newAddressData;

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
        final NewAddressData newAddressData = NewAddressInformations.NEW_ADDRESS_INFORMATIONS;
        addressPage.clickAddNewAddressButton();
        newAddressPage.typeFirstNameAddress(newAddressData.getFirstNameAddress());
        newAddressPage.typeLastNameAddress(newAddressData.getLastNameAddress());
        newAddressPage.typeAddress(newAddressData.getAddress());
        newAddressPage.typeCity(newAddressData.getCity());
        newAddressPage.typePostCode(newAddressData.getZipCode());
        newAddressPage.clickCountryList();
        newAddressPage.clickCountrySelect();
        newAddressPage.typeMobilePhone(newAddressData.getMobilePhone());
        newAddressPage.typeTitle(newAddressData.getNewAddresName());
        newAddressPage.clickStateList();
        newAddressPage.clickStateSelect(newAddressData.getState());
        newAddressPage.clickSaveNewAddressButton();
    }

    @Then("^new address is created$")
    public void newAddressIsCreated() {
        assertThat(addressPage.isNewAddressNameVisible()).isTrue();
    }

    @And("^new created address is deleted$")
    public void newCreatedAddressIsDeleted() {
        addressPage.clickDeleteButton();
        addressPage.getDriver().switchTo().alert().accept();
        assertThat(addressPage.isNewAddressNameVisible()).isFalse();
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
