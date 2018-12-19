package automationpractice.com.features.checkout;

import automationpractice.com.pages.*;
import automationpractice.com.steps.LoginSteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

public class PaymentFeatures {

    private HomePage homePage;
    private ProductDetailsPage productDetailsPage;
    private PaymentCheckoutPage paymentCheckoutPage;
    @Steps
    private LoginSteps loginSteps;
    private HeaderBox headerBox;
    private SummaryCheckoutPage summaryCheckoutPage;
    private AddressCheckoutPage addressCheckoutPage;
    private ShippingCheckoutPage shippingCheckoutPage;

    @Given("^user is in payment checkout page$")
    public void userIsInPaymentCheckoutPage() {
        homePage.open();
        loginSteps.login();
        headerBox.clickMyStore();
        homePage.clickOnNewProductImage();
        productDetailsPage.clickOnAddToCartButton();
        productDetailsPage.clickProceedToCheckoutButton();
        summaryCheckoutPage.clickOnProceedToCheckoutButtonInSummaryLabel();
        addressCheckoutPage.clickOnProceedToCheckoutButtonInAddressLabel();
        shippingCheckoutPage.clickAgreeCheckbox();
        shippingCheckoutPage.clickOnProceedToCheckoutButtonInShippingLabel();
    }

    @When("^user pay by bank wire$")
    public void userPayByBankWire() {
        paymentCheckoutPage.clickPayByBankWireButton();
    }

    @Then("^payment by bank wire is made$")
    public void paymentByBankWireIsMade() {
        Assert.assertTrue(paymentCheckoutPage.isSelectedPayByBankWire());
    }

    @When("^user pay by check$")
    public void userPayByCheck() {
        paymentCheckoutPage.clickPayByCheckButton();
    }

    @Then("^payment by check is made$")
    public void paymentByCheckIsMade() {
        Assert.assertTrue(paymentCheckoutPage.isSelectedPayByCheck());
    }

    @When("^user return to the payment selection$")
    public void userReturnToThePaymentSelection() {
        paymentCheckoutPage.clickOtherPaymentMethods();
    }

}
