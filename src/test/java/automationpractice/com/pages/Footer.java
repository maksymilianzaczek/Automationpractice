package automationpractice.com.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;
import org.w3c.dom.html.HTMLInputElement;

public class Footer extends PageObject {


    @FindBy(id = "newsletter-input")
    private WebElementFacade newsletter;
    @FindBy(name = "submitNewsletter")
    private WebElementFacade newsletterSaveButton;
    @FindBy(xpath = "//*[@title='About us']")
    private WebElementFacade aboutUsButton;
    @FindBy(xpath = "//*[@title='Best sellers']")
    private WebElementFacade bestSellerButton;
    @FindBy(xpath = "//*[@title='Contact us']")
    private WebElementFacade contactUsButton;
    @FindBy()
    private WebElementFacade myAddressButton;

    public void typeEmailRegistration(final String email) {
        newsletter.type(email);
    }

    public void clickOnNewsletter() {
        newsletterSaveButton.click();
    }

    public void clickOnAboutUsButton() {
        aboutUsButton.click();
    }

    public void clickOnBestSellerButton() {
        bestSellerButton.click();
    }

    public void clickOnContactUsButton() {
        contactUsButton.click();
    }

    public void clickOnMyAddressButton() {
        myAddressButton.click();
    }
}

