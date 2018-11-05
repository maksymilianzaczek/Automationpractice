package automationpractice.com.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends PageObject {

    @FindBy(id = "email")
    private WebElementFacade loginInput;
    @FindBy(id = "passwd")
    private WebElementFacade passwordInput;
    @FindBy(id = "SubmitLogin")
    private WebElementFacade signInButton;
    @FindBy(xpath = "//*[contains(@class,'alert-danger')and not(@id='create_account_error')]")
    private WebElementFacade validationMessage;

    public void typeLogin(final String login) {
        loginInput.type(login);
    }

    public void typePassword(final String password) {
        passwordInput.type(password);
    }

    public void clickOnSignIn() {
        signInButton.click();
    }

    public boolean isValidationMessageDisplayed() {
        return validationMessage.isVisible();
    }
}
