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
import org.junit.Assert;

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
        homePage.clickOnNewProductImage();
    }

    @When("^user add to cart item on product details page$")
    public void userAddToCartItemOnProductDetailsPage() {
        productDetailsPage.clickOnAddToCartButton();
        productDetailsPage.clickProceedToCheckoutButton();
    }

    @When("^user change quantity on product details page$")
    public int userChangeQuantityOnProductDetailsPage() {
        return productDetailsPage.clickPlusAndMinusButtonGivenNumberOfTimesOnDetailsPage(2,1);
    }

    @Then("^summary checkout page has a given number of items in product details page$")
    public void summaryCheckoutPageHasAGivenNumberOfItemsInProductDetailsPage() {
        assertThat(summaryCheckoutPage.getFirstProductQuantityInSummaryCheckoutPage()).isEqualTo(String.valueOf(userChangeQuantityOnProductDetailsPage()));
    }

    @When("^user change size to given size on product details page$")
    public String userChangeSizeToGivenSizeOnProductDetailsPage() {
        return productDetailsPage.changeSizeToGivenSize("L");
    }

    @Then("^summary checkout page has item in given size$")
    public void summaryCheckoutPageHasItemInGivenSize() {
        assertThat(summaryCheckoutPage.getGivenSize()).isEqualTo(productDetailsPage.getCurrentSizeSetUpInProductDetailsPage());
    }

    @When("^user change size to M size on product details page$")
    public void userChangeSizeToMSizeOnProductDetailsPage() {
        productDetailsPage.changeSizeToMSize();
    }

    @Then("^summary checkout page has item in M size$")
    public void summaryCheckoutPageHasItemInMSize() {
        Assert.assertTrue(summaryCheckoutPage.isSizeM());
//        getSize();
    }



    @When("^user change color on product details page$")
    public void userChangeColorOnProductDetailsPage() {
        productDetailsPage.changeColorToBlue();
        //changeColor("blue");
    }

    @Then("^summary checkout page has item in different color$")
    public void summaryCheckoutPageHasItemInDifferentColor() {
        Assert.assertTrue(summaryCheckoutPage.isBlueColor());
//        getColor();
    }



}
