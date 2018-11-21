package automationpractice.com.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

import java.awt.*;

public class NewAddressPage extends PageObject {

    @FindBy(id = "firstname")
    private WebElementFacade firstNameInput;

    @FindBy(id = "lastname")
    private WebElementFacade lastNameInput;

    @FindBy(id = "address1")
    private WebElementFacade addresRowInput;

    @FindBy(id = "city")
    private WebElementFacade cityNameInput;

    @FindBy(id = "uniform-id_state")
    private WebElementFacade stateList;

    @FindBy(xpath = " //*[@id='id_state']/option[6]")
    private WebElementFacade selectState;

    @FindBy(id = "postcode")
    private WebElementFacade postalCodeInput;

    @FindBy(id = "uniform-id_country")
    private WebElementFacade countryList;

    @FindBy(xpath = "//*[@id='id_country']/option[1]")
    private WebElementFacade selectCountry;

    @FindBy(id = "phone")
    private WebElementFacade mobilePhoneNumberInput;

    @FindBy(id = "alias")
    private WebElementFacade titleInput;

    @FindBy(id = "submitAddress")
    private WebElementFacade saveNewAddressButton;

    @FindBy(xpath = "//*[@class='alert alert-danger']")
    private WebElementFacade errorMessageOnNewAddressPage;

    public void typeAddressFirstName() {
        firstNameInput.type("Maciej");
    }

    public void typeAddressLastName() {
        lastNameInput.type("test");
    }

    public void typeAddress() {
        addresRowInput.type("address");
    }

    public void typeCity() {
        cityNameInput.type("Wrocław");
    }

    public void clickStateList() {
        stateList.click();
    }

    public void clickStateSelect() {
        selectState.click();
    }

    public void typePostalCode() {
        postalCodeInput.type("55555");
    }

    public void clickCountryList() {
        countryList.click();
    }

    public void clickCountrySelect() {
        selectCountry.click();
    }

    public void typeMobilePhone() {
        mobilePhoneNumberInput.type("111 222 333");
    }

    public void typeTitle(String myAddress) {
        titleInput.click();
    }

    public void clickSaveNewAddressButton() {
        saveNewAddressButton.click();
    }

    public boolean isErrorMessageForNewAddressVisible() {
        return errorMessageOnNewAddressPage.isVisible();
    }
}
