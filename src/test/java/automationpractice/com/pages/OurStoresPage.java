package automationpractice.com.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class OurStoresPage extends PageObject {

    @FindBy(xpath = "//*[contains(@class,'navigation_page') and contains(text(), 'Our store(s)!')]")
    private WebElementFacade ourStoresText;


    public boolean isOurStoresTextDisplayed() {  return ourStoresText.isVisible();
    }
}



