package automationpractice.com.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageObject
{

    @FindBy(id = "create_account_error")
    private WebElementFacade homePageError;

   //You can't put in xpath test data like product title
   @FindBy(xpath = "//*[contains(@class,'replace-2x img-responsive') and contains(@title,'Faded Short Sleeve T-shirts')]")
   private WebElementFacade clickOnNewProductImage;

    public boolean isValidationMessageDisplayed() {
        return homePageError.isVisible();
    }

    public void clickOnNewProductImage() {
        clickOnNewProductImage.click();
    }

}
