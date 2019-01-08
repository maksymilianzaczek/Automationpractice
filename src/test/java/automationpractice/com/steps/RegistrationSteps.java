package automationpractice.com.steps;

import automationpractice.com.pages.LoginPage;
import automationpractice.com.pages.RegistrationPage;
import net.thucydides.core.annotations.Step;

import static automationpractice.com.data.NewUserInformation.NEW_ACCOUNT_CREATION;
import static automationpractice.com.data.Users.RANDOM_EMAIL;

public class RegistrationSteps {

    private RegistrationPage registrationPage;
    private LoginPage loginPage;

    @Step
    public void fillRegistrationForm() {
        registrationPage.clickOnTitle();
        registrationPage.typeFirstName(NEW_ACCOUNT_CREATION.getFirstName());
        registrationPage.typeLastName(NEW_ACCOUNT_CREATION.getLastName());
        registrationPage.typePasswd(NEW_ACCOUNT_CREATION.getPassword());
        registrationPage.clickDayList();
        registrationPage.clickDaySelect();
        registrationPage.clickMonthsList();
        registrationPage.clickMonthsSelect();
        registrationPage.clickYearsList();
        registrationPage.clickYearsSelect();
        registrationPage.typeFirstNameAddress(NEW_ACCOUNT_CREATION.getFirstNameAddress());
        registrationPage.typeLastNameAddress(NEW_ACCOUNT_CREATION.getLastNameAddress());
        registrationPage.typeAddress(NEW_ACCOUNT_CREATION.getAddress());
        registrationPage.typeCity(NEW_ACCOUNT_CREATION.getCity());
        registrationPage.typePostCode(NEW_ACCOUNT_CREATION.getZipCode());
        registrationPage.typeMobilePhone(NEW_ACCOUNT_CREATION.getMobilePhone());
        registrationPage.clickCountryList();
        registrationPage.clickCountrySelect();
        registrationPage.clickStateList();
        registrationPage.clickStateSelect();
        registrationPage.clickRegisterButton();
    }

    @Step
    public void createNewAccount() {
        loginPage.typeEmailRegistration(RANDOM_EMAIL);
        loginPage.clickOnCreateAnAccount();
    }
}
