package automationpractice.com.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class SummaryCheckoutPage extends PageObject {

    @FindBy(className = "standard-checkout")
    private WebElementFacade clickOnProceedToCheckoutButtonInSummaryLabel;

    @FindBy(xpath = "//*[contains(@class,'stock-management-on')]//*[contains(@class,'odd')]//*[@class='cart_description']/small[2]/a")
    private WebElementFacade isSizeL;

    @FindBy(xpath = "//*[contains(@class,'stock-management-on')]//*[contains(@class,'odd')]//*[@class='cart_description']/small[2]/a")
    private WebElementFacade isBlueColor;
//    that two xpath are the same...

    @FindBy(className = "cart_quantity_input")
    private WebElementFacade firstWindowWithTheNumberOfItems;

    @FindBy(xpath = "//*[contains(@class,'button-plus')]//*[@class='icon-plus']")
    private WebElementFacade clickPlusQuantityButtonInSummaryLabel;

    @FindBy(xpath = "//*[contains(@class,'button-minus')]//*[@class='icon-minus']")
    private WebElementFacade clickMinusQuantityButtonInSummaryLabel;

    public void clickOnProceedToCheckoutButtonInSummaryLabel() {
        clickOnProceedToCheckoutButtonInSummaryLabel.click();
    }

    public boolean isSizeL() {
        return isSizeL.getText().contains("Size : L");
    }

    public boolean isBlueColor() {
        return isBlueColor.getText().contains("Color : Blue");
    }

    public String isQuantityAfterAddToCartEqualsTwo() {
        return firstWindowWithTheNumberOfItems.getValue();
    }

    public String isQuantityAfterAddToCartEqualsThree() {
        return firstWindowWithTheNumberOfItems.getValue();
    }

    public void clickPlusQuantityButtonInSummaryLabel() {
        clickPlusQuantityButtonInSummaryLabel.click();
        waitABit(2000);
    }

    public void clickMinusQuantityButtonInSummaryLabel() {
        clickMinusQuantityButtonInSummaryLabel.click();
        waitABit(2000);
    }
}
