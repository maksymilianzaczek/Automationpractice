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
        loginSteps.loginAndMoveIntoMyStorePage();
    }

//    @Given("^logged customer is on home page and user select first item from homepage and added it into cart$")
//    public void loggedCustomerIsOnHomePageAndUserSelectFirstItemFromHomepageAndAddedItIntoCart() {
//        homePage.open();
//        loginSteps.login();
//        myAccountPage.clickMyStore();
////        that 3 lines are in previous step. You could create private method for that here, or you can create it in loginSteps
//        homePage.clickOnNewProductImage();
///*      It will be better if you take list of products here, and after that you click first:
//        productTitle = homePage.getProductsTitles().get(0);
//        homePage.clickOnProduct(productTitle);        */
//        productDetailsPage.clickOnAddToCartButton();
//        productDetailsPage.clickProceedToCheckoutButton();
////        That shouldn't be on productPage. Create CartBox or something like that
//    }


//    @When("^he confirms every step up to the tab shipping and he do not click agree checkbox in shipping label and click proceed to checkout$")
//    public void heConfirmsEveryStepUpToTheTabShippingAndHeDoNotClickAgreeCheckboxInShippingLabelAndClickProceedToCheckout() {
//        summaryCheckoutPage.clickOnProceedToCheckoutButtonInSummaryLabel();
//        addressCheckoutPage.clickOnProceedToCheckoutButtonInAddressLabel();
//        shippingCheckoutPage.clickOnProceedToCheckoutButtonInShippingLabel();
//    }

//    @When("^user confirms every step up to the tab address and type a comment$")
//    public void userConfirmsEveryStepUpToTheTabAddressAndTypeAComment() {
//        summaryCheckoutPage.clickOnProceedToCheckoutButtonInSummaryLabel();
//        addressCheckoutPage.addCommentInAddressTab();
//    }


    @Given("^user add first item into cart$")
    public void userAddFirstItemIntoCart() {
        loginSteps.loginAndMoveIntoMyStorePage();
//        that 3 lines are in previous step. You could create private method for that here, or you can create it in loginSteps

        homePage.clickOnNewProductImage();
/*      It will be better if you take list of products here, and after that you click first:
        productTitle = homePage.getProductsTitles().get(0);
        homePage.clickOnProduct(productTitle);        */
        productDetailsPage.clickOnAddToCartButton();
        productDetailsPage.clickProceedToCheckoutButton();
//        That shouldn't be on productPage. Create CartBox or something like that
    }

    @When("^user change quantity in summary checkout page$")
    public void userChangeQuantityInSummaryCheckoutPage() {
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

    @Then("^summary checkout page has three items$")
    public void summaryCheckoutPageHasThreeItems() {
        Assert.assertEquals("3", summaryCheckoutPage.isQuantityAfterAddToCartEqualsThree());
//        Here it should be checkoutPage.getProductQuantity(productTitle);
//        Also I don't like that hardcoded three - if you remove one line from previous step test will fail
    }

    @When("^user click proceed to checkout in summary address and shipping tab$")
    public void userClickProceedToCheckoutInSummaryAddressAndShippingTab() {
        summaryCheckoutPage.clickOnProceedToCheckoutButtonInSummaryLabel();
        addressCheckoutPage.clickOnProceedToCheckoutButtonInAddressLabel();
        shippingCheckoutPage.clickOnProceedToCheckoutButtonInShippingLabel();
    }

    @Then("^alert is displayed in shipping checkout page$")
    public void alertIsDisplayedInShippingCheckoutPage() {
        Assert.assertTrue(shippingCheckoutPage.isAlertDisplayedInShippingCheckoutPage());
    }


    @When("^user click agree checkbox and click proceed to checkout$")
    public void userClickAgreeCheckboxAndClickProceedToCheckout() {
        shippingCheckoutPage.closeAlertInShippingLabel();
        shippingCheckoutPage.clickAgreeCheckbox();
        shippingCheckoutPage.clickOnProceedToCheckoutButtonInShippingLabel();
    }

    @Then("^user is in payment checkout tab$")
    public void userIsInPaymentCheckoutTab() {
        Assert.assertTrue(paymentCheckoutPage.isUserIsInPaymentCheckoutTab());
    }

    @When("^user click proceed to checkout in summary tab$")
    public void userClickProceedToCheckoutInSummaryTab() {
        summaryCheckoutPage.clickOnProceedToCheckoutButtonInSummaryLabel();
    }

    @When("^user type a comment about order in address checkout page$")
    public void userTypeACommentAboutOrderInAddressCheckoutPage() {
        addressCheckoutPage.addCommentInAddressTab();
    }

    @When("^user confirms every step from address checkout page up to back to orders button in payment checkout page$")
    public void useConfirmsEveryStepFromAddressCheckoutPageUpToBackToOrdersButtonInPaymentCheckoutPage() {
        addressCheckoutPage.clickOnProceedToCheckoutButtonInAddressLabel();
        shippingCheckoutPage.clickAgreeCheckbox();
        shippingCheckoutPage.clickOnProceedToCheckoutButtonInShippingLabel();
        paymentCheckoutPage.clickPayByBankWireButton();
        paymentCheckoutPage.clickIConfirmMyOrder();
        paymentCheckoutPage.clickBackToOrdersButtonInPaymentTab();
        orderHistoryAndDetailsPage.clickDetailsButtonForLastOneOrders();
    }

    @Then("^comment about address is displayed in last one orders$")
    public void commentAboutAddressIsDisplayedInLastOneOrders() {
        Assert.assertTrue(orderHistoryAndDetailsPage.isCommentAboutAddressInLastOneOrdersVisible());
    }

}
