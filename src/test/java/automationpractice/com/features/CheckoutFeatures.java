package automationpractice.com.features;

import automationpractice.com.pages.*;
import automationpractice.com.pages.footerPages.MyAccountPage;
import automationpractice.com.steps.LoginSteps;
import cucumber.api.java.en.Given;


public class CheckoutFeatures {


    private HomePage homePage;
    private HeaderBox headerBox;
    private MyAccountPage myAccountPage;
    private FirstProductPage firstProductPage;
    private LoginSteps loginSteps;


    @Given("^logged in customer is on chekout page$")
    public void customerIsOnHomePage() {
        homePage.open();
        loginSteps.login();
        myAccountPage.clickMyStore();
        homePage.clickOnNewProductImage();
        firstProductPage.clickOnAddToCartButton();
        firstProductPage.clickProceedToCheckoutButton();
    }
}