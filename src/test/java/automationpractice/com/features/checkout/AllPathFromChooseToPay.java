package automationpractice.com.features.checkout;

import automationpractice.com.pages.CheckoutPage;
import automationpractice.com.steps.LoginSteps;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

public class AllPathFromChooseToPay {

    private CheckoutPage checkoutPage;
    @Steps
    private LoginSteps loginSteps;

    @When("^he confirms every step to make order and pay by bank wire$")
    public void heConfirmsEveryStepToMakeOrderAndPayByBankWire() {
        checkoutPage.clickOnProceedToCheckoutButtonInSummaryLabel();
        checkoutPage.clickOnProceedToCheckoutButtonInAddressLabel();
        checkoutPage.clickAgreeCheckbox();
        checkoutPage.clickOnProceedToCheckoutButtonInShippingLabel();
        checkoutPage.clickPayByBankWireButton();
    }

    @When("^he confirms order$")
    public void heConfirmsOrder() {
        checkoutPage.clickIConfirmMyOrder();
    }

    @Then("^order is created$")
    public void orderIsCreated() {
        Assert.assertTrue(checkoutPage.isOrderConfirmationMessage());
    }

    @When("^he confirms every step to make order and pay by check$")
    public void heConfirmsEveryStepToMakeOrderAndPayByCheck() {
        checkoutPage.clickOnProceedToCheckoutButtonInSummaryLabel();
        checkoutPage.clickOnProceedToCheckoutButtonInAddressLabel();
        checkoutPage.clickAgreeCheckbox();
        checkoutPage.clickOnProceedToCheckoutButtonInShippingLabel();
        checkoutPage.clickPayByCheckButton();
    }
}
