package automationpractice.com.features.checkout;

import automationpractice.com.pages.CheckoutPage;
import automationpractice.com.pages.FirstProductPage;
import automationpractice.com.pages.HomePage;
import automationpractice.com.pages.MyAccountPage;
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
    private FirstProductPage firstProductPage;

    //    Why it is firstProductPage? It can't be ProductDetailsPage?
    private CheckoutPage checkoutPage;

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
        firstProductPage.clickOnAddToCartButton();
        firstProductPage.clickProceedToCheckoutButton();
//        That shouldn't be on productPage. Create CartBox or something like that
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
//        Too much.
    }

    @Then("^checkout page has three items$")
    public void checkoutPageHasThreeItems() {
        Assert.assertEquals("3", checkoutPage.isQuantityAfterAddToCartEqualsThree());
//        Here it should be checkoutPage.getProductQuantity(productTitle);
//        Also I don't like that hardcoded three - if you remove one line from previous step test will fail
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
//        isAlertDisplayed() (why new?)
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
//        is payment label what?
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
//        isCommentAboutAddressInLastOneOrders what? exist, displayed, invisible?
    }
}
