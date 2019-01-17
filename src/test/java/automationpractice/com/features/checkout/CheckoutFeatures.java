package automationpractice.com.features.checkout;

import automationpractice.com.pages.*;
import automationpractice.com.steps.LoginSteps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

import static org.assertj.core.api.Assertions.assertThat;

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
        homePage.clickOnSelectedProductImage(0);
        productDetailsPage.clickOnAddToCartButton();
        productDetailsPage.clickProceedToCheckoutButton();
    }
    @When("^user change quantity on summary checkout page$")
    public void userChangeQuantityOnSummaryCheckoutPage() {
        summaryCheckoutPage.clickPlusAndMinusButtonGivenNumberOfTimes(4,3);
        summaryCheckoutPage.setQuantity(summaryCheckoutPage.getCurrentQuantity());
    }

    @And("^user confirms every step from summary checkout page up to payment checkout page$")
    public void userConfirmsEveryStepFromSummaryCheckoutPageUpToPaymentCheckoutPage() {
        summaryCheckoutPage.clickOnProceedToCheckoutButton();
        addressCheckoutPage.clickOnProceedToCheckoutButton();
        shippingCheckoutPage.clickAgreeCheckbox();
        shippingCheckoutPage.clickOnProceedToCheckoutButton();
        paymentCheckoutPage.setQuantity(paymentCheckoutPage.getCurrentQuantity());
    }

    @Then("^summary checkout page has a given number of items in summary checkout page$")
    public void summaryCheckoutPageHasAGivenNumberOfItemsInSummaryCheckoutPage() {
        assertThat(paymentCheckoutPage.getQuantity()).isEqualTo(summaryCheckoutPage.getQuantity());
    }

    @When("^user click proceed to checkout in summary address and shipping tab$")
    public void userClickProceedToCheckoutInSummaryAddressAndShippingTab() {
        summaryCheckoutPage.clickOnProceedToCheckoutButton();
        addressCheckoutPage.clickOnProceedToCheckoutButton();
        shippingCheckoutPage.clickOnProceedToCheckoutButton();
    }

    @Then("^alert is displayed in shipping checkout page$")
    public void alertIsDisplayedInShippingCheckoutPage() {
        assertThat(shippingCheckoutPage.isAlertDisplayed()).isTrue();
    }

    @When("^user exit alert click agree checkbox and click proceed to checkout$")
    public void userExitAlertClickAgreeCheckboxAndClickProceedToCheckout() {
        shippingCheckoutPage.closeAlert();
        shippingCheckoutPage.clickAgreeCheckbox();
        shippingCheckoutPage.clickOnProceedToCheckoutButton();
    }

    @Then("^user is in payment checkout tab$")
    public void userIsInPaymentCheckoutTab() {
        assertThat(paymentCheckoutPage.labelInPaymentCheckoutTab().contains("PLEASE CHOOSE YOUR PAYMENT METHOD")).isTrue();
    }

    @When("^user click proceed to checkout in summary tab$")
    public void userClickProceedToCheckoutInSummaryTab() {
        summaryCheckoutPage.clickOnProceedToCheckoutButton();
    }

    @When("^user type a comment entrance from the yard in address checkout page$")
    public void userTypeACommentEntranceFromTheYardInAddressCheckoutPage() {
        addressCheckoutPage.addCommentEntranceFromTheYard();
    }

    @When("^user confirms every step from address checkout page up to back to orders button in payment checkout page$")
    public void useConfirmsEveryStepFromAddressCheckoutPageUpToBackToOrdersButtonInPaymentCheckoutPage() {
        addressCheckoutPage.clickOnProceedToCheckoutButton();
        shippingCheckoutPage.clickAgreeCheckbox();
        shippingCheckoutPage.clickOnProceedToCheckoutButton();
        paymentCheckoutPage.clickPayByBankWireButton();
        paymentCheckoutPage.clickIConfirmMyOrderButton();
        paymentCheckoutPage.clickBackToOrdersButtonInPaymentTab();
        orderHistoryAndDetailsPage.clickDetailsButtonForLastOneOrders();
    }

    @Then("^comment about address is displayed in last one orders$")
    public void commentAboutAddressIsDisplayedInLastOneOrders() {
        assertThat(orderHistoryAndDetailsPage.isCommentAboutAddressInLastOneOrdersVisible()).isTrue();
    }

}
