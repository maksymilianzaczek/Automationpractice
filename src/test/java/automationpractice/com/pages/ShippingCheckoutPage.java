package automationpractice.com.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class ShippingCheckoutPage extends PageObject {


    @FindBy(className = "standard-checkout")
    private WebElementFacade clickOnProceedToCheckoutButtonInShippingLabel;

    @FindBy(id = "uniform-cgv")
    private WebElementFacade clickAgreeCheckbox;

    @FindBy(className = "fancybox-error")
    private WebElementFacade alertDisplayedInShippingCheckoutPage;

    @FindBy(xpath = "//*[contains(@class,'fancybox-close')]")
    private WebElementFacade closeAlertInShippingLabel;


    public void clickOnProceedToCheckoutButtonInShippingLabel() {
        clickOnProceedToCheckoutButtonInShippingLabel.click();
    }

    public void clickAgreeCheckbox() {
        clickAgreeCheckbox.click();
    }

    public boolean isAlertDisplayedInShippingCheckoutPage() {
        return alertDisplayedInShippingCheckoutPage.isVisible();
    }

    public void closeAlertInShippingLabel() {
        closeAlertInShippingLabel.click();
        waitABit(500);
    }

}
