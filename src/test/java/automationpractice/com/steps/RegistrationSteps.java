package automationpractice.com.steps;

import automationpractice.com.pages.RegistrationPage;

public class RegistrationSteps {

    private RegistrationPage registrationPage;


    public void registerWithEmail(final String email)
    {
        fillUpRegistrationFormWithCorrectData();
        RegistrationPage.typeEmailAddress(email);
        RegistrationPage.clickRegister();
    }

    private void fillUpRegistrationFormWithCorrectData() {
        fillUpRegistrationFormWithCorrectData();
        RegistrationPage.typeCompanyName(CORRECT_USER_REGISTRATION_DATA.getCompanyName());
        RegistrationPage.typeStreet(CORRECT_USER_REGISTRATION_DATA.getStreet());
        RegistrationPage.typeHouseNumber(CORRECT_USER_REGISTRATION_DATA.getHouseNumber());
        RegistrationPage.typePostalCode(CORRECT_USER_REGISTRATION_DATA.getPostalCode());
        RegistrationPage.typeCity(CORRECT_USER_REGISTRATION_DATA.getCity());
        RegistrationPage.typeTaxNumber(CORRECT_USER_REGISTRATION_DATA.getTaxNumber());
        RegistrationPage.checkAgreement();

    }

    public void registerWithPassword(final String password)
    {
        fillUpRegistrationFormWithCorrectData();
        RegistrationPage.typePassword(password);
        RegistrationPage.clickRegister();



}