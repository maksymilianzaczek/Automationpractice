package automationpractice.com.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class PaymentCheckoutPage extends PageObject {

    @FindBy(className = "bankwire")
    private WebElementFacade payByBankWireButton;

    @FindBy(className = "cheque")
    private WebElementFacade payByCheckButton;

    @FindBy(xpath = "//*[@id='cart_navigation']//*[contains(text(),'confirm')]")
    private WebElementFacade iConfirmMyOrderButton;

    @FindBy(className = "navigation_page")
    private WebElementFacade orderConfirmationMessage;

    @FindBy(className = "page-heading")
    private WebElementFacade paymentLabel;

    @FindBy(xpath = "//*[@class='box cheque-box']//*[@class='page-subheading']")
    private WebElementFacade selectedPaymentMethod;

    @FindBy(xpath = "//*[@id='cart_navigation']//*[contains(@class,'button-exclusive')]")
    private WebElementFacade otherPaymentMethodButton;

    @FindBy(xpath = "//*[@id='center_column']//*[contains(@class,'btn-default')]")
    private WebElementFacade backToOrdersButton;

    public void clickPayByBankWireButton() {
        payByBankWireButton.click();
    }

    public void clickPayByCheckButton() {
        payByCheckButton.click();
    }

    public void clickIConfirmMyOrderButton() {
        iConfirmMyOrderButton.click();
    }

    public boolean isOrderConfirmationMessageVisible() {
        return orderConfirmationMessage.isVisible();
    }

    public boolean isUserIsInPaymentCheckoutTab() {
        return paymentLabel.getText().contains("PLEASE CHOOSE YOUR PAYMENT METHOD");
    }

    public boolean isSelectedPayByBankWireMethod() {
        return selectedPaymentMethod.getText().contains("BANK-WIRE");
    }

    public boolean isSelectedPayByCheckMethod() {
        return selectedPaymentMethod.getText().contains("CHECK PAYMENT");
    }

    public void clickOtherPaymentMethodButton() {
        otherPaymentMethodButton.click();
    }

    public void clickBackToOrdersButtonInPaymentTab() {
        backToOrdersButton.click();
    }

}
