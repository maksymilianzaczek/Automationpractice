package automationpractice.com.features;

import automationpractice.com.pages.ProductDetailsPage;
import automationpractice.com.pages.HomePage;
import automationpractice.com.pages.footerPages.MyAccountPage;
import automationpractice.com.steps.LoginSteps;
import cucumber.api.java.en.Given;


public class CheckoutFeatures {


    private HomePage homePage;
    private MyAccountPage myAccountPage;
    private ProductDetailsPage productDetailsPage;
    private LoginSteps loginSteps;


    @Given("^logged in customer is on chekout page$")
    public void customerIsOnHomePage() {
        homePage.open();
        loginSteps.login();
        myAccountPage.clickMyStore();
        homePage.clickOnNewProductImage();
        productDetailsPage.clickOnAddToCartButton();
        productDetailsPage.clickProceedToCheckoutButton();
    }
}