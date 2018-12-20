package automationpractice.com.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class MyAddressesPage extends PageObject {

    @FindBy(xpath = "//*[contains(@class,'navigation_page') and contains(text(), 'My addresses')]")
    private WebElementFacade myAddressesText;

    public boolean isMyAddressesTextDisplayed() {
        return myAddressesText.isVisible();
    }

}
