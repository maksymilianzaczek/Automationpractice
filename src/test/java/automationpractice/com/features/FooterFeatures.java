package automationpractice.com.features;

import automationpractice.com.pages.*;
import automationpractice.com.steps.LoginSteps;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

public class FooterFeatures {


    private FooterBox footer;
    private AboutUsPage aboutUsPage;
    private BestSellersPage bestSellersPage;
    private ContactUsPage contactUsPage;
    private MyAddressesPage myAddressesPage;
    private MyCreditSlipsPage myCreditSlipsPage;
    private MyOrdersPage myOrdersPage;
    private MyPersonalInfoPage myPersonalInfoPage;
    private NewProductsPage newProductsPage;
    private OurStoresPage ourStoresPage;
    private SiteMapPage sitemapPage;
    private SpecialsPage specialsPage;
    private TermsAndConditionsOfUsePage termsAndConditionsOfUsePage;
    private WomenCategoriesPage womenCategoriesPage;
    private LoginSteps loginSteps;

    @When("^he clicks on About us button on footer$")
    public void heClicksOnAboutUsButtonOnFooter() {
        footer.clickOnAboutUsButton();
    }

    @Then("^he is navigated to About us page$")
    public void heIsNavigatedToAboutUsPage() {
        final boolean isAboutUsTextDisplayed = aboutUsPage.isAboutUsTextDisplayed();
//        getPageHeadlingTitle();
        assertThat(isAboutUsTextDisplayed).isTrue();
    }

//    private void getPageHeadlingTitle() {
//
//    }

    @When("^he clicks on Best sellers button on footer$")
    public void heClicksOnBestSellersButtonOnFooter() {
        footer.clickOnBestSellersButton();
    }


    @When("^he clicks on Contact us info button on footer$")
    public void heClicksOnContactUsInfoButtonOnFooter() {
        footer.clickOnContactUsButton();
    }

    @When("^he clicks on My addresses button on footer$")
    public void heClicksOnMyAddressesButtonOnFooter() {
        footer.clickOnMyAddressesButton();
    }

    @When("^he clicks on My credit slips button on footer$")
    public void heClicksOnMyCreditSlipsButtonOnFooter() {
        footer.clickOnMyCreditSlipsButton();
    }

    @When("^he clicks on My orders button on footer$")
    public void heClicksOnMyOrdersButtonOnFooter() {
        footer.clickOnMyOrdersButton();
    }

    @When("^he clicks on My personal info button on footer$")
    public void heClicksOnMyPersonalInfoButtonOnFooter() {
        footer.clickOnMyPersonalInfoButton();
    }

    @When("^he clicks on New products button on footer$")
    public void heClicksOnNewProductsButtonOnFooter() {
        footer.clickOnNewProductsButton();
    }

    @When("^he clicks on Our stores button on footer$")
    public void heClicksOnOurStoresButtonOnFooter() {
        footer.clickOnOurStoresButton();
    }

    @When("^he clicks on Sign out button on footer$")
    public void heClicksOnSignOutButtonOnFooter() {
        footer.clickOnSignOutFooterButton();
    }

    @When("^he clicks on Sitemap button on footer$")
    public void heClicksOnSitemapButtonOnFooter() {
        footer.clickOnSitemapButton();
    }

    @When("^he clicks on Specials button on footer$")
    public void heClicksOnSpecialsButtonOnFooter() {
        footer.clickOnSpecialsButton();
    }

    @When("^he clicks on Terms and conditions of use button on footer$")
    public void heClicksOnTermsAndConditionsOfUseButtonOnFooter() {
        footer.clickOnTermsAndConditionsOfUseButton();
    }

    @When("^he clicks on women button on footer$")
    public void heClicksOnWomenButtonOnFooter() {
        footer.clickOnWomenCategoriesButton();
    }

    @Then("^he is navigated to Best sellers page$")
    public void heIsNavigatedToBestSellersPage() {
        final boolean isBestSellersTextDisplayed = bestSellersPage.isBestSellersTextDisplayed();
        assertThat(isBestSellersTextDisplayed).isTrue();
    }

    @Then("^he is navigated to Contact us info page$")
    public void heIsNavigatedToContactUsInfoPage() {
        final boolean isContactUsTextDisplayed = contactUsPage.isContactUsTextDisplayed();
        assertThat(isContactUsTextDisplayed).isTrue();
    }

    @Then("^he is navigated to My addresses page$")
    public void heIsNavigatedToMyAddressesPage() {
        final boolean isMyAddressesTextDisplayed = myAddressesPage.isMyAddressesTextDisplayed();
        assertThat(isMyAddressesTextDisplayed).isTrue();
    }

    @Then("^he is navigated to My credit slips page$")
    public void heIsNavigatedToMyCreditSlipsPage() {
        final boolean isMyCreditSlipsTextDisplayed = myCreditSlipsPage.isMyCreditSlipsTextDisplayed();
        assertThat(isMyCreditSlipsTextDisplayed).isTrue();
    }

    @Then("^he is navigated to My orders page$")
    public void heIsNavigatedToMyOrdersPage() {
        final boolean isMyOrdersPageTextDisplayed = myOrdersPage.isMyOrdersPageTextDisplayed();
        assertThat(isMyOrdersPageTextDisplayed).isTrue();
    }

    @Then("^he is navigated to My personal info page$")
    public void heIsNavigatedToMyPersonalInfoPage() {
        final boolean isMyPersonalInfoTextDisplayed = myPersonalInfoPage.isMyPersonalInfoTextDisplayed();
        assertThat(isMyPersonalInfoTextDisplayed).isTrue();
    }

    @Then("^he is navigated to New products page$")
    public void heIsNavigatedToNewProductsPage() {
        final boolean isNewProductsTextDisplayed = newProductsPage.isNewProductsTextDisplayed();
        assertThat(isNewProductsTextDisplayed).isTrue();
    }

    @Then("^he is navigated to Our stores page$")
    public void heIsNavigatedToOurStoresPage() {
        final boolean isOurStoresTextDisplayed = ourStoresPage.isOurStoresTextDisplayed();
        assertThat(isOurStoresTextDisplayed).isTrue();
    }

    @Then("^he is navigated to Sitemap page$")
    public void heIsNavigatedToSitemapPage() {
        final boolean isSitemapTextDisplayed = sitemapPage.isSitemapTextDisplayed();
        assertThat(isSitemapTextDisplayed).isTrue();
    }

    @Then("^he is navigated to Specials page$")
    public void heIsNavigatedToSpecialsPage() {
        final boolean isSpecialsTextDisplayed = specialsPage.isSpecialsTextDisplayed();
        assertThat(isSpecialsTextDisplayed).isTrue();
    }

    @Then("^he is navigated to terms and conditions of use page$")
    public void heIsNavigatedToTermsAndConditionsOfUsePage() {
        final boolean isTermsAndConditionsOfUseTextDisplayed = termsAndConditionsOfUsePage.isTermsAndConditionsOfUseTextDisplayed();
        assertThat(isTermsAndConditionsOfUseTextDisplayed).isTrue();
    }

    @Then("^he is navigated to women categories page$")
    public void heIsNavigatedToWomenCategoriesPage() {
        final boolean isWomenCategoriesTextDisplayed = womenCategoriesPage.isWomenCategoriesTextDisplayed();
        assertThat(isWomenCategoriesTextDisplayed).isTrue();
    }
}
