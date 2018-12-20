package automationpractice.com.steps;

import automationpractice.com.pages.HeaderBox;
import automationpractice.com.pages.HomePage;
import automationpractice.com.pages.LoginPage;
import net.thucydides.core.annotations.Step;


import static automationpractice.com.data.Users.MACIEJ_BOCZKOWSKI;
import static automationpractice.com.data.Users.MACIEJ_STAFIJOWSKI;

public class LoginSteps {

    private HeaderBox headerBox;
    private LoginPage loginPage;
    private HomePage homePage;

    @Step
    private void loginAs(final String username, final String password) {
        headerBox.clickOnSignIn();
        loginPage.typeLogin(username);
        loginPage.typePassword(password);
        loginPage.clickOnSignIn();
    }
    @Step
    private void loginAsAndMoveIntoMyStorePage(final String username, final String password) {
        homePage.open();
        loginAs(username,password);
        headerBox.clickMyStore();

    }

    @Step
    public void login() {
        loginAs(MACIEJ_BOCZKOWSKI.getLogin(), MACIEJ_BOCZKOWSKI.getPassword());
    }
    @Step
    public void loginAndMoveIntoMyStorePage() {
        loginAsAndMoveIntoMyStorePage(MACIEJ_BOCZKOWSKI.getLogin(), MACIEJ_BOCZKOWSKI.getPassword());
    }


}
