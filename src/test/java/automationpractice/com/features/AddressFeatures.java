package automationpractice.com.features;

import automationpractice.com.pages.*;
import automationpractice.com.steps.LoginSteps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

import static automationpractice.com.data.AddressInformation.EDIT_ADDRESS_INFORMATION;
import static automationpractice.com.data.AddressInformation.NEW_ADDRESS_INFORMATION;
import static org.assertj.core.api.Assertions.assertThat;

public class AddressFeatures {

    private String emptyField = " ";
    private HomePage homePage;
    private MyAccountPage myAccountPage;
    private NewAddressPage newAddressPage;
    private AddressPage addressPage;
    private EditAddressPage editAddressPage;
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
        newAddressPage.typeTitle(NEW_ADDRESS_INFORMATION.getAddressName());
        newAddressPage.clickStateList();
        newAddressPage.clickStateSelect(NEW_ADDRESS_INFORMATION.getState());
        newAddressPage.clickSaveNewAddressButton();
    }

    @Then("^new address is created$")
    public void newAddressIsCreated() {
        assertThat(addressPage.getAddressNameList()).contains(NEW_ADDRESS_INFORMATION.getAddressName().toUpperCase());
    }

    @And("^new created address is deleted$")
    public void newCreatedAddressIsDeleted() {
        addressPage.clickDeleteButton(NEW_ADDRESS_INFORMATION.getAddressName());
        addressPage.acceptAlert();
        assertThat(addressPage.getAddressNameList()).doesNotContain(NEW_ADDRESS_INFORMATION.getAddressName().toUpperCase());
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

    @When("^he changes current address correctly$")
    public void heChangesCurrentAddressCorrectly() {
        addressPage.updateYourAddress(NEW_ADDRESS_INFORMATION.getAddressName());
        editAddressPage.changeFirstName(EDIT_ADDRESS_INFORMATION.getFirstName());
        editAddressPage.changeLastName(EDIT_ADDRESS_INFORMATION.getLastName());
        editAddressPage.changeAddress(EDIT_ADDRESS_INFORMATION.getAddress());
        editAddressPage.changeCity(EDIT_ADDRESS_INFORMATION.getCity());
        editAddressPage.changePostCode(EDIT_ADDRESS_INFORMATION.getZipCode());
        editAddressPage.clickCountryList();
        editAddressPage.clickCountrySelect();
        editAddressPage.changeHomePhone(EDIT_ADDRESS_INFORMATION.getHomePhone());
        editAddressPage.changeMobilePhone(EDIT_ADDRESS_INFORMATION.getMobilePhone());
        editAddressPage.changeTitle(EDIT_ADDRESS_INFORMATION.getAddressName());
        editAddressPage.clickStateList();
        editAddressPage.clickStateSelect(EDIT_ADDRESS_INFORMATION.getState());
        editAddressPage.clickSaveAddress();
    }

    @Then("^address is updated$")
    public void addressIsUpdated() {
        assertThat(addressPage.updatedAddressName()).contains(EDIT_ADDRESS_INFORMATION.getAddressName().toUpperCase());
    }

    @When("^he tries to change new address he leaves empty fields$")
    public void heTriesToChangeNewAddressHeLeavesEmptyFields() {
        addressPage.updateYourAddress(NEW_ADDRESS_INFORMATION.getAddressName());
        editAddressPage.changeFirstName(emptyField);
        editAddressPage.changeLastName(emptyField);
        editAddressPage.changeAddress(emptyField);
        editAddressPage.changeCity(emptyField);
        editAddressPage.changePostCode(emptyField);
        editAddressPage.clickCountryList();
        editAddressPage.clickCountrySelect();
        editAddressPage.changeHomePhone(emptyField);
        editAddressPage.changeMobilePhone(emptyField);
        editAddressPage.changeTitle(emptyField);
        editAddressPage.clickStateList();
        editAddressPage.clickStateSelect(emptyField);
        editAddressPage.clickSaveAddress();
    }

    @Then("^address is not updated$")
    public void addressIsNotUpdated() {
        assertThat(editAddressPage.errorMessageIsDisplayed()).isTrue();
    }
}
