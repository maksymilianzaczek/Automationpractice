package automationpractice.com.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends PageObject {

    @FindBy(id = "create_account_error")
    private WebElementFacade homePageError;

    @FindBy(xpath = "//*[@class='product_list grid row homefeatured tab-pane active']//*[@class='product-container']")
    private List<WebElementFacade> listOfItems;

    public boolean isValidationMessageDisplayed() {
        return homePageError.isVisible();
    }

    public void clickOnFirstProductImage() {
        listOfItems.get(0).click();
    }
}
