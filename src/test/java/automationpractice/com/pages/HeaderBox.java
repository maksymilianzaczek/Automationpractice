package automationpractice.com.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class HeaderBox extends PageObject {

    @FindBy(className = "login")
    private WebElementFacade signInButton;
    @FindBy(className = "logout")
    private WebElementFacade signOutButton;
    @FindBy(xpath = "//*[@title='Contact Us']")
    private WebElementFacade contactUsButton;
    @FindBy(xpath = "//*[@class='header_user_info']//*[@class='account']/span")
    private WebElementFacade myAccountButton;

    public void clickOnSignIn() {
        signInButton.click();
    }

    public boolean isSignOutButtonVisible() {
        return signOutButton.isVisible();
    }

    public void clickOnSignOut() {
        signOutButton.click();
    }

    public boolean isSignInButtonVisible() {
        return signInButton.isVisible();
    }

    public void clickOnContactUs() {
        contactUsButton.click();
    }

}

