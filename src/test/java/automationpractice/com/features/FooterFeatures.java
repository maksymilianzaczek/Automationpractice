package automationpractice.com.features;

import automationpractice.com.pages.*;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

public class FooterFeatures {

    final private String login = "maksymilian.zaczek@solsoft.pl";
    final private String password = "12345678";

    private Footer footer;
    private HomePage homePage;
    private HeaderBox headerBox;
    private LoginPage loginPage;
    private AboutUsPage aboutUsPage;
    private BestSellersPage bestSellersPage;
    private ContactUsPage contactUsPage;

    @When("^he clicks on About us button on footer$")
    public void heClicksOnAboutUsButtonOnFooter() {
        footer.clickOnAboutUsButton();
    }

    @Then("^he is navigated to About us page$")
    public void heIsNavigatedToAboutUsPage(){
        final boolean isAboutUsTextDisplayed = aboutUsPage.isAboutUsTextDisplayed();
        assertThat(isAboutUsTextDisplayed).isTrue();
    }

    @When("^he clicks on Best sellers button on footer$")
    public void heClicksOnBestSellersButtonOnFooter() {
        footer.clickOnBestSellerButton();
    }

    @Then("^he is navigated to Best sellers page$")
    public void heIsNavigatedToBestSellersPage() {
        final boolean isBestSellersTextTextDisplayed = bestSellersPage.isBestSellersTextDisplayed();
        assertThat(isBestSellersTextTextDisplayed).isTrue();
    }

    @When("^he clicks on Contact us info button on footer$")
    public void heClicksOnContactUsInfoButtonOnFooter() {
        footer.clickOnContactUsButton();
    }

    @Then("^he is navigated to Contact us info page$")
    public void heIsNavigatedToContactUsInfoPage() {
        final boolean isContactUsTextDisplayed = contactUsPage.isContactUsTextDisplayed();
        assertThat(isContactUsTextDisplayed).isTrue();
    }

    @When("^he clicks on My addresses button on footer$")
    public void heClicksOnMyAddressesButtonOnFooter() {
        footer.clickOnMyAddressButton();
    }
}
