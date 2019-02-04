package automationpractice.com.features.edit;

import automationpractice.com.exceptions.NoProductsOnHomePageException;
import automationpractice.com.pages.HomePage;
import automationpractice.com.pages.PaymentCheckoutPage;
import automationpractice.com.pages.ProductDetailsPage;
import automationpractice.com.pages.SummaryCheckoutPage;
import automationpractice.com.steps.LoginSteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

import static org.assertj.core.api.Assertions.assertThat;

public class EditFeatures {

    private HomePage homePage;
    private ProductDetailsPage productDetailsPage;
    private SummaryCheckoutPage summaryCheckoutPage;
    private PaymentCheckoutPage paymentCheckoutPage;
    @Steps
    private LoginSteps loginSteps;
    private int quantityInProductDetailsPage;

    @Given("^logged in customer is on product details page$")
    public void loggedInCustomerIsOnProductDetailsPage() {
        loginSteps.loginAndMoveIntoMyStorePage();
        final String productName = homePage.getListOfProducts().stream().findAny()
            .orElseThrow(() -> new NoProductsOnHomePageException("List of product in home page is empty")).getText();
        homePage.clickOnSelectedProductImage(productName);
    }

    @When("^user add to cart item on product details page$")
    public void userAddToCartItemOnProductDetailsPage() {
        productDetailsPage.clickOnAddToCartButton();
        productDetailsPage.clickProceedToCheckoutButton();
    }

    @When("^user change quantity on product details page$")
    public void userChangeQuantityOnProductDetailsPage() {
        productDetailsPage.clickPlusAndMinusButtonGivenNumberOfTimes(2, 1);
        quantityInProductDetailsPage = productDetailsPage.getQuantityOfItem();
    }

    @Then("^summary checkout page has a given number of items in product details page$")
    public void summaryCheckoutPageHasAGivenNumberOfItemsInProductDetailsPage() {
        assertThat(summaryCheckoutPage.getCurrentQuantity()).isEqualTo(quantityInProductDetailsPage);
    }

    @When("^user change size to (.*) size on product details page$")
    public void userChangeSizeOnProductDetailsPage(final String size) {
        productDetailsPage.changeSizeToGivenSize(size);
    }

    @Then("^summary checkout page has item in given size$")
    public void summaryCheckoutPageHasItemInGivenSize() {
        assertThat(summaryCheckoutPage.getGivenSize()).isEqualTo(productDetailsPage.getCurrentSize());
    }

    @When("^user change color to (.*) on product details page$")
    public void userChangeColorOnProductDetailsPage(final String color) {
        productDetailsPage.changeColorToGivenColor(color);
    }

    @Then("^summary checkout page has item in given color in product details page$")
    public void summaryCheckoutPageHasItemInGivenColor() {
        assertThat(summaryCheckoutPage.getGivenColor()).isEqualTo(productDetailsPage.getCurrentColor());
    }
}
