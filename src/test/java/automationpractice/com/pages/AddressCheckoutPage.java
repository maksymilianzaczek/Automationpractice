package automationpractice.com.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import static automationpractice.com.data.NewAddressInformation.NEW_ADDRESS_INFORMATION_1;

public class AddressCheckoutPage extends PageObject {

    @FindBy(xpath = "//*[@class='button btn btn-default button-medium']")
    //It will be better to take this element
    //    @FindBy(name = "processAddress")
    private WebElementFacade clickOnProceedToCheckoutButtonInAddressLabel;

    @FindBy(xpath = "//*[contains(@class,'address_add submit')]//*[contains(@class,'button')]")
    private WebElementFacade clickAddANewAddressButton;

    private NewAddressPage newAddressPage;

    @FindBy(xpath = "//*[@id='address_delivery']//*[@class='address_firstname address_lastname']")
    private WebElementFacade nameAndLastNameInDeliveryAddress;

    @FindBy(xpath = "//*[@id='address_delivery']//*[@class='address_city address_state_name address_postcode']")
    private WebElementFacade cityAndStateAndZipCodeInDeliveryAddress;

    @FindBy(xpath = "//*[@id='center_column']//*[@class='checkbox addressesAreEquals']")
    private WebElementFacade clickDisagreeUseTheDeliveryAddressAsTheBillingAddress;

    @FindBy(xpath = "//*[@id='address_invoice']//*[@class='address_firstname address_lastname']")
    private WebElementFacade nameAndLastInBillingAddress;

    @FindBy(xpath = "//*[@id='address_invoice']//*[@class='address_city address_state_name address_postcode']")
    private WebElementFacade cityAndStateAndZipCodeInBillingAddress;

    @FindBy(xpath = "//*[@id='ordermsg']//*[@class='form-control']")
    private WebElementFacade addCommentInAddressTab;

    public void clickOnProceedToCheckoutButtonInAddressLabel() {
        clickOnProceedToCheckoutButtonInAddressLabel.click();
    }

    public void clickAddANewAddressButton() {
        clickAddANewAddressButton.click();
    }

    public void selectBillingAddressFromList() {
        clickDisagreeUseTheDeliveryAddressAsTheBillingAddress.click();
        waitABit(1000);
        find(By.xpath("//*[@id='id_address_invoice']//*[contains(text(), '" + NEW_ADDRESS_INFORMATION_1.getNewAddressName() + "')]")).click();
    }

    public void selectDeliveryAddressFromList() {
        find(By.xpath("//*[@id='id_address_delivery']//*[contains(text(), '" + NEW_ADDRESS_INFORMATION_1.getNewAddressName() + "')]")).click();
    }

    public void selectDeliveryAndBillingAddressFromList() {
        selectDeliveryAddressFromList();
        selectBillingAddressFromList();
    }

    public String getNameAndLastNameInDeliveryInAddressCheckoutPage() {
        return nameAndLastNameInDeliveryAddress.getText();
    }

    public String getCityAndStateAndZipCodeInDeliveryInAddressCheckoutPage() {
        return cityAndStateAndZipCodeInDeliveryAddress.getText();
    }

    public String isBillingAddressCorrectNameAndLastName() {
        return nameAndLastInBillingAddress.getText();
    }

    public String isBillingAddressCorrectCityAndStateAndZipCode() {
        return cityAndStateAndZipCodeInBillingAddress.getText();
    }

    public void addCommentInAddressTab() {
        addCommentInAddressTab.type("entrance from the yard!");
    }

}
