package automationpractice.com.pages;

import automationpractice.com.data.CommentAboutOrder;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

import static automationpractice.com.data.CommentAboutOrder.entranceFromTheYardXpath;

public class OrderHistoryAndDetailsPage extends PageObject {

    @FindBy(xpath = "//*[@id='order-list']//*[@class='first_item ']//*[contains(@class,'small')]")
    private WebElementFacade detailsButtonForLastOneOrders;

    @FindBy(xpath = entranceFromTheYardXpath)
    private WebElementFacade commentAboutAddressInLastOneOrders;

    public void clickDetailsButtonForLastOneOrders() {
        detailsButtonForLastOneOrders.click();
    }

    public boolean isCommentAboutAddressInLastOneOrdersVisible() {
        return commentAboutAddressInLastOneOrders.getText().contains(CommentAboutOrder.entranceFromTheYard.getComment());
    }
}
