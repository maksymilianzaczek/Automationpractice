package automationpractice.com.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class HeaderBox extends PageObject {

    @FindBy(className = "login")
    private WebElementFacade signInButton;
    @FindBy(className = "logout")
    private WebElementFacade signOutButton;
    @FindBy(xpath = "//*[@class='header_user_info']//*[@class='account']/span")
    private WebElementFacade loggedUserButton;
    @FindBy(id = "header_logo")
    private WebElementFacade myStoreLogo;

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

    public void clickOnLoggedUser(){
        loggedUserButton.click();
    }

    public void clickMyStoreLogo() {
        myStoreLogo.click();
    }
}

