package automationpractice.com.pages;

import automationpractice.com.data.NewAddressInformation;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import static automationpractice.com.data.NewAddressInformation.NEW_ADDRESS_INFORMATION_1;

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
    private WebElementFacade firstWindowWithTheNumberOfItems;

    @FindBy(xpath = "//*[contains(@class,'stock-management-on')]//*[contains(@class,'odd')]//*[@class='cart_description']/small[2]/a")
    private WebElementFacade isSizeL;

    @FindBy(xpath = "//*[contains(@class,'stock-management-on')]//*[contains(@class,'odd')]//*[@class='cart_description']/small[2]/a")
    private WebElementFacade isBlueColor;

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

    }

    public void clickMinusQuantityButtonInSummaryLabel() {
        clickMinusQuantityButtonInSummaryLabel.click();
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

    public void selectMyAddressList() {
        find(By.xpath("//*[@id='id_address_delivery']//*[contains(text(), '"+NEW_ADDRESS_INFORMATION_1.getNewAddressName()+"')]")).click();
    }

    public String isDeliveryAddressCorrectNameAndLastName() {
        return nameAndLastInDeliveryAddress.getText();
    }

    public String isDeliveryAddressCorrectCityAndStateAndZipCode() {
        return cityAndStateAndZipCodeInDeliveryAddress.getText();
    }
}
