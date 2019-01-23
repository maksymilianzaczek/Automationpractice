package automationpractice.com.features;

import automationpractice.com.data.PageHeadlingTitles;
import automationpractice.com.pages.ContactUsPage;
import automationpractice.com.pages.FooterBox;
import automationpractice.com.pages.MyAddressesPage;
import automationpractice.com.pages.MyOrdersPage;
import automationpractice.com.pages.footerPages.*;
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

    private final PageHeadlingTitles pageHeadlingTitles = new PageHeadlingTitles();

    @When("^he clicks on About us button on footer$")
    public void heClicksOnAboutUsButtonOnFooter() {
        footer.clickOnAboutUsButton();
    }

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

    @Then("^he is navigated to About us page$")
    public void heIsNavigatedToAboutUsPage() {
        assertThat(pageHeadlingTitles.getAboutUsTitle()).isEqualTo(aboutUsPage.HeadlingTitle());
    }

    @Then("^he is navigated to Best sellers page$")
    public void heIsNavigatedToBestSellersPage() {
        assertThat(pageHeadlingTitles.getBestSellersTitle().equals(bestSellersPage.HeadlingTitle()));
    }

    @Then("^he is navigated to Contact us info page$")
    public void heIsNavigatedToContactUsInfoPage() {
        assertThat(pageHeadlingTitles.getContactUsTitle().equals(contactUsPage.HeadlingTitle()));
    }

    @Then("^he is navigated to My addresses page$")
    public void heIsNavigatedToMyAddressesPage() {
        assertThat(pageHeadlingTitles.getMyAddressesTitle().equals(myAddressesPage.HeadlingTitle()));
    }

    @Then("^he is navigated to My credit slips page$")
    public void heIsNavigatedToMyCreditSlipsPage() {
        assertThat(pageHeadlingTitles.getMyCreditSlipsTitle().equals(myCreditSlipsPage.HeadlingTitle()));
    }

    @Then("^he is navigated to My orders page$")
    public void heIsNavigatedToMyOrdersPage() {
        assertThat(pageHeadlingTitles.getMyOrdersTitle().equals(myOrdersPage.HeadlingTitle()));
    }

    @Then("^he is navigated to My personal info page$")
    public void heIsNavigatedToMyPersonalInfoPage() {
        assertThat(pageHeadlingTitles.getMyPersonalInfoTitle().equals(myPersonalInfoPage.HeadlingTitle()));
    }

    @Then("^he is navigated to New products page$")
    public void heIsNavigatedToNewProductsPage() {
        assertThat(pageHeadlingTitles.getNewProductsTitle().equals(newProductsPage.HeadlingTitle()));
    }

    @Then("^he is navigated to Our stores page$")
    public void heIsNavigatedToOurStoresPage() {
        assertThat(pageHeadlingTitles.getOurStoresTitle().equals(ourStoresPage.HeadlingTitle()));
    }

    @Then("^he is navigated to Sitemap page$")
    public void heIsNavigatedToSitemapPage() {
        assertThat(pageHeadlingTitles.getSitemapTitle().equals(sitemapPage.HeadlingTitle()));
    }

    @Then("^he is navigated to Specials page$")
    public void heIsNavigatedToSpecialsPage() {
        assertThat(pageHeadlingTitles.getSpecialsTitle().equals(specialsPage.HeadlingTitle()));
    }

    @Then("^he is navigated to terms and conditions of use page$")
    public void heIsNavigatedToTermsAndConditionsOfUsePage() {
        assertThat(pageHeadlingTitles.getTermsAndConditionsOfUseTitle().equals(termsAndConditionsOfUsePage.HeadlingTitle()));
    }

    @Then("^he is navigated to women categories page$")
    public void heIsNavigatedToWomenCategoriesPage() {
        assertThat(pageHeadlingTitles.getWomenCategoriesTitle().equals(womenCategoriesPage.HeadlingTitle()));
    }
}
