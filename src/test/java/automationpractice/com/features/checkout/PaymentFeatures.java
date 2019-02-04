package automationpractice.com.features.checkout;

import automationpractice.com.exceptions.NoProductsOnHomePageException;
import automationpractice.com.pages.HomePage;
import automationpractice.com.pages.PaymentCheckoutPage;
import automationpractice.com.pages.ProductDetailsPage;
import automationpractice.com.pages.SummaryCheckoutPage;
import automationpractice.com.steps.LoginSteps;
import automationpractice.com.pages.AddressCheckoutPage;
import automationpractice.com.pages.ShippingCheckoutPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

import static org.assertj.core.api.Assertions.assertThat;

public class PaymentFeatures {

    private HomePage homePage;
    private ProductDetailsPage productDetailsPage;
    private SummaryCheckoutPage summaryCheckoutPage;
    private AddressCheckoutPage addressCheckoutPage;
    private ShippingCheckoutPage shippingCheckoutPage;
    private PaymentCheckoutPage paymentCheckoutPage;
    @Steps
    private LoginSteps loginSteps;

    @Given("^user is in payment checkout page$")
    public void userIsInPaymentCheckoutPage() {
        homePage.open();
        loginSteps.loginAndMoveIntoMyStorePage();
        final String productName = homePage.getListOfProducts().stream().findAny()
            .orElseThrow(() -> new NoProductsOnHomePageException("List of product in home page is empty")).getText();
        homePage.clickOnSelectedProductImage(productName);
        productDetailsPage.clickOnAddToCartButton();
        productDetailsPage.clickProceedToCheckoutButton();
        summaryCheckoutPage.clickOnProceedToCheckoutButton();
        addressCheckoutPage.clickOnProceedToCheckoutButton();
        shippingCheckoutPage.clickAgreeCheckbox();
        shippingCheckoutPage.clickOnProceedToCheckoutButton();
    }

    @When("^user pay by bank wire$")
    public void userPayByBankWire() {
        paymentCheckoutPage.clickPayByBankWireButton();
    }

    @Then("^payment by bank wire is made$")
    public void paymentByBankWireIsMade() {
        assertThat(paymentCheckoutPage.selectedPaymentMethod().contains("BANK-WIRE")).isTrue();
    }

    @When("^user pay by check$")
    public void userPayByCheck() {
        paymentCheckoutPage.clickPayByCheckButton();
    }

    @Then("^payment by check is made$")
    public void paymentByCheckIsMade() {
        assertThat(paymentCheckoutPage.selectedPaymentMethod().contains("CHECK PAYMENT")).isTrue();
    }

    @When("^user return to the payment selection$")
    public void userReturnToThePaymentSelection() {
        paymentCheckoutPage.clickOtherPaymentMethodButton();
    }

}
