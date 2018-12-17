package automationpractice.com.features.checkout;

import automationpractice.com.steps.LoginSteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

import automationpractice.com.pages.*;

public class CheckoutFeatures {

    private HomePage homePage;
    private MyAccountPage myAccountPage;
    private FirstProductPage firstProductPage;
    private CheckoutPage checkoutPage;
    @Steps
    private LoginSteps loginSteps;

    @Given("^logged customer is on home page$")
    public void loggedCustomerIsOnHomePage() {
        homePage.open();
        loginSteps.login();
        myAccountPage.clickMyStore();
    }

    @Given("^logged customer is on home page and user select first item from homepage and added it into cart$")
    public void loggedCustomerIsOnHomePageAndUserSelectFirstItemFromHomepageAndAddedItIntoCart() {
        homePage.open();
        loginSteps.login();
        myAccountPage.clickMyStore();
        homePage.clickOnNewProductImage();
        firstProductPage.clickOnAddToCartButton();
        firstProductPage.clickProceedToCheckoutButton();
    }

    @When("^user change quantity used plus and minus button after added to cart$")
    public void userChangeQuantityUsedPlusAndMinusButtonAfterAddedToCart() {
        checkoutPage.clickPlusQuantityButtonInSummaryLabel();
        checkoutPage.clickPlusQuantityButtonInSummaryLabel();
        checkoutPage.clickPlusQuantityButtonInSummaryLabel();
        checkoutPage.clickPlusQuantityButtonInSummaryLabel();
        checkoutPage.clickPlusQuantityButtonInSummaryLabel();
        checkoutPage.clickPlusQuantityButtonInSummaryLabel();
        checkoutPage.clickMinusQuantityButtonInSummaryLabel();
        checkoutPage.clickMinusQuantityButtonInSummaryLabel();
        checkoutPage.clickMinusQuantityButtonInSummaryLabel();
        checkoutPage.clickPlusQuantityButtonInSummaryLabel();
        checkoutPage.clickMinusQuantityButtonInSummaryLabel();
        checkoutPage.clickPlusQuantityButtonInSummaryLabel();
        checkoutPage.clickMinusQuantityButtonInSummaryLabel();
        checkoutPage.clickMinusQuantityButtonInSummaryLabel();
    }

    @Then("^checkout page has three items$")
    public void checkoutPageHasThreeItems() {
        Assert.assertEquals("3", checkoutPage.isQuantityAfterAddToCartEqualsThree());
    }

    @When("^he confirms every step up to the tab shipping and he do not click agree checkbox in shipping label and click proceed to checkout$")
    public void heConfirmsEveryStepUpToTheTabShippingAndHeDoNotClickAgreeCheckboxInShippingLabelAndClickProceedToCheckout() {
        checkoutPage.clickOnProceedToCheckoutButtonInSummaryLabel();
        checkoutPage.clickOnProceedToCheckoutButtonInAddressLabel();
        checkoutPage.clickOnProceedToCheckoutButtonInShippingLabel();
    }

    @Then("^new alert is appear$")
    public void newAlertIsAppear() {
        Assert.assertTrue(checkoutPage.newAlertAppear());
    }

    @When("^new alert is appear and user close it and click agree checkbox and continue$")
    public void newAlertIsAppearAndUserCloseItAndClickAgreeCheckboxAndContinue() {
        checkoutPage.closeAlertInShippingLabel();
        checkoutPage.clickAgreeCheckbox();
        checkoutPage.clickOnProceedToCheckoutButtonInShippingLabel();
    }

    @Then("^user is in payment label$")
    public void userIsInPaymentLabel() {
        Assert.assertTrue(checkoutPage.isPaymentLabel());
    }

    @When("^user confirms every step up to the tab address and type a comment$")
    public void userConfirmsEveryStepUpToTheTabAddressAndTypeAComment() {
        checkoutPage.clickOnProceedToCheckoutButtonInSummaryLabel();
        checkoutPage.addCommentInAddressTab();
    }

    @When("^user confirms every step from tab address to confirms order$")
    public void userConfirmsEveryStepFromTabAddressToConfirmsOrder() {
        checkoutPage.clickOnProceedToCheckoutButtonInAddressLabel();
        checkoutPage.clickAgreeCheckbox();
        checkoutPage.clickOnProceedToCheckoutButtonInShippingLabel();
        checkoutPage.clickPayByBankWireButton();
        checkoutPage.clickIConfirmMyOrder();
        checkoutPage.clickBackToOrdersButtonInPaymentTab();
        checkoutPage.clickDetailsButtonForLastOneOrders();
    }

    @Then("^is comment about address in last one orders$")
    public void isCommentAboutAddressInLastOneOrders() {
        Assert.assertTrue(checkoutPage.isCommentAboutAddressInLastOneOrders());
    }
}
