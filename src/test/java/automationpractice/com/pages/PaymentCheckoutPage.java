package automationpractice.com.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class PaymentCheckoutPage extends PageObject {

    @FindBy(className = "bankwire")
    private WebElementFacade clickPayByBankWireButton;

    @FindBy(className = "cheque")
    private WebElementFacade clickPayByCheckButton;

    @FindBy(xpath = "//*[@id='cart_navigation']/button")
    //
    private WebElementFacade clickIConfirmMyOrder;

    @FindBy(xpath = "//*[@class='navigation_page']")
//    I think it will be better to use className="alert-success"
    private WebElementFacade orderConfirmationMessage;

    @FindBy(className = "page-heading")
    private WebElementFacade paymentLabel;



    @FindBy(xpath = "//*[@class='box cheque-box']//*[@class='page-subheading']")
    private WebElementFacade selectedPayMethod;

    @FindBy(xpath = "//*[@id='cart_navigation']//*[contains(@class,'button-exclusive')]")
    private WebElementFacade clickOtherPaymentMethods;


    @FindBy(xpath = "//*[@id='center_column']//*[contains(@class,'btn-default')]")
    private WebElementFacade clickBackToOrdersButtonInPaymentTab;





    public void clickPayByBankWireButton() {
        clickPayByBankWireButton.click();
    }

    public void clickPayByCheckButton() {
        clickPayByCheckButton.click();
    }

    public void clickIConfirmMyOrder() {
        clickIConfirmMyOrder.click();
    }

    public boolean isOrderConfirmationMessageVisible() {
        return orderConfirmationMessage.isVisible();
    }

    public boolean isUserIsInPaymentCheckoutTab() {
        return paymentLabel.getText().contains("PLEASE CHOOSE YOUR PAYMENT METHOD");
    }

    public boolean isSelectedPayByBankWire() {
        return selectedPayMethod.getText().contains("BANK-WIRE");
    }

    public boolean isSelectedPayByCheck() {
        return selectedPayMethod.getText().contains("CHECK PAYMENT");
    }

    public void clickOtherPaymentMethods() {
        clickOtherPaymentMethods.click();
    }


    public void clickBackToOrdersButtonInPaymentTab() {
        clickBackToOrdersButtonInPaymentTab.click();
    }

}
