package automationpractice.com.features.address;

import automationpractice.com.data.NewAddressInformation;
import automationpractice.com.pages.*;
import automationpractice.com.steps.AddressesDataSteps;
import automationpractice.com.steps.LoginSteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;

import static automationpractice.com.data.NewAddressInformation.NEW_ADDRESS_INFORMATION;
import static automationpractice.com.data.NewAddressInformation.NEW_ADDRESS_INFORMATION_1;

public class AddAddressesFeaturesForCheckout {

    private SummaryCheckoutPage summaryCheckoutPage;
    private AddressCheckoutPage addressCheckoutPage;
    private HomePage homePage;
    private MyAccountPage myAccountPage;
    @Steps
    private LoginSteps loginSteps;
    private ProductDetailsPage productDetailsPage;
    private AddressPage addressPage;
    private HeaderBox headerBox;
    @Steps
    private AddressesDataSteps addressesDataSteps;
    private final SoftAssertions softAssertions = new SoftAssertions();


    @Given("^user is in address checkout page$")
    public void userIsInAddressCheckoutPage() {
        homePage.open();
        loginSteps.login();
        myAccountPage.clickMyAddresses();
        addressPage.removeAddressFromAddressPage(NEW_ADDRESS_INFORMATION_1.getNewAddressName());
        headerBox.clickMyStore();
        homePage.clickOnNewProductImage();
        productDetailsPage.clickOnAddToCartButton();
        productDetailsPage.clickProceedToCheckoutButton();
        summaryCheckoutPage.clickOnProceedToCheckoutButtonInSummaryLabel();
    }

    @When("^user input new address$")
    public void userInputNewAddress() {
        addressCheckoutPage.clickAddANewAddressButton();
        addressesDataSteps.inputExampleAddressesData();
    }

    @When("^user choices new address as delivery address$")
    public void userChoicesNewAddressAsDeliveryAddress() {
        addressCheckoutPage.selectDeliveryAddressFromList();
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
        addressCheckoutPage.selectBillingAddressFromList();
    }

    @Then("^the new address is selected as billing address$")
    public void theNewAddressIsSelectedAsBillingAddress() {
        Assert.assertEquals((NewAddressInformation.NEW_ADDRESS_INFORMATION_1.getFirstNameAddress()
                        + " " + NewAddressInformation.NEW_ADDRESS_INFORMATION_1.getLastNameAddress())
                , addressCheckoutPage.isBillingAddressCorrectNameAndLastName());
/*        If you don't return boolean, method name shouldn't start from is. You can do this by:
       final SoftAssertions softAssertions = new SoftAssertions();
       softAssertions.assertThat(checkoutPage.getBillingAddress()).contains(NEW_ADDRESS_INFORMATION_1.getFirstNameAddress());
       softAssertions.assertThat(checkoutPage.getBillingAddress()).contains(NEW_ADDRESS_INFORMATION_1.getLastNameAddress());
       softAssertions.assertAll();
        */
        Assert.assertEquals((NewAddressInformation.NEW_ADDRESS_INFORMATION_1.getCity()
                        + ", " + NewAddressInformation.NEW_ADDRESS_INFORMATION_1.getState()
                        + " " + NewAddressInformation.NEW_ADDRESS_INFORMATION_1.getZipCode())
                , addressCheckoutPage.isBillingAddressCorrectCityAndStateAndZipCode());
    }

    @When("^user choices new address as delivery and billing address$")
    public void userChoicesNewAddressAsDeliveryAndBillingAddress() {
        addressCheckoutPage.selectDeliveryAndBillingAddressFromList();
    }

    @Then("^the new address is selected as delivery and billing address$")
    public void theNewAddressIsSelectedAsDeliveryAndBillingAddress() {
        theNewAddressIsSelectedAsDeliveryAddress();
        theNewAddressIsSelectedAsBillingAddress();
//        You forgot about asserts. That test always will be green
    }


}
