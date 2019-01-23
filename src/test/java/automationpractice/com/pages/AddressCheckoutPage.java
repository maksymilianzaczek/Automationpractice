package automationpractice.com.pages;

import automationpractice.com.domain.NewAddressData;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import static automationpractice.com.data.CommentAboutOrder.entranceFromTheYard;

public class AddressCheckoutPage extends PageObject {

    @FindBy(name = "processAddress")
    private WebElementFacade proceedToCheckoutButton;

    @FindBy(xpath = "//*[contains(@class,'address_add')]//*[contains(@class,'button')]")
    private WebElementFacade newAddressButton;

    @FindBy(xpath = "//*[@id='address_delivery']//*[contains(@class,'lastname')]")
    private WebElementFacade nameAndLastNameInDeliveryAddress;

    @FindBy(xpath = "//*[@id='address_delivery']//*[contains(@class,'address_city')]")
    private WebElementFacade cityAndStateAndZipCodeInDeliveryAddress;

    @FindBy(xpath = "//*[@id='center_column']//*[contains(@class,'addressesAreEquals')]")
    private WebElementFacade useTheDeliveryAddressAsTheBillingAddressCheckbox;

    @FindBy(xpath = "//*[@id='address_invoice']//*[contains(@class,'address_lastname')]")
    private WebElementFacade nameAndLastNameInBillingAddress;

    @FindBy(xpath = "//*[@id='address_invoice']//*[contains(@class,'address_city')]")
    private WebElementFacade cityAndStateAndZipCodeInBillingAddress;

    @FindBy(xpath = "//*[@id='ordermsg']//*[@class='form-control']")
    private WebElementFacade comment;

    @FindBy(id = "address_invoice_form")
    private WebElementFacade chooseABillingAddressText;

    private String xpathToBillingAddressesList = "//*[@id='id_address_invoice']//*[contains(text(), '%s')]";
    private String xpathToDeliveryAddressList = "//*[@id='id_address_delivery']//*[contains(text(), '%s')]";

    public void clickOnProceedToCheckoutButton() {
        proceedToCheckoutButton.click();
    }

    public void clickAddANewAddressButton() {
        newAddressButton.click();
    }

    public void selectBillingAddressFromList(final NewAddressData addressData) {
        useTheDeliveryAddressAsTheBillingAddressCheckbox.click();
        chooseABillingAddressText.waitUntilVisible();
        String xpathToInputedAddress = String.format(xpathToBillingAddressesList, addressData.getNewAddressName());
        find(By.xpath(xpathToInputedAddress)).click();
    }

    public void selectDeliveryAddressFromList(final NewAddressData addressData) {
        String xpathToInputedAddress = String.format(xpathToDeliveryAddressList, addressData.getNewAddressName());
        find(By.xpath(xpathToInputedAddress)).click();
    }

    public void selectDeliveryAndBillingAddressFromList(final NewAddressData addressData) {
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

    public void addCommentEntranceFromTheYard() {
        comment.type(entranceFromTheYard.getComment());
    }

}
