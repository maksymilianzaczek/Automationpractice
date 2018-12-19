package automationpractice.com.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class NewProductsPage extends PageObject {

    @FindBy(xpath = "//*[contains(@class,'navigation_page') and contains(text(), 'New products')]")

    private WebElementFacade NewProductsText;


    public boolean isNewProductsTextDisplayed() {  return NewProductsText.isVisible();
    }
}




