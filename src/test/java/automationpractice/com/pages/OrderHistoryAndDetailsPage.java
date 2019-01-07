package automationpractice.com.pages;

import automationpractice.com.data.CommentAboutOrder;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

import static automationpractice.com.data.CommentAboutOrder.entranceFromTheYardXpath;

public class OrderHistoryAndDetailsPage extends PageObject {

    @FindBy(xpath = "//*[@id='order-list']//*[@class='first_item ']//*[contains(@class,'button-small')]")
    private WebElementFacade clickDetailsButtonForLastOneOrders;

    @FindBy(xpath = entranceFromTheYardXpath)
    private WebElementFacade isCommentAboutAddressInLastOneOrders;

    public void clickDetailsButtonForLastOneOrders() {
        clickDetailsButtonForLastOneOrders.click();
    }

    public boolean isCommentAboutAddressInLastOneOrdersVisible() {
        return isCommentAboutAddressInLastOneOrders.getText().contains(CommentAboutOrder.entranceFromTheYard.getComment());
    }
}
