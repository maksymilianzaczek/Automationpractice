package automationpractice.com.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

public class EditAddressPage extends PageObject {


    @FindBy(id = "firstname")
    private WebElementFacade firstNameField;
    @FindBy(id = "lastname")
    private WebElementFacade lastnameField;
    @FindBy(id = "address1")
    private WebElementFacade addressField;
    @FindBy(id = "city")
    private WebElementFacade cityField;
    @FindBy(id = "uniform-id_state")
    private WebElementFacade stateList;
    @FindBy(id = "postcode")
    private WebElementFacade postcode;
    @FindBy(id = "uniform-id_country")
    private WebElementFacade countryList;
    @FindBy(xpath = "//*[@id='id_country']/option[1]")
    private WebElementFacade countrySelect;
    @FindBy(id = "phone_mobile")
    private WebElementFacade mobilePhone;
    @FindBy(id = "alias")
    private WebElementFacade title;
    @FindBy(id = "submitAddress")
    private WebElementFacade saveAddressButton;
    @FindBy(id = "phone")
    private WebElementFacade homePhone;
    @FindBy(className = "alert-danger")
    private WebElementFacade errorMessage;

    public void changeFirstName(final String firstName) {
        firstNameField.type(firstName);
    }

    public void changeLastName(final String lastName) {
        lastnameField.type(lastName);
    }

    public void changeAddress(final String address) {
        addressField.type(address);
    }

    public void changeCity(final String city) {
        cityField.type(city);
    }

    public void changePostCode(final String zipCode) {
        postcode.type(zipCode);
    }

    public void clickCountryList() {
        countryList.click();
    }

    public void clickCountrySelect() {
        countrySelect.click();
    }

    public void changeMobilePhone(final String mobilePhoneNumber) {
        mobilePhone.type(mobilePhoneNumber);
    }

    public void changeTitle(final String addressName) {
        title.type(addressName);
    }

    public void clickStateList() {
        stateList.click();
    }

    public void clickStateSelect(final String state) {
        final String stateSelectXpath = String.format("//*[@id='id_state']//*[contains(text(), '%s')]", state);
        find(By.xpath(stateSelectXpath)).click();
    }

    public void clickSaveAddress() {
        saveAddressButton.click();
    }

    public void changeHomePhone(final String homePhoneNumber) {
        homePhone.type(homePhoneNumber);
    }

    public boolean errorMessageIsDisplayed() {
        return errorMessage.isVisible();
    }
}
