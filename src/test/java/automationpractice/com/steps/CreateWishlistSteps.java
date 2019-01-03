package automationpractice.com.steps;

import automationpractice.com.pages.WishlistPage;
import net.thucydides.core.annotations.Step;

import static automationpractice.com.domain.WishlistData.WISH_LIST_NAME;

public class CreateWishlistSteps {

    private WishlistPage wishlistPage;

    @Step
    public void createNewWishlist() {
        wishlistPage.insertWishlistName(WISH_LIST_NAME);            // create separate step to create new wishlist
        wishlistPage.submitCreatingWishlist();
    }
}
