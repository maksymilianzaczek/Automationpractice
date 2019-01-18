package automationpractice.com.features.productDetails;

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

    @Given("^logged in customer is on product details page$")
    public void loggedInCustomerIsOnProductDetailsPage() {
        loginSteps.loginAndMoveIntoMyStorePage();
        homePage.clickOnSelectedProductImage(0);
    }

    @When("^user add to cart item on product details page$")
    public void userAddToCartItemOnProductDetailsPage() {
        productDetailsPage.clickOnAddToCartButton();
        productDetailsPage.clickProceedToCheckoutButton();
    }

    @When("^user change quantity on product details page$")
    public void userChangeQuantityOnProductDetailsPage() {
        productDetailsPage.clickPlusAndMinusButtonGivenNumberOfTimes(2,1);
        productDetailsPage.setCurrentQuantity(productDetailsPage.getQuantityOfItem());
    }

    @Then("^summary checkout page has a given number of items in product details page$")
    public void summaryCheckoutPageHasAGivenNumberOfItemsInProductDetailsPage() {
        assertThat(summaryCheckoutPage.getCurrentQuantity()).isEqualTo(productDetailsPage.getCurrentQuantity());
    }

    @When("^user change size to (.*) size on product details page$")
    public String userChangeSizeOnProductDetailsPage(final String size) {
        return productDetailsPage.changeSizeToGivenSize(size);
    }

    @Then("^summary checkout page has item in given size$")
    public void summaryCheckoutPageHasItemInGivenSize() {
        assertThat(summaryCheckoutPage.getGivenSize()).isEqualTo(productDetailsPage.getCurrentSize());
    }

    @When("^user change color to (.*) on product details page$")
    public String userChangeColorOnProductDetailsPage(final String color) {
        return productDetailsPage.changeColorToGivenColor(color);
    }

    @Then("^summary checkout page has item in given color$")
    public void summaryCheckoutPageHasItemInGivenColor() {
        assertThat(summaryCheckoutPage.getGivenColor()).isEqualTo(productDetailsPage.getCurrentColor());
    }
}
