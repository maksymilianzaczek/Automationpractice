package automationpractice.com.steps;

import automationpractice.com.pages.HeaderBox;
import automationpractice.com.pages.LoginPage;
import net.thucydides.core.annotations.Step;

import static automationpractice.com.data.Users.MACIEJ_BOCZKOWSKI;
import static automationpractice.com.data.Users.MACIEJ_STAFIJOWSKI;

public class LoginSteps {

    private HeaderBox headerBox;
    private LoginPage loginPage;

    @Step
    public void loginAs(final String username, final String password) {
        headerBox.clickOnSignIn();
        loginPage.typeLogin(username);
        loginPage.typePassword(password);
        loginPage.clickOnSignIn();
    }

    @Step
    public void login() {
        loginAs(MACIEJ_BOCZKOWSKI.getLogin(), MACIEJ_BOCZKOWSKI.getPassword());
    }
}
