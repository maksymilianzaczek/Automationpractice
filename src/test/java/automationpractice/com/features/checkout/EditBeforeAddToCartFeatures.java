package automationpractice.com.features.checkout;

import automationpractice.com.pages.CheckoutPage;
import automationpractice.com.pages.FirstProductPage;
import automationpractice.com.pages.HomePage;
import automationpractice.com.steps.LoginSteps;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

public class EditBeforeAddToCartFeatures {

    private HomePage homePage;
    private FirstProductPage firstProductPage;
    private CheckoutPage checkoutPage;
    @Steps
    private LoginSteps loginSteps;
    //LoginSteps is never used - You can remove it from here


    @When("^user select first item from homepage change quantity used plus and minus button before added to cart$")
    public void userSelectFirstItemFromHomepageChangeQuantityUsedPlusAndMinusButtonBeforeAddedToCart() {
        homePage.clickOnNewProductImage();
        firstProductPage.clickPlusQuantityButton();
        firstProductPage.clickPlusQuantityButton();
        firstProductPage.clickMinusQuantityButton();
        firstProductPage.clickOnAddToCartButton();
        firstProductPage.clickProceedToCheckoutButton();
    }

    @Then("^checkout page has two items$")
    public void checkoutPageHasTwoItems() {
        Assert.assertEquals("2", checkoutPage.isQuantityAfterAddToCartEqualsTwo());
//        I commented before
    }

    @When("^user select first item from homepage and change size$")
    public void userSelectFirstItemFromHomepageAndChangeSize() {
        homePage.clickOnNewProductImage();
        firstProductPage.changeSize();
//        to with size?
        firstProductPage.clickOnAddToCartButton();
        firstProductPage.clickProceedToCheckoutButton();
    }

    @Then("^checkout page has item in L size$")
    public void checkoutPageHasItemInLSize() {
        Assert.assertTrue(checkoutPage.isSizeL());
//        getSize();
    }

    @When("^user select first item from homepage and change color$")
    public void userSelectFirstItemFromHomepageAndChangeColor() {
        homePage.clickOnNewProductImage();
        firstProductPage.changeColorToBlue();
        //changeColor("blue");
        firstProductPage.clickOnAddToCartButton();
        firstProductPage.clickProceedToCheckoutButton();
    }

    @Then("^checkout page has item in different color$")
    public void checkoutPageHasItemInDifferentColor() {
        Assert.assertTrue(checkoutPage.isBlueColor());
//        getColor();
    }
}
