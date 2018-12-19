package automationpractice.com.features;

import automationpractice.com.pages.ProductDetailsPage;
import automationpractice.com.pages.HomePage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class SocialMediaFeatures {

    private HomePage homePage;
    private ProductDetailsPage productDetailsPage;

    @When("^user select first item from homepage and chose twitter$")
    public void userSelectFirstItemFromHomepageAndChoseTwitter() {
        homePage.clickOnNewProductImage();
        productDetailsPage.clickOnTwitterButton();
        productDetailsPage.checkoutToTweeterWindow();
    }

    @Then("^new page in twitter domain is open$")
    public void newPageInTwitterDomainIsOpen() {
        Assert.assertTrue(productDetailsPage.isTwitterDomainDisplayed());
//        is twitter domain what?
    }

    @When("^user select first item from homepage and chose facebook$")
    public void userSelectFirstItemFromHomepageAndChoseFacebook() {
        homePage.clickOnNewProductImage();
        productDetailsPage.clickOnFacebookButton();
        productDetailsPage.checkoutToFacebookWindow();
    }

    @Then("^new page in facebook domain is open$")
    public void newPageInFacebookDomainIsOpen() {
        Assert.assertTrue(productDetailsPage.isFacebookDomainDisplayed());
    }

    @When("^user select first item from homepage and chose google plus$")
    public void userSelectFirstItemFromHomepageAndChoseGooglePlus() {
        homePage.clickOnNewProductImage();
        productDetailsPage.clickOnGooglePlusButton();
        productDetailsPage.checkoutToGooglePlusWindow();
    }

    @Then("^new page in google plus domain is open$")
    public void newPageInPDomainIsOpen() {
        Assert.assertTrue(productDetailsPage.isGooglePlusDomainDisplayed());
    }

    @When("^user select first item from homepage and chose pinterest$")
    public void userSelectFirstItemFromHomepageAndChosePinterest() {
        homePage.clickOnNewProductImage();
        productDetailsPage.clickOnPinterestButton();
        productDetailsPage.checkoutToPinterestWindow();
    }

    @Then("^new page in pinterest domain is open$")
    public void newPageInPinterestDomainIsOpen() {
        Assert.assertTrue(productDetailsPage.isPinterestDomainDisplayed());
    }

}
