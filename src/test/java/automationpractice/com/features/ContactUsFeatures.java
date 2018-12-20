package automationpractice.com.features;

import automationpractice.com.pages.ContactUsPage;
import automationpractice.com.pages.HeaderBox;
import automationpractice.com.pages.HomePage;
import automationpractice.com.pages.LoginPage;
import automationpractice.com.steps.LoginSteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.SoftAssertions;

public class ContactUsFeatures {

    private HomePage homePage;
    private HeaderBox headerBox;
    private LoginPage loginPage;
    private ContactUsPage contactUsPage;
    private LoginSteps loginSteps;


    @Given("^User is on contact us page$")
    public void userIsOnContactUsPage() {
        homePage.open();
        loginSteps.login();
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
        final boolean isSuccessfulMessageSentVisible = contactUsPage.isSuccessfulMessageSentVisible();
        final SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(isSuccessfulMessageSentVisible).isTrue();
        softAssertions.assertAll();

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
        softAssertions.assertAll();
    }
}

