package automationpractice.com.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

public class NewAddressPage extends PageObject {


    @FindBy(id = "firstname")
    private WebElementFacade firstNameAddressInput;
    @FindBy(id = "lastname")
    private WebElementFacade lastnameAddressInput;
    @FindBy(id = "address1")
    private WebElementFacade addressInput;
    @FindBy(id = "city")
    private WebElementFacade cityInput;
    @FindBy(id = "uniform-id_state")
    private WebElementFacade stateList;
    @FindBy(xpath = "//*[@id='id_state']/option[13]")
    private WebElementFacade stateSelect;
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
    private WebElementFacade saveNewAddressButton;
    @FindBy(xpath = "//*[@class='alert alert-danger']")
    private WebElementFacade errorMessage;

    public void typeFirstNameAddress(final String firstNameAddress) {
        firstNameAddressInput.type(firstNameAddress);
    }

    public void typeLastNameAddress(final String lastNameAddress) {
        lastnameAddressInput.type(lastNameAddress);
    }

    public void typeAddress(final String address) {
        addressInput.type(address);
    }

    public void typeCity(final String city) {
        cityInput.type(city);
    }

    public void clickStateList() {
        find(By.xpath("//*[@id='id_state']//*[contains(text(), 'Arizona')]"));
        stateList.click();
    }

    public void clickStateSelect(final String state) {
        final String stateSelectXpath = String.format("//*[@id='id_state']//*[contains(text(), '%s')]", state);
        find(By.xpath(stateSelectXpath)).click();
    }

    public void typePostCode(final String postCode) {
        postcode.type(postCode);
    }

    public void clickCountryList() {
        countryList.click();
    }

    public void clickCountrySelect() {
        countrySelect.click();
    }

    public void typeMobilePhone(final String mobilephone) {
        mobilePhone.type(mobilephone);
    }

    public void clickSaveNewAddressButton() {
        saveNewAddressButton.click();
    }


    public boolean isErrorMessageForNewAddressVisible() {
        return errorMessage.isVisible();
    }

    public void typeTitle(final String titleAddress) {
        title.type(titleAddress);
    }
}