package automationpractice.com.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageObject {

    @FindBy(id = "create_account_error")
    private WebElementFacade homePageError;

    @FindBy(xpath = "//*[@id = 'homefeatured']//*[contains (@class, 'ajax_block_product col-xs-12 col-sm-4 col-md-3 first-in-line first')]")
    private WebElementFacade clickOnNewProductImage;
    @FindBy(xpath = "//*[contains(@class,'alert-success')]")
    private WebElementFacade successfulMessage;

    public boolean isValidationMessageDisplayed() {
        return homePageError.isVisible();
    }

    public void clickOnNewProductImage() {
        clickOnNewProductImage.click();
    }

    public boolean isSuccessfulNewsletterMessageDisplayed() {
        return successfulMessage.isVisible();
    }

}
