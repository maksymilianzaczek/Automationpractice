package automationpractice.com.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class Footer extends PageObject {


    @FindBy(id = "newsletter-input")
    private WebElementFacade newsletter;
    @FindBy(name = "submitNewsletter")
    private WebElementFacade newsletterSaveButton;

    public void typeEmailRegistration(final String email) {
        newsletter.type(email);
    }

    public void clickOnNewsletter() {
        newsletterSaveButton.click();
    }
}
