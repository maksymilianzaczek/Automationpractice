package automationpractice.com.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class MyOrdersPage extends PageObject {


    @FindBy(xpath = "//*[contains(@class, 'page-heading')]")
    private WebElementFacade myOrdersText;

    public String HeadlingTitle() {
        return myOrdersText.isVisible();
    }
}




