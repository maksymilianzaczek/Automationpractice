package automationpractice.com.steps;

import automationpractice.com.pages.RegistrationPage;

import static automationpractice.com.data.NewUserInformation.NEW_ACCOUNT_CREATION;

public class RegistrationSteps {


    private RegistrationPage registrationPage;


    public void registerWithEmail(final String email) {
        fillUpRegistrationFormWithCorrectData();
        registrationPage.typeEmail(email);
        registrationPage.clickRegisterButton();
    }

    public void registerWithPassword(final String password) {
        fillUpRegistrationFormWithCorrectData();
        registrationPage.typePasswd(password);
        registrationPage.clickRegisterButton();
    }

    private void fillUpRegistrationFormWithCorrectData() {
        fillUpRegistrationFormWithCorrectData();
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


}