package automationpractice.com.features;

import automationpractice.com.pages.ProductDetailsPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

public class SocialMediaFeatures {

    private ProductDetailsPage productDetailsPage;

    @When("^user chose twitter$")
    public void userChoseTwitter() {
        productDetailsPage.clickOnTwitterButton();
        productDetailsPage.checkoutToTweeterWindow();
    }

    @Then("^new page in twitter domain is open$")
    public void newPageInTwitterDomainIsOpen() {
        assertThat(productDetailsPage.isTwitterDomainDisplayed()).isTrue();
    }

    @When("^user chose facebook$")
    public void userChoseFacebook() {
        productDetailsPage.clickOnFacebookButton();
        productDetailsPage.checkoutToFacebookWindow();
    }

    @Then("^new page in facebook domain is open$")
    public void newPageInFacebookDomainIsOpen() {
        assertThat(productDetailsPage.isFacebookDomainDisplayed()).isTrue();
    }

    @When("^user chose google plus$")
    public void userChoseGooglePlus() {
        productDetailsPage.clickOnGooglePlusButton();
        productDetailsPage.checkoutToGooglePlusWindow();
    }

    @Then("^new page in google plus domain is open$")
    public void newPageInPDomainIsOpen() {
        assertThat(productDetailsPage.isGooglePlusDomainDisplayed()).isTrue();
    }

    @When("^user chose pinterest$")
    public void userChosePinterest() {
        productDetailsPage.clickOnPinterestButton();
        productDetailsPage.checkoutToPinterestWindow();
    }

    @Then("^new page in pinterest domain is open$")
    public void newPageInPinterestDomainIsOpen() {
        assertThat(productDetailsPage.isPinterestDomainDisplayed()).isTrue();
    }

}
