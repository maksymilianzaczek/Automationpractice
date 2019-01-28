package automationpractice.com.features.checkout;

import automationpractice.com.pages.AddressCheckoutPage;
import automationpractice.com.pages.PaymentCheckoutPage;
import automationpractice.com.pages.ShippingCheckoutPage;
import automationpractice.com.pages.SummaryCheckoutPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

public class AllPathFromChooseToPayFeatures {

    private SummaryCheckoutPage summaryCheckoutPage;
    private AddressCheckoutPage addressCheckoutPage;
    private ShippingCheckoutPage shippingCheckoutPage;
    private PaymentCheckoutPage paymentCheckoutPage;


    @When("^user confirms every step to make order and pay by bank wire$")
    public void userConfirmsEveryStepToMakeOrderAndPayByBankWire() {
        confirmEveryStepToMakeOrder();
        paymentCheckoutPage.clickPayByBankWireButton();
    }

    @When("user confirms order$")
    public void userConfirmsOrder() {
        paymentCheckoutPage.clickIConfirmMyOrderButton();
    }

    @Then("^order is created$")
    public void orderIsCreated() {
        assertThat(paymentCheckoutPage.isOrderConfirmationMessageVisible());
    }

    @When("^user confirms every step to make order and pay by check$")
    public void userConfirmsEveryStepToMakeOrderAndPayByCheck() {
        confirmEveryStepToMakeOrder();
        paymentCheckoutPage.clickPayByCheckButton();
    }

    private void confirmEveryStepToMakeOrder() {
        summaryCheckoutPage.clickOnProceedToCheckoutButton();
        addressCheckoutPage.clickOnProceedToCheckoutButton();
        shippingCheckoutPage.clickAgreeCheckbox();
        shippingCheckoutPage.clickOnProceedToCheckoutButton();
    }
}
