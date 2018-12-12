package automationpractice.com.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class ProductDetailPage extends PageObject {

    @FindBy(id = "wishlist_button")
    private WebElementFacade addToWishlistButton;
    @FindBy(className = "fancybox-item")
    private WebElementFacade closeConfirmationMessage;

    public void addToWishlist() {
        addToWishlistButton.click();
    }

    public void closeConfirmation() {
        closeConfirmationMessage.click();
    }
}