package automationpractice.com.features;

import automationpractice.com.pages.*;
import automationpractice.com.steps.CreateWishlistSteps;
import automationpractice.com.steps.LoginSteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

import static automationpractice.com.domain.WishlistData.WISH_LIST_NAME;
import static org.assertj.core.api.Assertions.assertThat;

public class WishlistFeature {

    private HomePage homePage;
    private WishlistPage wishlistPage;
    private MyAccountPage myAccountPage;
    private ProductDetailsPage productDetailsPage;
    private HeaderBox headerBox;
    private String wishlistName;
    private String productName;
    @Steps
    private LoginSteps loginSteps;
    @Steps
    private CreateWishlistSteps createWishlistSteps;

    @Given("^logged in customer is on wishlist page$")
    public void loggedInCustomerIsOnWishlistPage() {
        loginSteps.login();
        myAccountPage.clickMyWishlist();
    }

    @When("^he creates new wishlist$")
    public void heCreatesNewWishlist() {
        createWishlistSteps.createNewWishlist();
    }

    @Then("^wishlist is created$")
    public void wishlistIsCreated() {
        assertThat(wishlistPage.getWishlistsList()).contains(WISH_LIST_NAME);
    }

    @When("^he deletes existing wishlist$")
    public void heDeletesExistingWishlist() {
        wishlistPage.deleteWishlist(WISH_LIST_NAME);
    }

    @Then("^wishlist is deleted$")
    public void wishlistIsDeleted() {
        assertThat(wishlistPage.getWishlistsList()).doesNotContain(WISH_LIST_NAME);
    }

    @When("^he adds product to wishlist$")
    public void heAddsProductToWishlist() {
        homePage.open();
        productName = homePage.getProductNameList().get(0);
        homePage.selectDefaultProduct(productName);
        productDetailsPage.addToWishlist();
        productDetailsPage.closeConfirmation();
        headerBox.clickOnMyAccount();
        myAccountPage.clickMyWishlist();
        wishlistName = wishlistPage.getWishlistsList().get(0);
        wishlistPage.clickWishlist(wishlistName);
    }

    @Then("^product is added to the list$")
    public void productIsAddedToTheList() {
        assertThat(wishlistPage.listOfProductsInWishlist()).contains(productName);
    }

    @Given("^logged in customer with new created wishlist is on wishlist page$")
    public void loggedInCustomerWithNewCreatedWishlistIsOnWishlistPage() {
        loginSteps.login();
        myAccountPage.clickMyWishlist();
        createWishlistSteps.createNewWishlist();
    }

    @Given("^logged in customer with new created wishlist is on home page$")
    public void loggedInCustomerWithNewCreatedWishlistIsOnHomePage() {
        loginSteps.login();
        myAccountPage.clickMyWishlist();
        createWishlistSteps.createNewWishlist();
        homePage.open();
    }
}