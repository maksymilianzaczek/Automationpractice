package automationpractice.com.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends PageObject {

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
    @FindBy(id = "uniform-days")
    private WebElementFacade dayList;
    @FindBy(xpath = "//*[@id='days']/option[10]")
    private WebElementFacade daySelect;
    @FindBy(id = "uniform-months")
    private WebElementFacade monthsList;
    @FindBy(xpath = "//*[@id='months']/option[4]")
    private WebElementFacade monthsSelect;
    @FindBy(id = "uniform-years")
    private WebElementFacade yearsList;
    @FindBy(xpath = "//*[@id='years']/option[7]")
    private WebElementFacade yearsSelect;
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
    @FindBy(xpath = "//*[@id='id_country']/option[2]")
    private WebElementFacade countrySelect;
    @FindBy(id = "phone_mobile")
    private WebElementFacade mobilePhone;
    @FindBy(id = "submitAccount")
    private WebElementFacade registerButton;


    public void clickOnTitle() {
        titleButton.click();
    }

    public void typeFirstName(final String firstName) {
        firstNameCustomerInput.type(firstName);
    }

    public void typeLastName(final String lastName) {
        lastNameCustomerInput.type(lastName);
    }

    public void typeEmail(final String email) {
        emailInput.type(email);
    }

    public void typePasswd(final String passwd) {
        passwordInput.type(passwd);
    }

    public void clickDayList() {
        dayList.click();
    }

    public void clickDaySelect() {
        daySelect.click();
    }

    public void clickMonthsList() {
        monthsList.click();
    }

    public void clickMonthsSelect() {
        monthsSelect.click();
    }

    public void clickYearsList() {
        yearsList.click();
    }

    public void clickYearsSelect() {
        yearsSelect.click();
    }

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

    public void clickStateSelect() {
        stateSelect.click();
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

    public void clickRegisterButton() {
        registerButton.click();
    }


}

