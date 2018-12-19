package automationpractice.com.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class Footer extends PageObject {


    @FindBy(id = "newsletter-input")
    private WebElementFacade newsletter;
    @FindBy(name = "submitNewsletter")
    private WebElementFacade newsletterSaveButton;
    @FindBy(xpath = "//*[@title='About us']")
    private WebElementFacade aboutUsButton;
    @FindBy(xpath = "//*[@title='Best sellers']")
    private WebElementFacade bestSellersButton;
    @FindBy(xpath = "//*[@title='Contact us']")
    private WebElementFacade contactUsButton;
    @FindBy(xpath = "//*[@title='My addresses']")
    private WebElementFacade myAddressesButton;
    @FindBy(xpath = "//*[@title='My credit slips']")
    private WebElementFacade myCreditSlipsButton;
    @FindBy(xpath = "//*[@title='My orders']")
    private WebElementFacade myOrdersButton;
    @FindBy(xpath = "//*[@title='Manage my personal information']")
    private WebElementFacade myPersonalInfoButton;
    @FindBy(xpath = "//*[@title='New products']")
    private WebElementFacade newProductsButton;
    @FindBy(xpath = "//*[@title='Our stores']")
    private WebElementFacade ourStoresButton;
    @FindBy(xpath = "//*[@title='Sign out']")
    private WebElementFacade signOutFooterButton;
    @FindBy(xpath = "//*[@title='Sitemap']")
    private WebElementFacade sitemapButton;
    @FindBy(xpath = "//*[@title='Specials']")
    private WebElementFacade specialsButton;
    @FindBy(xpath = "//*[@title='Terms and conditions of use']")
    private WebElementFacade termsAndConditionsOfUseButton;
    @FindBy(xpath = "//*[contains(@id, 'footer')]//*[contains(text(), 'Women')]")
    private WebElementFacade womenCategoriesButton;

    public void typeEmailRegistration(final String email) {
        newsletter.type(email);
    }

    public void clickOnNewsletter() {
        newsletterSaveButton.click();
    }

    public void clickOnAboutUsButton() {
        aboutUsButton.click();
    }

    public void clickOnBestSellersButton() {
        bestSellersButton.click();
    }

    public void clickOnContactUsButton() {
        contactUsButton.click();
    }

    public void clickOnMyAddressesButton() {
        myAddressesButton.click();
    }

    public void clickOnMyCreditSlipsButton() {
        myCreditSlipsButton.click();
    }

    public void clickOnMyOrdersButton() {
        myOrdersButton.click();
    }

    public void clickOnMyPersonalInfoButton() {
        myPersonalInfoButton.click();
    }

    public void clickOnNewProductsButton() {
        newProductsButton.click();
    }

    public void clickOnOurStoresButton() {
        ourStoresButton.click();
    }

    public void clickOnSignOutFooterButton() {
        signOutFooterButton.click();
    }

    public void clickOnSitemapButton() {
        sitemapButton.click();
    }

    public void clickOnSpecialsButton() {
        specialsButton.click();
    }

    public void clickOnTermsAndConditionsOfUseButton() {
        termsAndConditionsOfUseButton.click();
    }

    public void clickOnWomenCategoriesButton() {
        womenCategoriesButton.click();
    }
}
