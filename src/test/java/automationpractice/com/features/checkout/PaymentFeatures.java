package automationpractice.com.features.checkout;

import automationpractice.com.pages.CheckoutPage;
import automationpractice.com.pages.ProductDetailsPage;
import automationpractice.com.pages.HomePage;
import automationpractice.com.pages.PaymentCheckoutPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class PaymentFeatures {

    private HomePage homePage;
    private ProductDetailsPage productDetailsPage;
    private CheckoutPage checkoutPage;

    private PaymentCheckoutPage paymentCheckoutPage;

    @When("^user select first item from homepage and added it into cart$")
    public void userSelectFirstItemFromHomepageAndAddedItIntoCart() {
        homePage.clickOnNewProductImage();
        productDetailsPage.clickOnAddToCartButton();
        productDetailsPage.clickProceedToCheckoutButton();
    }

    @Then("^payment by wire is made$")
    public void paymentByWireIsMade() {
        Assert.assertTrue(paymentCheckoutPage.isSelectedPayByBankWire());
    }


    @Then("^payment by check is made$")
    public void paymentByCheckIsMade() {
        Assert.assertTrue(paymentCheckoutPage.isSelectedPayByCheck());
    }

    @When("^he return to the payment selection and chooses payment by check$")
    public void heReturnToThePaymentSelectionAndChoosesPaymentByCheck() {
        paymentCheckoutPage.clickOtherPaymentMethods();
        paymentCheckoutPage.clickPayByCheckButton();
    }

    @When("^he return to the payment selection and chooses payment by bank wire$")
    public void heReturnToThePaymentSelectionAndChoosesPaymentByBankWire() {
        paymentCheckoutPage.clickOtherPaymentMethods();
        paymentCheckoutPage.clickPayByBankWireButton();
    }
}
