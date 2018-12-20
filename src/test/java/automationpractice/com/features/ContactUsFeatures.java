package automationpractice.com.features;

import automationpractice.com.pages.ContactUsPage;
import automationpractice.com.pages.HeaderBox;
import automationpractice.com.pages.HomePage;
import automationpractice.com.pages.LoginPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.SoftAssertions;

public class ContactUsFeatures {

    final private String login = "maksymilian.zaczek@solsoft.pl";
    final private String password = "12345678";

    private HomePage homePage;
    private HeaderBox headerBox;
    private LoginPage loginPage;
    private ContactUsPage contactUsPage;

    private void loginWithCredentials(String login, String password) {
        headerBox.clickOnSignIn();
        loginPage.typeLogin(login);
        loginPage.typePassword(password);
        loginPage.clickOnSignIn();
    }

    @Given("^User is on contact us page$")
    public void userIsOnContactUsPage() {
        homePage.open();
        loginWithCredentials(login, password);
        headerBox.clickOnContactUs();
    }

    @When("^he fills fields correctly$")
    public void heFillsFieldsCorrectly() {
        contactUsPage.clickOnSubjectHeadingList();
        contactUsPage.clickOnSubjectHeadingSelect();
        contactUsPage.clickOnOrderReferenceList();
        contactUsPage.clickOnOrderReferenceSelect();
        contactUsPage.typeMessage("test message");
        contactUsPage.clickOnSendMessage();
    }

    @Then("^Message is send$")
    public void messageIsSend() {
        final boolean isSuccessfullMessageSentVisible = contactUsPage.isSuccessfulMessageSentVisible();
        final SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(isSuccessfullMessageSentVisible).isTrue();
    }

    @When("^he doesn't fill every field$")
    public void heDoesnTFillEveryField() {
        contactUsPage.clickOnSendMessage();
    }

    @Then("^Message is not send$")
    public void messageIsNotSend() {
        final boolean isErrorMessageSentVisible = contactUsPage.isErrorMessageSentVisible();
        final SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(isErrorMessageSentVisible).isTrue();
    }
}
//    @Then("^he is logged in$")
//    public void heIsLoggedIn() {
//        final boolean isSignOutButtonVisible = headerBox.isSignOutButtonVisible();
//        assertThat(isSignOutButtonVisible).isTrue();
//
