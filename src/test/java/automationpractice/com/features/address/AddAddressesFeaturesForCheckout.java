package automationpractice.com.features.address;

import automationpractice.com.pages.*;
import automationpractice.com.steps.AddressesDataSteps;
import automationpractice.com.steps.LoginSteps;
import automationpractice.com.steps.RemoveAddressSteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.assertj.core.api.SoftAssertions;

import java.util.List;

import static automationpractice.com.data.NewAddressInformation.NEW_ADDRESS_INFORMATION_1;

public class AddAddressesFeaturesForCheckout {

    private SummaryCheckoutPage summaryCheckoutPage;
    private AddressCheckoutPage addressCheckoutPage;
    private HomePage homePage;
    private MyAccountPage myAccountPage;
    private ProductDetailsPage productDetailsPage;
    private AddressPage addressPage;
    private HeaderBox headerBox;
    @Steps
    private LoginSteps loginSteps;
    @Steps
    private AddressesDataSteps addressesDataSteps;
    @Steps
    private RemoveAddressSteps removeAddressSteps;
    private final SoftAssertions softAssertions = new SoftAssertions();

    @Given("^user is in address checkout page$")
    public void userIsInAddressCheckoutPage() {
        homePage.open();
        loginSteps.login();
        myAccountPage.clickMyAddresses();
        removeAddressSteps.checkAddressNameExistsAndIfIsDeleteIt(NEW_ADDRESS_INFORMATION_1.getNewAddressName());
        headerBox.clickMyStoreLogo();
        homePage.clickOnProductImage();
        productDetailsPage.clickOnAddToCartButton();
        productDetailsPage.clickProceedToCheckoutButton();
        summaryCheckoutPage.clickOnProceedToCheckoutButton();
    }

    @When("^user input new address$")
    public void userInputNewAddress() {
        addressCheckoutPage.clickAddANewAddressButton();
        addressesDataSteps.inputExampleAddressesData();
    }

    @When("^user choices new address as delivery address$")
    public void userChoicesNewAddressAsDeliveryAddress() {
        addressCheckoutPage.selectDeliveryAddressFromList(NEW_ADDRESS_INFORMATION_1);
    }

    @Then("^the new address is selected as delivery address$")
    public void theNewAddressIsSelectedAsDeliveryAddress() {
        softAssertions.assertThat(addressCheckoutPage.getNameAndLastNameInDeliveryInAddressCheckoutPage().contains(NEW_ADDRESS_INFORMATION_1.getFirstNameAddress())).isTrue();
        softAssertions.assertThat(addressCheckoutPage.getNameAndLastNameInDeliveryInAddressCheckoutPage().contains(NEW_ADDRESS_INFORMATION_1.getLastNameAddress())).isTrue();
        softAssertions.assertThat(addressCheckoutPage.getCityAndStateAndZipCodeInDeliveryInAddressCheckoutPage().contains(NEW_ADDRESS_INFORMATION_1.getCity())).isTrue();
        softAssertions.assertThat(addressCheckoutPage.getCityAndStateAndZipCodeInDeliveryInAddressCheckoutPage().contains(NEW_ADDRESS_INFORMATION_1.getState())).isTrue();
        softAssertions.assertThat(addressCheckoutPage.getCityAndStateAndZipCodeInDeliveryInAddressCheckoutPage().contains(NEW_ADDRESS_INFORMATION_1.getZipCode())).isTrue();
        softAssertions.assertAll();
    }

    @When("^user choices new address as billing address$")
    public void userChoicesNewAddressAsBillingAddress() {
        addressCheckoutPage.selectBillingAddressFromList(NEW_ADDRESS_INFORMATION_1);
    }

    @Then("^the new address is selected as billing address$")
    public void theNewAddressIsSelectedAsBillingAddress() {
        softAssertions.assertThat(addressCheckoutPage.getNameAndLastNameInBillingInAddressCheckoutPage().contains(NEW_ADDRESS_INFORMATION_1.getFirstNameAddress())).isTrue();
        softAssertions.assertThat(addressCheckoutPage.getNameAndLastNameInBillingInAddressCheckoutPage().contains(NEW_ADDRESS_INFORMATION_1.getLastNameAddress())).isTrue();
        softAssertions.assertThat(addressCheckoutPage.getCityAndStateAndZipCodeInBillingInAddressCheckoutPage().contains(NEW_ADDRESS_INFORMATION_1.getCity())).isTrue();
        softAssertions.assertThat(addressCheckoutPage.getCityAndStateAndZipCodeInBillingInAddressCheckoutPage().contains(NEW_ADDRESS_INFORMATION_1.getState())).isTrue();
        softAssertions.assertThat(addressCheckoutPage.getCityAndStateAndZipCodeInBillingInAddressCheckoutPage().contains(NEW_ADDRESS_INFORMATION_1.getZipCode())).isTrue();
        softAssertions.assertAll();
    }

    @When("^user choices new address as delivery and billing address$")
    public void userChoicesNewAddressAsDeliveryAndBillingAddress() {
        addressCheckoutPage.selectDeliveryAndBillingAddressFromList(NEW_ADDRESS_INFORMATION_1);
    }

    @Then("^the new address is selected as delivery and billing address$")
    public void theNewAddressIsSelectedAsDeliveryAndBillingAddress() {
        theNewAddressIsSelectedAsDeliveryAddress();
        theNewAddressIsSelectedAsBillingAddress();
    }

//    private void checkAddressNameExistsAndIfIsDeleteIt(final String addressName) {
//        List<String> addressNameList = addressPage.getAddressNameList();
//        for (String name : addressNameList){
//            if (name.toUpperCase().equals(addressName.toUpperCase())){
//                addressPage.removeAddressFromAddressPage(addressName);          }
//        }
//    }
}
