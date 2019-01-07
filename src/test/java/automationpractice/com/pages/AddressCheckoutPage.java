package automationpractice.com.pages;

import automationpractice.com.domain.NewAddressData;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import static automationpractice.com.data.CommentAboutOrder.entranceFromTheYard;

public class AddressCheckoutPage extends PageObject {

    @FindBy(name = "processAddress")
    private WebElementFacade clickOnProceedToCheckoutButtonInAddressLabel;

    @FindBy(xpath = "//*[contains(@class,'address_add submit')]//*[contains(@class,'button')]")
    private WebElementFacade clickAddANewAddressButton;

    @FindBy(xpath = "//*[@id='address_delivery']//*[@class='address_firstname address_lastname']")
    private WebElementFacade nameAndLastNameInDeliveryAddress;

    @FindBy(xpath = "//*[@id='address_delivery']//*[@class='address_city address_state_name address_postcode']")
    private WebElementFacade cityAndStateAndZipCodeInDeliveryAddress;

    @FindBy(xpath = "//*[@id='center_column']//*[@class='checkbox addressesAreEquals']")
    private WebElementFacade clickDisagreeUseTheDeliveryAddressAsTheBillingAddress;

    @FindBy(xpath = "//*[@id='address_invoice']//*[@class='address_firstname address_lastname']")
    private WebElementFacade nameAndLastNameInBillingAddress;

    @FindBy(xpath = "//*[@id='address_invoice']//*[@class='address_city address_state_name address_postcode']")
    private WebElementFacade cityAndStateAndZipCodeInBillingAddress;

    @FindBy(xpath = "//*[@id='ordermsg']//*[@class='form-control']")
    private WebElementFacade addCommentInAddressTab;
    public void clickOnProceedToCheckoutButtonInAddressLabel() {
        clickOnProceedToCheckoutButtonInAddressLabel.click();
    }

    private NewAddressPage newAddressPage;

    public void clickAddANewAddressButton() {
        clickAddANewAddressButton.click();
    }

    public void selectBillingAddressFromList(NewAddressData addressData) {
        clickDisagreeUseTheDeliveryAddressAsTheBillingAddress.click();
        waitABit(1000);
        find(By.xpath("//*[@id='id_address_invoice']//*[contains(text(), '" + addressData.getNewAddressName() + "')]")).click();
    }

    public void selectDeliveryAddressFromList(NewAddressData addressData) {
        find(By.xpath("//*[@id='id_address_delivery']//*[contains(text(), '" + addressData.getNewAddressName() + "')]")).click();
    }

    public void selectDeliveryAndBillingAddressFromList(NewAddressData addressData) {
        selectDeliveryAddressFromList(addressData);
        selectBillingAddressFromList(addressData);
    }

    public String getNameAndLastNameInDeliveryInAddressCheckoutPage() {
        return nameAndLastNameInDeliveryAddress.getText();
    }

    public String getCityAndStateAndZipCodeInDeliveryInAddressCheckoutPage() {
        return cityAndStateAndZipCodeInDeliveryAddress.getText();
    }

    public String getNameAndLastNameInBillingInAddressCheckoutPage() {
        return nameAndLastNameInBillingAddress.getText();
    }

    public String getCityAndStateAndZipCodeInBillingInAddressCheckoutPage() {
        return cityAndStateAndZipCodeInBillingAddress.getText();
    }

    public void addCommentInAddressTab() {
        addCommentInAddressTab.type(entranceFromTheYard.getComment());
    }

}
