package automationpractice.com.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class WishlistPage extends PageObject {

    private static final String WISHLIST_NAME_PATTERN = "//*[contains(text(),'%s')]";
    private static final String DELETE_MY_WISHLIST_XPATH_PATTERN = "//*[contains(text(),'%s')]//ancestor::*[contains(@id,'wishlist_')]//*[contains(@class,'wishlist_delete')]/*[@class='icon']";

    @FindBy(xpath = "//input[@id='name']")
    private WebElementFacade wishlistName;
    @FindBy(id = "submitWishlist")
    private WebElementFacade submitButton;
    @FindBy(xpath = "//*[contains(@class,'table-bordered')]//*[contains(@id, 'wishlist')]/td[1]")
    private List<WebElementFacade> wishlistsNameList;
    @FindBy(xpath = "//*[contains(@class,'row wlp_bought_list')]//*[@class='product-name']")
    private List<WebElementFacade> productsList;

    public void insertWishlistName(final String listName) {
        wishlistName.type(listName);
    }

    public void submitCreatingWishlist() {
        submitButton.click();
    }

    public List<String> getWishlistsList() {
        return wishlistsNameList.stream().map(WebElementFacade::getText).collect(Collectors.toList());
    }

    public void deleteWishlist(final String wishlistName) {
        final String deleteMyWishlistButton = String.format(DELETE_MY_WISHLIST_XPATH_PATTERN, wishlistName);
        final WebElementFacade deleteButton = find(By.xpath(deleteMyWishlistButton));
        deleteButton.click();
        getDriver().switchTo().alert().accept();
        deleteButton.waitUntilNotVisible();
    }

    public void clickWishlist(final String wishlistName) {
        final String clickOnWishlistXPath = String.format(WISHLIST_NAME_PATTERN, wishlistName);
        final WebElementFacade wishlistLink = find(By.xpath(clickOnWishlistXPath));
        wishlistLink.click();
    }

    public List<String> listOfProductsInWishlist() {
        return productsList
                .stream()
                .map(WebElementFacade::getText)         //mapps text
                .map(this::removeTextAfterLineBreak)    //deletes all text after line break
                .map(String::trim)                      //deletes empno ty spaces and white spots before and after text
                .collect(Collectors.toList());
    }

    private String removeTextAfterLineBreak(String text) {
        return text.substring(0, text.indexOf('\n'));
    }
}
