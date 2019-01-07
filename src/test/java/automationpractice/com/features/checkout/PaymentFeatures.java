package automationpractice.com.features.checkout;

import automationpractice.com.pages.*;
import automationpractice.com.steps.LoginSteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

import static org.assertj.core.api.Assertions.assertThat;

public class PaymentFeatures {

    private HomePage homePage;
    private ProductDetailsPage productDetailsPage;
    private PaymentCheckoutPage paymentCheckoutPage;
    @Steps
    private LoginSteps loginSteps;
    private SummaryCheckoutPage summaryCheckoutPage;
    private AddressCheckoutPage addressCheckoutPage;
    private ShippingCheckoutPage shippingCheckoutPage;

    @Given("^user is in payment checkout page$")
    public void userIsInPaymentCheckoutPage() {
        homePage.open();
        loginSteps.loginAndMoveIntoMyStorePage();
        homePage.clickOnFirstProductImage();
        productDetailsPage.clickOnAddToCartButton();
        productDetailsPage.clickProceedToCheckoutButton();
        summaryCheckoutPage.clickOnProceedToCheckoutButton();
        addressCheckoutPage.clickOnProceedToCheckoutButtonInAddressLabel();
        shippingCheckoutPage.clickAgreeCheckbox();
        shippingCheckoutPage.clickOnProceedToCheckoutButton();
    }

    @When("^user pay by bank wire$")
    public void userPayByBankWire() {
        paymentCheckoutPage.clickPayByBankWireButton();
    }

    @Then("^payment by bank wire is made$")
    public void paymentByBankWireIsMade() {
        assertThat(paymentCheckoutPage.isSelectedPayByBankWireMethod()).isTrue();
    }

    @When("^user pay by check$")
    public void userPayByCheck() {
        paymentCheckoutPage.clickPayByCheckButton();
    }

    @Then("^payment by check is made$")
    public void paymentByCheckIsMade() {
        assertThat(paymentCheckoutPage.isSelectedPayByCheckMethod()).isTrue();
    }

    @When("^user return to the payment selection$")
    public void userReturnToThePaymentSelection() {
        paymentCheckoutPage.clickOtherPaymentMethodButton();
    }

}
