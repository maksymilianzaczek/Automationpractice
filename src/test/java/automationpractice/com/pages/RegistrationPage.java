package automationpractice.com.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage {

    @FindBy(id = "id_gender1")
    private WebElementFacade titleButton;
    @FindBy(id = "customer_firstname")
    private WebElementFacade firstNameCustomerInput;
    @FindBy(id = "customer_lastname")
    private WebElementFacade lastNameCustomerInput;
    @FindBy(id = "email")
    private WebElementFacade emailInput;
    @FindBy(id = "passwd")
    private WebElementFacade passwordInput;
    @FindBy(id = "days")
    private WebElementFacade dayList;
    @FindBy(xpath = "//*[@id='days']/option[10]")
    private WebElementFacade daySelect;
    @FindBy(id = "months")
    private WebElementFacade monthsList;
    @FindBy(xpath = "//*[@id='months']/option[4]")
    private WebElementFacade monthsSelect;
    @FindBy(id = "years")
    private WebElementFacade yearsList;
    @FindBy(xpath = "//*[@id='years']/option[7]")
    private WebElementFacade yearsSelect;
    @FindBy(id = "firstname")
    private WebElementFacade firstnameAddressInput;
    @FindBy(id = "lastname")
    private WebElementFacade lastnameAddressInput;
    @FindBy(id = "address1")
    private WebElementFacade addressInput;
    @FindBy(id = "city")
    private WebElementFacade cityInput;
    @FindBy(id = "id_state")
    private WebElementFacade stateList;
    @FindBy(xpath = "//*[@id='id_state']/option[13]")
    private WebElementFacade stateSelect;
    @FindBy(id = "postcode")
    private WebElementFacade postcode;
    @FindBy(id = "id_country")
    private WebElementFacade countryList;
    @FindBy(xpath = "//*[@id='id_country']/option[2]")
    private WebElementFacade countrySelect;
    @FindBy(id = "phone_mobile")
    private WebElementFacade mobilePhone;
    @FindBy(id = "submitAccount")
    private WebElementFacade registerButton;


    public void clickOnTitle() {
        titleButton.click();
    }

    public void typeFirstName() {
        firstNameCustomerInput.type();
    }

    public void typeLastName() {
        lastNameCustomerInput.type();
    }

    public void typeEmail() {
        emailInput.type();
    }

    public void typePasswd() {
        passwordInput.type();
    }

    public void clickDayList() { dayList.click(); }

    public void clickDaySelect() { daySelect.click(); }

    public void clickMonthsList() { monthsList.click(); }

    public void clickMonthsSelect() { monthsSelect.click(); }

    public void clickYearsList() { yearsList.click(); }

    public void clickYearsSelect() { yearsSelect.click(); }

    public void typeFirstNameAddress() { firstnameAddressInput.type(); }

    public void typeLastNameAddress() { lastNameCustomerInput.type(); }

    public void typeAddress() { addressInput.type(); }

    public void typeCity() { cityInput.type(); }

    public void clickStateList() { stateList.click(); }

    public void clickStateSelect() { stateSelect.click(); }

    public void typePostCode() { postcode.type(); }

    public void clickCountryList() { countryList.click(); }

    public void clickCountrySelect() { countrySelect.click(); }

    public void typeMobilePhone() { mobilePhone.type(); }

    public void clickRegisterButton() { registerButton.click(); }


}

