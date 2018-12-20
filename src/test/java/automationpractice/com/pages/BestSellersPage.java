package automationpractice.com.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class BestSellersPage extends PageObject {

    @FindBy(xpath = "//*[contains(@class,'navigation_page') and contains(text(), 'Best sellers')]")
    private WebElementFacade bestSellersText;

    public boolean isBestSellersTextDisplayed() {
        return bestSellersText.isVisible();
            }

}
