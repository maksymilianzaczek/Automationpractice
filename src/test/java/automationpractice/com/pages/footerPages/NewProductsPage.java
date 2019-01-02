package automationpractice.com.pages.footerPages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class NewProductsPage extends PageObject {

    @FindBy(xpath = "//*[contains(@class,'navigation_page') and contains(text(), 'New products')]")

    private WebElementFacade newProductsText;


    public boolean isNewProductsTextDisplayed() {  return newProductsText.isVisible();
    }
}




