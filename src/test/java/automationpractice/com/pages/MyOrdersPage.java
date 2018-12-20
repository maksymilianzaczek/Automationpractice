package automationpractice.com.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class MyOrdersPage extends PageObject {


    @FindBy(xpath = "//*[contains(@class,'navigation_page') and contains(text(), 'Order history')]")
    private WebElementFacade myOrdersText;


    public boolean isMyOrdersPageTextDisplayed() { return myOrdersText.isVisible();
    }
}




