package automationpractice.com.features.checkout;

import automationpractice.com.pages.*;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class EditBeforeAddToCartFeatures {

    private HomePage homePage;
    private ProductDetailsPage productDetailsPage;
    private MyAccountPage myAccountPage;

    private SummaryCheckoutPage summaryCheckoutPage;

    @When("^user select first item from homepage change quantity used plus and minus button before added to cart$")
    public void userSelectFirstItemFromHomepageChangeQuantityUsedPlusAndMinusButtonBeforeAddedToCart() {
        homePage.clickOnNewProductImage();
        productDetailsPage.clickPlusQuantityButton();
        productDetailsPage.clickPlusQuantityButton();
        productDetailsPage.clickMinusQuantityButton();
        productDetailsPage.clickOnAddToCartButton();
        productDetailsPage.clickProceedToCheckoutButton();
    }

    @Then("^checkout page has two items$")
    public void checkoutPageHasTwoItems() {
        Assert.assertEquals("2", summaryCheckoutPage.isQuantityAfterAddToCartEqualsTwo());
//        I commented before
    }

    @When("^user select first item from homepage and change size$")
    public void userSelectFirstItemFromHomepageAndChangeSize() {
        homePage.clickOnNewProductImage();
        productDetailsPage.changeSize();
//        to with size?
        productDetailsPage.clickOnAddToCartButton();
        productDetailsPage.clickProceedToCheckoutButton();
    }

    @Then("^checkout page has item in L size$")
    public void checkoutPageHasItemInLSize() {
        Assert.assertTrue(summaryCheckoutPage.isSizeL());
//        getSize();
    }

    @When("^user select first item from homepage and change color$")
    public void userSelectFirstItemFromHomepageAndChangeColor() {
        homePage.clickOnNewProductImage();
        productDetailsPage.changeColorToBlue();
        //changeColor("blue");
        productDetailsPage.clickOnAddToCartButton();
        productDetailsPage.clickProceedToCheckoutButton();
    }

    @Then("^checkout page has item in different color$")
    public void checkoutPageHasItemInDifferentColor() {
        Assert.assertTrue(summaryCheckoutPage.isBlueColor());
//        getColor();
    }
}
