package automationpractice.com.features;

import automationpractice.com.pages.*;
import automationpractice.com.steps.LoginSteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.apache.commons.lang3.RandomStringUtils;

import static automationpractice.com.domain.ProductData.DEFAULT_PRODUCT;
import static org.assertj.core.api.Assertions.assertThat;

public class WishlistFeature {

    private final String WISH_LIST_NAME = String.format("wishlist%s", RandomStringUtils.randomNumeric(2));
    //    private static String WISH_LIST_NAME = "newList";
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
        wishlistPage.insertWishlistName(WISH_LIST_NAME);
        wishlistPage.submitCreatingWishlist();
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
        homePage.selectDefaultProduct(DEFAULT_PRODUCT);
        productDetailPage.addToWishlist();
        productDetailPage.closeConfirmation();
        headerBox.clickOnMyAccount();
        myAccountPage.clickMyWishlist();
        wishlistPage.clickWishlist(WISH_LIST_NAME);
    }

    @Then("^product is added to the list$")
    public void productIsAddedToTheList() {
        assertThat(wishlistPage.listOfProductsInWishlist()).contains(DEFAULT_PRODUCT);
    }

    @Given("^logged in customer with new created wishlist is on wishlist page$")
    public void loggedInCustomerWithNewCreatedWishlistIsOnWishlistPage() {
        homePage.open();
        loginSteps.login();
        myAccountPage.clickMyWishlist();
        wishlistPage.insertWishlistName(WISH_LIST_NAME);
        wishlistPage.submitCreatingWishlist();
    }

    @Given("^logged in customer with new created wishlist is on home page$")
    public void loggedInCustomerWithNewCreatedWishlistIsOnHomePage() {
        homePage.open();
        loginSteps.login();
        myAccountPage.clickMyWishlist();
        wishlistPage.insertWishlistName(WISH_LIST_NAME);
        wishlistPage.submitCreatingWishlist();
        homePage.open();
    }
}