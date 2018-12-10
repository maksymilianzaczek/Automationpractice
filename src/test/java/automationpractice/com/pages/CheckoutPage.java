package automationpractice.com.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends PageObject {

    @FindBy(className = "standard-checkout")
    private WebElementFacade clickOnProceedToCheckoutButtonInSummaryLabel;

    @FindBy(xpath = "//*[@class='button btn btn-default button-medium']")
    private WebElementFacade clickOnProceedToCheckoutButtonInAddressLabel;

    @FindBy(className = "standard-checkout")
    private WebElementFacade clickOnProceedToCheckoutButtonInShippingLabel;

    @FindBy(id = "uniform-cgv")
    private WebElementFacade clickAgreeCheckbox;

    @FindBy(className = "bankwire")
    private WebElementFacade clickPayByBankWireButton;

    @FindBy(xpath = "//*[@id='cart_navigation']/button")
    private WebElementFacade clickIConfirmMyOrder;

    @FindBy(xpath = "//*[@class='navigation_page']")
    private WebElementFacade isOrderConfirmationMessage;

    @FindBy(className = "cart_quantity_input")
    private WebElementFacade isQuantityCorrect;

    @FindBy(xpath = "//*[@id='product_1_5_0_121046']/td[2]/small[2]/a")
    private WebElementFacade isSizeL;

    @FindBy(xpath ="//*[@id='product_1_2_0_121046']/td[2]/small[2]/a")
    private WebElementFacade isBlueColor;

    public void clickOnProceedToCheckoutButtonInSummaryLabel() {
        clickOnProceedToCheckoutButtonInSummaryLabel.click();
    }

    public void clickOnProceedToCheckoutButtonInAddressLabel() {
        clickOnProceedToCheckoutButtonInAddressLabel.click();
    }

    public void clickOnProceedToCheckoutButtonInShippingLabel() {
        clickOnProceedToCheckoutButtonInShippingLabel.click();
    }

    public void clickAgreeCheckbox() {
        clickAgreeCheckbox.click();
    }

    public void clickPayByBankWireButton() {
        clickPayByBankWireButton.click();
    }

    public void clickIConfirmMyOrder() {
        clickIConfirmMyOrder.click();
    }

    public boolean isOrderConfirmationMessage() {
        return isOrderConfirmationMessage.isVisible();
    }

    public String isQuantityCorrect() {
        return isQuantityCorrect.getValue();
    }

    public boolean isSizeL() {
        return isSizeL.getText().contains("Size : L");
    }

    public boolean isBlueColor() {
        return isBlueColor.getText().contains("Color : Blue");
    }
}
