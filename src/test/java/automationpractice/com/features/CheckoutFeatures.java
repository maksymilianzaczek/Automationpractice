package automationpractice.com.features;

import automationpractice.com.pages.*;
import cucumber.api.java.en.Given;


public class CheckoutFeatures {

    final private String login = "maksymilian.zaczek@solsoft.pl";
    final private String password = "12345678";
    private HomePage homePage;
    private HeaderBox headerBox;
    private LoginPage loginPage;
    private MyAccountPage myAccountPage;
    private FirstProductPage firstProductPage;


    @Given("^logged in customer is on chekout page$")
    public void customerIsOnHomePage() {
        homePage.open();
        loginWithCredentials(login, password);
        myAccountPage.clickMyStore();
        homePage.clickOnNewProductImage();
        firstProductPage.clickOnAddToCartButton();
        firstProductPage.clickProceedToCheckoutButton();


    }

    private void loginWithCredentials(String login, String password) {
        headerBox.clickOnSignIn();
        loginPage.typeLogin(login);
        loginPage.typePassword(password);
        loginPage.clickOnSignIn();
    }
}
