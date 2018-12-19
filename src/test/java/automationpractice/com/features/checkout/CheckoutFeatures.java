package automationpractice.com.features.checkout;

import automationpractice.com.pages.*;
import automationpractice.com.steps.LoginSteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

//try to use assertj, not junit

public class CheckoutFeatures {

    private HomePage homePage;
    private MyAccountPage myAccountPage;
    private ProductDetailsPage productDetailsPage;
    private SummaryCheckoutPage summaryCheckoutPage;
    private AddressCheckoutPage addressCheckoutPage;
    private ShippingCheckoutPage shippingCheckoutPage;
    private PaymentCheckoutPage paymentCheckoutPage;
    private OrderHistoryAndDetailsPage orderHistoryAndDetailsPage;

    @Steps
    private LoginSteps loginSteps;

    @Given("^logged customer is on home page$")
    public void loggedCustomerIsOnHomePage() {
        homePage.open();
        loginSteps.login();
        myAccountPage.clickMyStore();
//        We have something like headerBox. I think this method should be there
    }

    @Given("^logged customer is on home page and user select first item from homepage and added it into cart$")
    public void loggedCustomerIsOnHomePageAndUserSelectFirstItemFromHomepageAndAddedItIntoCart() {
        homePage.open();
        loginSteps.login();
        myAccountPage.clickMyStore();
//        that 3 lines are in previous step. You could create private method for that here, or you can create it in loginSteps
        homePage.clickOnNewProductImage();
/*      It will be better if you take list of products here, and after that you click first:
        productTitle = homePage.getProductsTitles().get(0);
        homePage.clickOnProduct(productTitle);        */
        productDetailsPage.clickOnAddToCartButton();
        productDetailsPage.clickProceedToCheckoutButton();
//        That shouldn't be on productPage. Create CartBox or something like that
    }

    @When("^user change quantity used plus and minus button after added to cart$")
    public void userChangeQuantityUsedPlusAndMinusButtonAfterAddedToCart() {
        summaryCheckoutPage.clickPlusQuantityButtonInSummaryLabel();
        summaryCheckoutPage.clickPlusQuantityButtonInSummaryLabel();
        summaryCheckoutPage.clickPlusQuantityButtonInSummaryLabel();
        summaryCheckoutPage.clickPlusQuantityButtonInSummaryLabel();
        summaryCheckoutPage.clickPlusQuantityButtonInSummaryLabel();
        summaryCheckoutPage.clickPlusQuantityButtonInSummaryLabel();
        summaryCheckoutPage.clickMinusQuantityButtonInSummaryLabel();
        summaryCheckoutPage.clickMinusQuantityButtonInSummaryLabel();
        summaryCheckoutPage.clickMinusQuantityButtonInSummaryLabel();
        summaryCheckoutPage.clickPlusQuantityButtonInSummaryLabel();
        summaryCheckoutPage.clickMinusQuantityButtonInSummaryLabel();
        summaryCheckoutPage.clickPlusQuantityButtonInSummaryLabel();
        summaryCheckoutPage.clickMinusQuantityButtonInSummaryLabel();
        summaryCheckoutPage.clickMinusQuantityButtonInSummaryLabel();
//        Too much.
    }

    @Then("^checkout page has three items$")
    public void checkoutPageHasThreeItems() {
        Assert.assertEquals("3", summaryCheckoutPage.isQuantityAfterAddToCartEqualsThree());
//        Here it should be checkoutPage.getProductQuantity(productTitle);
//        Also I don't like that hardcoded three - if you remove one line from previous step test will fail
    }

    @When("^he confirms every step up to the tab shipping and he do not click agree checkbox in shipping label and click proceed to checkout$")
    public void heConfirmsEveryStepUpToTheTabShippingAndHeDoNotClickAgreeCheckboxInShippingLabelAndClickProceedToCheckout() {
        summaryCheckoutPage.clickOnProceedToCheckoutButtonInSummaryLabel();
        addressCheckoutPage.clickOnProceedToCheckoutButtonInAddressLabel();
        shippingCheckoutPage.clickOnProceedToCheckoutButtonInShippingLabel();
    }

    @Then("^new alert is appear$")
    public void newAlertIsAppear() {
        Assert.assertTrue(shippingCheckoutPage.newAlertAppear());
//        isAlertDisplayed() (why new?)
    }

    @When("^new alert is appear and user close it and click agree checkbox and continue$")
    public void newAlertIsAppearAndUserCloseItAndClickAgreeCheckboxAndContinue() {
        shippingCheckoutPage.closeAlertInShippingLabel();
        shippingCheckoutPage.clickAgreeCheckbox();
        shippingCheckoutPage.clickOnProceedToCheckoutButtonInShippingLabel();
    }

    @Then("^user is in payment label$")
    public void userIsInPaymentLabel() {
        Assert.assertTrue(paymentCheckoutPage.isPaymentLabel());
//        is payment label what?
    }

    @When("^user confirms every step up to the tab address and type a comment$")
    public void userConfirmsEveryStepUpToTheTabAddressAndTypeAComment() {
        summaryCheckoutPage.clickOnProceedToCheckoutButtonInSummaryLabel();
        addressCheckoutPage.addCommentInAddressTab();
    }

    @When("^user confirms every step from tab address to confirms order$")
    public void userConfirmsEveryStepFromTabAddressToConfirmsOrder() {
        addressCheckoutPage.clickOnProceedToCheckoutButtonInAddressLabel();
        shippingCheckoutPage.clickAgreeCheckbox();
        shippingCheckoutPage.clickOnProceedToCheckoutButtonInShippingLabel();
        paymentCheckoutPage.clickPayByBankWireButton();
        paymentCheckoutPage.clickIConfirmMyOrder();
        paymentCheckoutPage.clickBackToOrdersButtonInPaymentTab();
        orderHistoryAndDetailsPage.clickDetailsButtonForLastOneOrders();
    }

    @Then("^is comment about address in last one orders$")
    public void isCommentAboutAddressInLastOneOrders() {
        Assert.assertTrue(orderHistoryAndDetailsPage.isCommentAboutAddressInLastOneOrders());
//        isCommentAboutAddressInLastOneOrders what? exist, displayed, invisible?
    }
}
