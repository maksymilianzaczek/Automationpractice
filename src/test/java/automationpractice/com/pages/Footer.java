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
    private WebElementFacade AboutUsButton;

    public void typeEmailRegistration(final String email) {
        newsletter.type(email);
    }

    public void clickOnNewsletter() {
        newsletterSaveButton.click();
    }

    public void clickOnAboutUsButton() {
        AboutUsButton.click();
    }
}
