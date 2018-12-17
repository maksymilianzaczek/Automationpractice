package automationpractice.com.features.checkout;

import automationpractice.com.pages.*;
import automationpractice.com.steps.LoginSteps;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

public class ShareInformationAboutItemFeatures {

    private HomePage homePage;
    private FirstProductPage firstProductPage;
    @Steps
    private LoginSteps loginSteps;

    @When("^user select first item from homepage and chose twitter$")
    public void userSelectFirstItemFromHomepageAndChoseTwitter() {
        homePage.clickOnNewProductImage();
        firstProductPage.clickOnTwitterButton();
        firstProductPage.checkoutToTweeterWindow();
    }

    @Then("^new page in twitter domain is open$")
    public void newPageInTwitterDomainIsOpen() {
        Assert.assertTrue(firstProductPage.isTwitterDomain());
    }

    @When("^user select first item from homepage and chose facebook$")
    public void userSelectFirstItemFromHomepageAndChoseFacebook() {
        homePage.clickOnNewProductImage();
        firstProductPage.clickOnFacebookButton();
        firstProductPage.checkoutToFacebookWindow();
    }

    @Then("^new page in facebook domain is open$")
    public void newPageInFacebookDomainIsOpen() {
        Assert.assertTrue(firstProductPage.isFacebookDomain());
    }

    @When("^user select first item from homepage and chose google plus$")
    public void userSelectFirstItemFromHomepageAndChoseGooglePlus() {
        homePage.clickOnNewProductImage();
        firstProductPage.clickOnGooglePlusButton();
        firstProductPage.checkoutToGooglePlusWindow();
    }

    @Then("^new page in google plus domain is open$")
    public void newPageInPDomainIsOpen() {
        Assert.assertTrue(firstProductPage.isGooglePlusDomain());
    }

    @When("^user select first item from homepage and chose pinterest$")
    public void userSelectFirstItemFromHomepageAndChosePinterest() {
        homePage.clickOnNewProductImage();
        firstProductPage.clickOnPinteresButton();
        firstProductPage.checkoutToPinterestWindow();
    }

    @Then("^new page in pinterest domain is open$")
    public void newPageInPinterestDomainIsOpen() {
        Assert.assertTrue(firstProductPage.isPinterestDomain());
    }

}
