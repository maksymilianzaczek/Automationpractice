package automationpractice.com.features.checkout;

import automationpractice.com.pages.*;
import automationpractice.com.steps.LoginSteps;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

public class AllPathFromChooseToPayFeatures {

    @Steps
    private LoginSteps loginSteps;

    private SummaryCheckoutPage summaryCheckoutPage;
    private AddressCheckoutPage addressCheckoutPage;
    private ShippingCheckoutPage shippingCheckoutPage;
    private PaymentCheckoutPage paymentCheckoutPage;


    @When("^he confirms every step to make order and pay by bank wire$")
    public void heConfirmsEveryStepToMakeOrderAndPayByBankWire() {
        summaryCheckoutPage.clickOnProceedToCheckoutButtonInSummaryLabel();
        addressCheckoutPage.clickOnProceedToCheckoutButtonInAddressLabel();
        shippingCheckoutPage.clickAgreeCheckbox();
        shippingCheckoutPage.clickOnProceedToCheckoutButtonInShippingLabel();
        paymentCheckoutPage.clickPayByBankWireButton();
    }

    @When("^he confirms order$")
    public void heConfirmsOrder() {
        paymentCheckoutPage.clickIConfirmMyOrder();
    }

    @Then("^order is created$")
    public void orderIsCreated() {
        Assert.assertTrue(paymentCheckoutPage.isOrderConfirmationMessage());
//        isOrderConfirmationMessageDisplayed()
    }

    @When("^he confirms every step to make order and pay by check$")
    public void heConfirmsEveryStepToMakeOrderAndPayByCheck() {
        summaryCheckoutPage.clickOnProceedToCheckoutButtonInSummaryLabel();
        addressCheckoutPage.clickOnProceedToCheckoutButtonInAddressLabel();
        shippingCheckoutPage.clickAgreeCheckbox();
        shippingCheckoutPage.clickOnProceedToCheckoutButtonInShippingLabel();
        paymentCheckoutPage.clickPayByCheckButton();
    }
}
