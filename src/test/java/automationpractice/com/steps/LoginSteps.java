package automationpractice.com.steps;

import automationpractice.com.pages.HeaderBox;
import automationpractice.com.pages.HomePage;
import automationpractice.com.pages.LoginPage;

import static automationpractice.com.data.Users.MACIEJ_BOCZKOWSKI;

public class LoginSteps {

    private HeaderBox headerBox;
    private LoginPage loginPage;
    private HomePage homePage;

    private void loginAs(final String username, final String password) {
        headerBox.clickOnSignIn();
        loginPage.typeLogin(username);
        loginPage.typePassword(password);
        loginPage.clickOnSignIn();
    }

    private void loginAsAndMoveIntoMyStorePage(final String username, final String password) {
        homePage.open();
        loginAs(username, password);
        headerBox.clickMyStoreLogo();
    }

    public void login() {
        loginAs(MACIEJ_BOCZKOWSKI.getLogin(), MACIEJ_BOCZKOWSKI.getPassword());
    }

    public void loginAndMoveIntoMyStorePage() {
        loginAsAndMoveIntoMyStorePage(MACIEJ_BOCZKOWSKI.getLogin(), MACIEJ_BOCZKOWSKI.getPassword());
    }

}
