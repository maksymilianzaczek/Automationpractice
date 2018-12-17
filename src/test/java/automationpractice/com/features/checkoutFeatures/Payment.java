package automationpractice.com.features.checkoutFeatures;

import automationpractice.com.features.AddressFeatures;
import automationpractice.com.pages.*;
import automationpractice.com.steps.LoginSteps;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

public class Payment {

    private HomePage homePage;
    private HeaderBox headerBox;
    private LoginPage loginPage;
    private MyAccountPage myAccountPage;
    private FirstProductPage firstProductPage;
    private CheckoutPage checkoutPage;
    private AddressFeatures addressFeatures;
    @Steps
    private LoginSteps loginSteps;


    @When("^user select first item from homepage and added it into cart$")
    public void userSelectFirstItemFromHomepageAndAddedItIntoCart() {
        homePage.clickOnNewProductImage();
        firstProductPage.clickOnAddToCartButton();
        firstProductPage.clickProceedToCheckoutButton();
    }

    @When("^he confirms every step to make order and pay by bank wire$")
    public void heConfirmsEveryStepToMakeOrderAndPayByBankWire() {
        checkoutPage.clickOnProceedToCheckoutButtonInSummaryLabel();
        checkoutPage.clickOnProceedToCheckoutButtonInAddressLabel();
        checkoutPage.clickAgreeCheckbox();
        checkoutPage.clickOnProceedToCheckoutButtonInShippingLabel();
        checkoutPage.clickPayByBankWireButton();
    }

    @Then("^payment by wire is made$")
    public void paymentByWireIsMade() {
        Assert.assertTrue(checkoutPage.isSelectedPayByBankWire());
    }

    @When("^he confirms every step to make order and pay by check$")
    public void heConfirmsEveryStepToMakeOrderAndPayByCheck() {
        checkoutPage.clickOnProceedToCheckoutButtonInSummaryLabel();
        checkoutPage.clickOnProceedToCheckoutButtonInAddressLabel();
        checkoutPage.clickAgreeCheckbox();
        checkoutPage.clickOnProceedToCheckoutButtonInShippingLabel();
        checkoutPage.clickPayByCheckButton();
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
