package automationpractice.com.features.productDetails;

import automationpractice.com.pages.HomePage;
import automationpractice.com.pages.MyAccountPage;
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
    private MyAccountPage myAccountPage;
    private SummaryCheckoutPage summaryCheckoutPage;
    @Steps
    private LoginSteps loginSteps;

    @Given("^logged in customer is on product details page$")
    public void loggedInCustomerIsOnProductDetailsPage() {
        loginSteps.loginAndMoveIntoMyStorePage();
        homePage.clickOnFirstProductImage();
    }

    @When("^user add to cart item on product details page$")
    public void userAddToCartItemOnProductDetailsPage() {
        productDetailsPage.clickOnAddToCartButton();
        productDetailsPage.clickProceedToCheckoutButton();
    }

    @When("^user change quantity on product details page$")
    public int userChangeQuantityOnProductDetailsPage() {
        return productDetailsPage.clickPlusAndMinusButtonGivenNumberOfTimes(2,1);
    }

    @Then("^summary checkout page has a given number of items in product details page$")
    public void summaryCheckoutPageHasAGivenNumberOfItemsInProductDetailsPage() {
        assertThat(summaryCheckoutPage.getFirstProductQuantity()).isEqualTo(productDetailsPage.getCurrentQuantity());
    }

    @When("^user change size to S size on product details page$")
    public String userChangeSizeToSSizeOnProductDetailsPage() {
        return productDetailsPage.changeSizeToGivenSize("S");
    }

    @When("^user change size to M size on product details page$")
    public String userChangeSizeToMSizeOnProductDetailsPage() {
        return productDetailsPage.changeSizeToGivenSize("M");
    }

    @When("^user change size to L size on product details page$")
    public String userChangeSizeToLSizeOnProductDetailsPage() {
        return productDetailsPage.changeSizeToGivenSize("L");
    }

    @Then("^summary checkout page has item in given size$")
    public void summaryCheckoutPageHasItemInGivenSize() {
        assertThat(summaryCheckoutPage.getGivenSize()).isEqualTo(productDetailsPage.getCurrentSize());
    }

    @When("^user change color to blue on product details page$")
    public String userChangeColorToBlueOnProductDetailsPage() {
        return productDetailsPage.changeColorToGivenColor("Blue");
    }

    @Then("^summary checkout page has item in given color$")
    public void summaryCheckoutPageHasItemInGivenColor() {
        assertThat(summaryCheckoutPage.getGivenColor()).isEqualTo(productDetailsPage.getCurrentColor());
    }

}
