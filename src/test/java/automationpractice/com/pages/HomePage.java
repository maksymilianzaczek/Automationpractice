package automationpractice.com.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageObject {

    @FindBy(id = "create_account_error")
    private WebElementFacade homePageError;

    @FindBy(xpath = "//*[@id = 'homefeatured']//*[contains(@class,'replace-2x img-responsive') and contains(@src,'http://automationpractice.com/img/p/1/1-home_default.jpg')]")
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
