package automationpractice.com.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

import javax.swing.*;

public class HomePage extends PageObject
{

    @FindBy(id = "create_account_error")
    private WebElementFacade homePageError;

    @FindBy(xpath = "//*[contains(@class,'replace-2x img-responsive') and contains(@title,'Faded Short Sleeve T-shirts')]")
    private WebElementFacade clickOnNewProductImage;
    @FindBy(className = "alert alert-success")
    private WebElementFacade SuccessfulMessage;

    public boolean isValidationMessageDisplayed() {
        return homePageError.isVisible();
    }

    public void clickOnNewProductImage() {
        clickOnNewProductImage.click();
    }

    public boolean isSuccessfulNewsletterMessageDisplayed() { return SuccessfulMessage.isVisible(); }
}
