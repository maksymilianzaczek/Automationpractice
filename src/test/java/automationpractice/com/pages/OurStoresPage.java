package automationpractice.com.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class OurStoresPage extends PageObject {

    @FindBy(xpath = "//*[contains(@class,'navigation_page')]")
    private WebElementFacade OurStoresText;


    public boolean isOurStoresTextDisplayed() {  return OurStoresText.isVisible();
    }
}


