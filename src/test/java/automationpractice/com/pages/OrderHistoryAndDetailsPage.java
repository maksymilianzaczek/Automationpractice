package automationpractice.com.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class OrderHistoryAndDetailsPage extends PageObject {
    @FindBy(xpath = "//*[@id='order-list']//*[@class='first_item ']//*[contains(@class,'button-small')]")
    private WebElementFacade clickDetailsButtonForLastOneOrders;

    @FindBy(xpath = "//*[@id='block-order-detail']//*[contains(text(),'entrance from the yard')]" )
    private WebElementFacade isCommentAboutAddressInLastOneOrders;

    public void clickDetailsButtonForLastOneOrders() {
        clickDetailsButtonForLastOneOrders.click();
    }

    public boolean isCommentAboutAddressInLastOneOrdersVisible() {
        return isCommentAboutAddressInLastOneOrders.getText().contains("entrance from the yard");
    }
}
