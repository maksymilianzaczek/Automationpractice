package automationpractice.com.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageObject
{

    @FindBy(id = "create_account_error")
    private WebElementFacade homePageError;

    public boolean isValidationMessageDisplayed() {
        return homePageError.isVisible();
    }


}
