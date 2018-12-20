package automationpractice.com.features.checkout;

import automationpractice.com.pages.*;
import automationpractice.com.steps.LoginSteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

import static org.assertj.core.api.Assertions.assertThat;

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

    @When("^user change quantity on summary checkout page$")
    public int userChangeQuantityOnSummaryCheckoutPage() {
        int quantityOfItems = 1;

        summaryCheckoutPage.clickPlusQuantityButtonInSummaryLabel();
        quantityOfItems++;
        summaryCheckoutPage.clickPlusQuantityButtonInSummaryLabel();
        quantityOfItems++;

        summaryCheckoutPage.clickPlusQuantityButtonInSummaryLabel();
        quantityOfItems++;

        summaryCheckoutPage.clickPlusQuantityButtonInSummaryLabel();
        quantityOfItems++;

        summaryCheckoutPage.clickPlusQuantityButtonInSummaryLabel();
        quantityOfItems++;

        summaryCheckoutPage.clickPlusQuantityButtonInSummaryLabel();
        quantityOfItems++;

        summaryCheckoutPage.clickMinusQuantityButtonInSummaryLabel();
        quantityOfItems--;

        summaryCheckoutPage.clickMinusQuantityButtonInSummaryLabel();
        quantityOfItems--;
        summaryCheckoutPage.clickMinusQuantityButtonInSummaryLabel();
        quantityOfItems--;

        summaryCheckoutPage.clickPlusQuantityButtonInSummaryLabel();
        quantityOfItems++;

        summaryCheckoutPage.clickMinusQuantityButtonInSummaryLabel();
        quantityOfItems--;

        summaryCheckoutPage.clickPlusQuantityButtonInSummaryLabel();
        quantityOfItems++;

        summaryCheckoutPage.clickMinusQuantityButtonInSummaryLabel();
        quantityOfItems--;
        summaryCheckoutPage.clickMinusQuantityButtonInSummaryLabel();
        quantityOfItems--;
//        Too much.
        //do skrócenia
        return quantityOfItems;
    }

    @Then("^summary checkout page has a given number of items in summary checkout page$")
    public void summaryCheckoutPageHasAGivenNumberOfItemsInSummaryCheckoutPage() {
        assertThat(summaryCheckoutPage.getFirstProductQuantityInSummaryCheckoutPage()).isEqualTo(String.valueOf(userChangeQuantityOnSummaryCheckoutPage()));
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
