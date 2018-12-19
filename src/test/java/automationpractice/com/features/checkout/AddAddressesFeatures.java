package automationpractice.com.features.checkout;

import automationpractice.com.data.NewAddressInformation;
import automationpractice.com.pages.AddressCheckoutPage;
import automationpractice.com.pages.SummaryCheckoutPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class AddAddressesFeatures {

    private SummaryCheckoutPage summaryCheckoutPage;
    private AddressCheckoutPage addressCheckoutPage;

    @When("^user input new address$")
    public void userInputNewAddress() {
        summaryCheckoutPage.clickOnProceedToCheckoutButtonInSummaryLabel();
        addressCheckoutPage.clickAddANewAddressButton();
        addressCheckoutPage.inputExampleAddressesData();
//        what data? you can't store andy data in page class
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

    @When("^user choices new address as delivery address$")
    public void userChoicesNewAddressAsDeliveryAddress() {
        addressCheckoutPage.selectDeliveryAddressFromList();
    }

    @Then("^the new address is selected as delivery address$")
    public void theNewAddressIsSelectedAsDeliveryAddress() {
        Assert.assertEquals((NewAddressInformation.NEW_ADDRESS_INFORMATION_1.getFirstNameAddress()
                        + " " + NewAddressInformation.NEW_ADDRESS_INFORMATION_1.getLastNameAddress())
                , addressCheckoutPage.isDeliveryAddressCorrectNameAndLastName());

        Assert.assertEquals((NewAddressInformation.NEW_ADDRESS_INFORMATION_1.getCity()
                        + ", " + NewAddressInformation.NEW_ADDRESS_INFORMATION_1.getState()
                        + " " + NewAddressInformation.NEW_ADDRESS_INFORMATION_1.getZipCode())
                , addressCheckoutPage.isDeliveryAddressCorrectCityAndStateAndZipCode());
    }
}
