package automationpractice.com.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class PaymentCheckoutPage extends PageObject {

    @FindBy(className = "bankwire")
    private WebElementFacade payByBankWireButton;

    @FindBy(className = "cheque")
    private WebElementFacade payByCheckButton;

    @FindBy(xpath = "//*[@id='cart_navigation']//*[contains(@class,'medium')]")
    private WebElementFacade confirmMyOrderButton;

    @FindBy(className = "navigation_page")
    private WebElementFacade orderConfirmationMessage;

    @FindBy(className = "page-heading")
    private WebElementFacade paymentLabel;

    @FindBy(xpath = "//*[contains(@class,'cheque-box')]//*[contains(@class,'subheading')]")
    private WebElementFacade selectedPaymentMethod;

    @FindBy(xpath = "//*[@id='cart_navigation']//*[contains(@class,'exclusive')]")
    private WebElementFacade otherPaymentMethodButton;

    @FindBy(xpath = "//*[@id='center_column']//*[contains(@class,'default')]")
    private WebElementFacade backToOrdersButton;

    @FindBy(xpath = "//*[contains(@class,'text-center')]")
    private WebElementFacade currentQuantity;

    private String quantity;

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(final String quantity) {
        this.quantity = quantity;
    }

    public int getCurrentQuantity() {
        return Integer.parseInt(currentQuantity.getText());
    }

    public void clickPayByBankWireButton() {
        payByBankWireButton.click();
    }

    public void clickPayByCheckButton() {
        payByCheckButton.click();
    }

    public void clickIConfirmMyOrderButton() {
        confirmMyOrderButton.click();
    }

    public String orderConfirmationMessage() {
        return orderConfirmationMessage.getText().toUpperCase();
    }

    public String labelInPaymentCheckoutTab() {
        return paymentLabel.getText();
    }

    public String selectedPaymentMethod() {
        return selectedPaymentMethod.getText();
    }

    public void clickOtherPaymentMethodButton() {
        otherPaymentMethodButton.click();
    }

    public void clickBackToOrdersButtonInPaymentTab() {
        backToOrdersButton.click();
    }

}
