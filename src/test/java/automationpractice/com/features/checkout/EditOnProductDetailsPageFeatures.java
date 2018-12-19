package automationpractice.com.features.checkout;

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

public class EditOnProductDetailsPageFeatures {

    private HomePage homePage;
    private ProductDetailsPage productDetailsPage;
    private MyAccountPage myAccountPage;

    private SummaryCheckoutPage summaryCheckoutPage;
    @Steps
    private LoginSteps loginSteps;

    @Given("^logged in customer is on first product details page$")
    public void loggedInCustomerIsOnFirstProductDetailsPage() {
        loginSteps.loginAndMoveIntoMyStorePage();
        homePage.clickOnNewProductImage();
    }

    @When("^user change quantity on product details page$")
    public void userChangeQuantityOnProductDetailsPage() {
        productDetailsPage.clickPlusQuantityButton();
        productDetailsPage.clickPlusQuantityButton();
        productDetailsPage.clickMinusQuantityButton();

    }

    @When("^user add to cart item on product details page$")
    public void userAddToCartItemOnProductDetailsPage() {
        productDetailsPage.clickOnAddToCartButton();
        productDetailsPage.clickProceedToCheckoutButton();
    }

    @Then("^summary checkout page has two items$")
    public void summaryCheckoutPageHasTwoItems() {
        Assert.assertEquals("2", summaryCheckoutPage.isQuantityAfterAddToCartEqualsTwo());
//        I commented before
    }

    @When("^user change size on product details page$")
    public void userChangeSizeOnProductDetailsPage() {
        productDetailsPage.changeSize();
//        to with size?
    }

    @Then("^summary checkout page has item in L size$")
    public void summaryCheckoutPageHasItemInLSize() {
        Assert.assertTrue(summaryCheckoutPage.isSizeL());
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
