package automationpractice.com.features;

import automationpractice.com.pages.*;
import automationpractice.com.steps.LoginSteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

import static automationpractice.com.domain.ProductData.DEFAULT_PRODUCT;
import static org.assertj.core.api.Assertions.assertThat;

public class WishlistFeature {

    private static String wishlistName = "newList";
    private HomePage homePage;
    private WishlistPage wishlistPage;
    private MyAccountPage myAccountPage;
    private ProductDetailPage productDetailPage;
    private HeaderBox headerBox;
    @Steps
    private LoginSteps loginSteps;

    @Given("^logged in customer is on wishlist page$")
    public void loggedInCustomerIsOnWishlistPage() {
        homePage.open();
        loginSteps.login();
        myAccountPage.clickMyWishlist();
    }

    @When("^he creates new wishlist$")
    public void heCreatesNewWishlist() {
        wishlistPage.insertWishlistName(wishlistName);
        wishlistPage.submitCreatingWishlist();
    }

    @Then("^wishlist is created$")
    public void wishlistIsCreated() {
        assertThat(wishlistPage.getWishlistsList()).contains(wishlistName);
    }

    @When("^he deletes existing wishlist$")
    public void heDeletesExistingWishlist() {
        wishlistPage.deleteWishlist(wishlistName);
    }

    @Then("^wishlist is deleted$")
    public void wishlistIsDeleted() {
        assertThat(wishlistPage.getWishlistsList()).doesNotContain(wishlistName);
    }

    @When("^he adds product to wishlist$")
    public void heAddsProductToWishlist() {
        homePage.open();
        homePage.selectFirstProduct(DEFAULT_PRODUCT);
        productDetailPage.addToWishlist();
        productDetailPage.closeConfirmation();
        headerBox.clickOnMyAccount();
        myAccountPage.clickMyWishlist();
        wishlistPage.clickWishlist(wishlistName);
    }

    @Then("^product is added to the list$")
    public void productIsAddedToTheList() {
        assertThat(wishlistPage.listOfProductsInWishlist()).contains(DEFAULT_PRODUCT);
    }
}