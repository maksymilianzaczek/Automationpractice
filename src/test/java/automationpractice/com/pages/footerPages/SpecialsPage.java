package automationpractice.com.pages.footerPages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class SpecialsPage extends PageObject {

    @FindBy(xpath = "//*[contains(@class,'navigation_page') and contains(text(), 'Price drop')]")
    private WebElementFacade specialsText;

    public boolean isSpecialsTextDisplayed() {  return specialsText.isVisible();
    }
}




