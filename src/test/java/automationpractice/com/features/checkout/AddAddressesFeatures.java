package automationpractice.com.features.checkout;

import automationpractice.com.data.NewAddressInformation;
import automationpractice.com.pages.CheckoutPage;
import automationpractice.com.steps.LoginSteps;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

//Unused import

public class AddAddressesFeatures {

    private CheckoutPage checkoutPage;

    @Steps
    private LoginSteps loginSteps;
//    never used


    @When("^user input new address$")
    public void userInputNewAddress() {
        checkoutPage.clickOnProceedToCheckoutButtonInSummaryLabel();
        checkoutPage.clickAddANewAddressButton();
        checkoutPage.inputExampleAddressesData();
//        what data? you can't store andy data in page class
    }

    @When("^user choices new address as billing address$")
    public void userChoicesNewAddressAsBillingAddress() {
        checkoutPage.selectBillingAddressFromList();
    }

    @Then("^the new address is selected as billing address$")
    public void theNewAddressIsSelectedAsBillingAddress() {
        Assert.assertEquals((NewAddressInformation.NEW_ADDRESS_INFORMATION_1.getFirstNameAddress()
                        + " " + NewAddressInformation.NEW_ADDRESS_INFORMATION_1.getLastNameAddress())
                , checkoutPage.isBillingAddressCorrectNameAndLastName());
/*        If you don't return boolean, method name shouldn't start from is. You can do this by:
       final SoftAssertions softAssertions = new SoftAssertions();
       softAssertions.assertThat(checkoutPage.getBillingAddress()).contains(NEW_ADDRESS_INFORMATION_1.getFirstNameAddress());
       softAssertions.assertThat(checkoutPage.getBillingAddress()).contains(NEW_ADDRESS_INFORMATION_1.getLastNameAddress());
       softAssertions.assertAll();
        */
        Assert.assertEquals((NewAddressInformation.NEW_ADDRESS_INFORMATION_1.getCity()
                        + ", " + NewAddressInformation.NEW_ADDRESS_INFORMATION_1.getState()
                        + " " + NewAddressInformation.NEW_ADDRESS_INFORMATION_1.getZipCode())
                , checkoutPage.isBillingAddressCorrectCityAndStateAndZipCode());
    }

    @When("^user choices new address as delivery and billing address$")
    public void userChoicesNewAddressAsDeliveryAndBillingAddress() {
        checkoutPage.selectDeliveryAndBillingAddressFromList();
    }

    @Then("^the new address is selected as delivery and billing address$")
    public void theNewAddressIsSelectedAsDeliveryAndBillingAddress() {
        theNewAddressIsSelectedAsDeliveryAddress();
        theNewAddressIsSelectedAsBillingAddress();
//        You forgot about asserts. That test always will be green
    }

    @When("^user choices new address as delivery address$")
    public void userChoicesNewAddressAsDeliveryAddress() {
        checkoutPage.selectDeliveryAddressFromList();
    }

    @Then("^the new address is selected as delivery address$")
    public void theNewAddressIsSelectedAsDeliveryAddress() {
        Assert.assertEquals((NewAddressInformation.NEW_ADDRESS_INFORMATION_1.getFirstNameAddress()
                        + " " + NewAddressInformation.NEW_ADDRESS_INFORMATION_1.getLastNameAddress())
                , checkoutPage.isDeliveryAddressCorrectNameAndLastName());

        Assert.assertEquals((NewAddressInformation.NEW_ADDRESS_INFORMATION_1.getCity()
                        + ", " + NewAddressInformation.NEW_ADDRESS_INFORMATION_1.getState()
                        + " " + NewAddressInformation.NEW_ADDRESS_INFORMATION_1.getZipCode())
                , checkoutPage.isDeliveryAddressCorrectCityAndStateAndZipCode());
    }
}
