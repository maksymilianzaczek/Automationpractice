package automationpractice.com.features.checkout;

import automationpractice.com.pages.*;
import automationpractice.com.steps.LoginSteps;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

public class PaymentFeatures {

    private HomePage homePage;
    private FirstProductPage firstProductPage;
    private CheckoutPage checkoutPage;
    @Steps
    private LoginSteps loginSteps;

    @When("^user select first item from homepage and added it into cart$")
    public void userSelectFirstItemFromHomepageAndAddedItIntoCart() {
        homePage.clickOnNewProductImage();
        firstProductPage.clickOnAddToCartButton();
        firstProductPage.clickProceedToCheckoutButton();
    }

    @Then("^payment by wire is made$")
    public void paymentByWireIsMade() {
        Assert.assertTrue(checkoutPage.isSelectedPayByBankWire());
    }


    @Then("^payment by check is made$")
    public void paymentByCheckIsMade() {
        Assert.assertTrue(checkoutPage.isSelectedPayByCheck());
    }

    @When("^he return to the payment selection and chooses payment by check$")
    public void heReturnToThePaymentSelectionAndChoosesPaymentByCheck() {
        checkoutPage.clickOtherPaymentMethods();
        checkoutPage.clickPayByCheckButton();
    }

    @When("^he return to the payment selection and chooses payment by bank wire$")
    public void heReturnToThePaymentSelectionAndChoosesPaymentByBankWire() {
        checkoutPage.clickOtherPaymentMethods();
        checkoutPage.clickPayByBankWireButton();
    }
}
