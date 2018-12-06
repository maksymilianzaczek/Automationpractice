package automationpractice.com.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;
import org.w3c.dom.html.HTMLInputElement;

public class MyAccountPage extends PageObject {

    @FindBy(className = "icon-building")
    private WebElementFacade myAddress;
    @FindBy(className = "logo img-responsive")
    private WebElementFacade myStore;

    public void clickMyAddresses() {
        myAddress.click();
    }

    public void clickMyStore() {
        myStore.click();
    }
}
