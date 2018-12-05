package automationpractice.com.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageObject {

    @FindBy(className = "icon-building")
    private WebElementFacade myAddress;

    public void clickMyAddresses() {
        myAddress.click();
    }
}
