package automationpractice.com.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import static automationpractice.com.data.NewAddressInformation.NEW_ADDRESS_INFORMATION_1;

public class CheckoutPage extends PageObject {

//    You can create several checkout page - summaryCheckoutPage, SignInCheckoutPage...

    @FindBy(className = "standard-checkout")
    private WebElementFacade clickOnProceedToCheckoutButtonInSummaryLabel;

    @FindBy(xpath = "//*[@class='button btn btn-default button-medium']")
    //It will be better to take this element
    //    @FindBy(name = "processAddress")
    private WebElementFacade clickOnProceedToCheckoutButtonInAddressLabel;

    @FindBy(className = "standard-checkout")
    private WebElementFacade clickOnProceedToCheckoutButtonInShippingLabel;

    @FindBy(id = "uniform-cgv")
    private WebElementFacade clickAgreeCheckbox;

    @FindBy(className = "bankwire")
    private WebElementFacade clickPayByBankWireButton;

    @FindBy(className = "cheque")
    private WebElementFacade clickPayByCheckButton;

    @FindBy(xpath = "//*[@id='cart_navigation']/button")
    //
    private WebElementFacade clickIConfirmMyOrder;

    @FindBy(xpath = "//*[@class='navigation_page']")
//    I think it will be better to use className="alert-success"
    private WebElementFacade isOrderConfirmationMessage;

    @FindBy(className = "cart_quantity_input")
    private WebElementFacade firstWindowWithTheNumberOfItems;

    @FindBy(xpath = "//*[contains(@class,'stock-management-on')]//*[contains(@class,'odd')]//*[@class='cart_description']/small[2]/a")
    private WebElementFacade isSizeL;

    @FindBy(xpath = "//*[contains(@class,'stock-management-on')]//*[contains(@class,'odd')]//*[@class='cart_description']/small[2]/a")
    private WebElementFacade isBlueColor;
//    that two xpath are the same...

    @FindBy(xpath = "//*[contains(@class,'button-plus')]//*[@class='icon-plus']")
    private WebElementFacade clickPlusQuantityButtonInSummaryLabel;

    @FindBy(xpath = "//*[contains(@class,'button-minus')]//*[@class='icon-minus']")
    private WebElementFacade clickMinusQuantityButtonInSummaryLabel;

    @FindBy(xpath = "//*[contains(@class,'address_add submit')]//*[contains(@class,'button')]")
    private WebElementFacade clickAddANewAddressButton;

    private NewAddressPage newAddressPage;

    @FindBy(xpath = "//*[@id='address_delivery']//*[@class='address_firstname address_lastname']")
    private WebElementFacade nameAndLastInDeliveryAddress;

    @FindBy(xpath = "//*[@id='address_delivery']//*[@class='address_city address_state_name address_postcode']")
    private WebElementFacade cityAndStateAndZipCodeInDeliveryAddress;

    @FindBy(xpath = "//*[@id='center_column']//*[@class='checkbox addressesAreEquals']")
    private WebElementFacade clickDisagreeUseTheDeliveryAddressAsTheBillingAddress;

    @FindBy(xpath = "//*[@id='address_invoice']//*[@class='address_firstname address_lastname']")
    private WebElementFacade nameAndLastInBillingAddress;

    @FindBy(xpath = "//*[@id='address_invoice']//*[@class='address_city address_state_name address_postcode']")
    private WebElementFacade cityAndStateAndZipCodeInBillingAddress;

    @FindBy(className = "fancybox-error")
    private WebElementFacade newAlertAppearInShippingLabel;

    @FindBy(className = "page-heading")
    private WebElementFacade isPaymentLabel;

    @FindBy(xpath = "//*[contains(@class,'fancybox-close')]")
    private WebElementFacade closeAlertInShippingLabel;

    @FindBy(xpath = "//*[@class='box cheque-box']//*[@class='page-subheading']")
    private WebElementFacade selectedPayMethod;

    @FindBy(xpath = "//*[@id='cart_navigation']//*[contains(@class,'button-exclusive')]")
    private WebElementFacade clickOtherPaymentMethods;

    @FindBy(xpath = "//*[@id='ordermsg']//*[@class='form-control']")
    private WebElementFacade addCommentInAddressTab;

    @FindBy(xpath = "//*[@id='center_column']//*[contains(@class,'btn-default')]")
    private WebElementFacade clickBackToOrdersButtonInPaymentTab;

    @FindBy(xpath = "//*[@id='order-list']//*[@class='first_item ']//*[contains(@class,'button-small')]")
    private WebElementFacade clickDetailsButtonForLastOneOrders;

    @FindBy(xpath = "//*[@id='block-order-detail']//*[contains(text(),'entrance from the yard')]" )
    private WebElementFacade isCommentAboutAddressInLastOneOrders;

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

    public void clickPayByCheckButton() {
        clickPayByCheckButton.click();
    }

    public void clickIConfirmMyOrder() {
        clickIConfirmMyOrder.click();
    }

    public boolean isOrderConfirmationMessage() {
        return isOrderConfirmationMessage.isVisible();
    }

    public String isQuantityAfterAddToCartEqualsTwo() {
        return firstWindowWithTheNumberOfItems.getValue();
    }

    public String isQuantityAfterAddToCartEqualsThree() {
        return firstWindowWithTheNumberOfItems.getValue();
    }

    public boolean isSizeL() {
        return isSizeL.getText().contains("Size : L");
    }

    public boolean isBlueColor() {
        return isBlueColor.getText().contains("Color : Blue");
    }

    public void clickPlusQuantityButtonInSummaryLabel() {
        clickPlusQuantityButtonInSummaryLabel.click();
        waitABit(2000);
    }

    public void clickMinusQuantityButtonInSummaryLabel() {
        clickMinusQuantityButtonInSummaryLabel.click();
        waitABit(2000);
    }

    public void clickAddANewAddressButton() {
        clickAddANewAddressButton.click();
    }

    public void inputExampleAddressesData() {
        newAddressPage.typeFirstNameAddress(NEW_ADDRESS_INFORMATION_1.getFirstNameAddress());
        newAddressPage.typeLastNameAddress(NEW_ADDRESS_INFORMATION_1.getLastNameAddress());
        newAddressPage.typeAddress(NEW_ADDRESS_INFORMATION_1.getAddress());
        newAddressPage.typeCity(NEW_ADDRESS_INFORMATION_1.getCity());
        newAddressPage.typePostCode(NEW_ADDRESS_INFORMATION_1.getZipCode());
        newAddressPage.clickCountryList();
        newAddressPage.clickCountrySelect();
        newAddressPage.typeMobilePhone(NEW_ADDRESS_INFORMATION_1.getMobilePhone());
        newAddressPage.typeTitle(NEW_ADDRESS_INFORMATION_1.getNewAddressName());
        newAddressPage.clickStateList();
        newAddressPage.clickStateSelect(NEW_ADDRESS_INFORMATION_1.getState());
        newAddressPage.clickSaveNewAddressButton();
    }

    public void selectDeliveryAddressFromList() {
        find(By.xpath("//*[@id='id_address_delivery']//*[contains(text(), '"+NEW_ADDRESS_INFORMATION_1.getNewAddressName()+"')]")).click();
    }

    public void selectBillingAddressFromList() {
        clickDisagreeUseTheDeliveryAddressAsTheBillingAddress.click();
        waitABit(1000);
        find(By.xpath("//*[@id='id_address_invoice']//*[contains(text(), '"+NEW_ADDRESS_INFORMATION_1.getNewAddressName()+"')]")).click();
    }

    public void selectDeliveryAndBillingAddressFromList() {
        selectDeliveryAddressFromList();
        selectBillingAddressFromList();
    }

    public String isDeliveryAddressCorrectNameAndLastName() {
        return nameAndLastInDeliveryAddress.getText();
    }

    public String isDeliveryAddressCorrectCityAndStateAndZipCode() {
        return cityAndStateAndZipCodeInDeliveryAddress.getText();
    }

    public String isBillingAddressCorrectNameAndLastName() {
        return nameAndLastInBillingAddress.getText();
    }

    public String isBillingAddressCorrectCityAndStateAndZipCode() {
        return cityAndStateAndZipCodeInBillingAddress.getText();
    }

    public boolean newAlertAppear() {
        return newAlertAppearInShippingLabel.isVisible();
    }

    public void closeAlertInShippingLabel() {
        closeAlertInShippingLabel.click();
        waitABit(500);
    }

    public boolean isPaymentLabel() {
        return isPaymentLabel.getText().contains("PLEASE CHOOSE YOUR PAYMENT METHOD");
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

    public void addCommentInAddressTab() {
        addCommentInAddressTab.type("entrance from the yard!");
    }

    public void clickBackToOrdersButtonInPaymentTab() {
        clickBackToOrdersButtonInPaymentTab.click();
    }

    public void clickDetailsButtonForLastOneOrders() {
        clickDetailsButtonForLastOneOrders.click();
    }

    public boolean isCommentAboutAddressInLastOneOrders() {
        return isCommentAboutAddressInLastOneOrders.getText().contains("entrance from the yard");
    }
}
