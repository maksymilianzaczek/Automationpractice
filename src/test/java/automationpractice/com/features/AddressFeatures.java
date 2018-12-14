package automationpractice.com.features;

import automationpractice.com.pages.*;
import automationpractice.com.steps.LoginSteps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

import static automationpractice.com.data.NewAddressInformation.NEW_ADDRESS_INFORMATION;
import static automationpractice.com.data.NewAddressInformation.NEW_ADDRESS_INFORMATION_1;
import static org.assertj.core.api.Assertions.assertThat;

public class AddressFeatures {

    private HomePage homePage;
    private HeaderBox headerBox;
    private LoginPage loginPage;
    private MyAccountPage myAccountPage;
    private NewAddressPage newAddressPage;
    private AddressPage addressPage;
    @Steps
    private LoginSteps loginSteps;

    @Given("^logged in customer is on address page$")
    public void loggedInCustomerIsOnAddressPage() {
        homePage.open();
        loginSteps.login();
        myAccountPage.clickMyAddresses();
    }


    @When("^he opens new address page and adds new address with proper data$")
    public void heOpensNewAddressPageAndAddsNewAddressWithProperData() {
        addressPage.clickAddNewAddressButton();
        newAddressPage.typeFirstNameAddress(NEW_ADDRESS_INFORMATION.getFirstNameAddress());
        newAddressPage.typeLastNameAddress(NEW_ADDRESS_INFORMATION.getLastNameAddress());
        newAddressPage.typeAddress(NEW_ADDRESS_INFORMATION.getAddress());
        newAddressPage.typeCity(NEW_ADDRESS_INFORMATION.getCity());
        newAddressPage.typePostCode(NEW_ADDRESS_INFORMATION.getZipCode());
        newAddressPage.clickCountryList();
        newAddressPage.clickCountrySelect();
        newAddressPage.typeMobilePhone(NEW_ADDRESS_INFORMATION.getMobilePhone());
        newAddressPage.typeTitle(NEW_ADDRESS_INFORMATION.getNewAddressName());
        newAddressPage.clickStateList();
        newAddressPage.clickStateSelect(NEW_ADDRESS_INFORMATION.getState());
        newAddressPage.clickSaveNewAddressButton();
    }

    @Then("^new address is created$")
    public void newAddressIsCreated() {
        assertThat(addressPage.getAddressNameList()).contains(NEW_ADDRESS_INFORMATION.getNewAddressName().toUpperCase());
    }

    @And("^new created address is deleted$")
    public void newCreatedAddressIsDeleted() {
        addressPage.clickDeleteButton(NEW_ADDRESS_INFORMATION.getNewAddressName());
        addressPage.acceptAlert();
        assertThat(addressPage.getAddressNameList()).doesNotContain(NEW_ADDRESS_INFORMATION.getNewAddressName().toUpperCase());
    }


    @Then("^new created address is deleted after test$")
    public void newCreatedAddressIsDeletedAfterTest() {

        headerBox.clickOnLoggedUser();
        myAccountPage.clickMyAddresses();
        addressPage.clickDeleteButton(NEW_ADDRESS_INFORMATION_1.getNewAddressName());
        addressPage.acceptAlert();
        assertThat(addressPage.getAddressNameList()).doesNotContain(NEW_ADDRESS_INFORMATION_1.getNewAddressName());
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
