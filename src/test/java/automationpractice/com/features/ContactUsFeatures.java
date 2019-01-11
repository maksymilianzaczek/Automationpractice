package automationpractice.com.features;

import automationpractice.com.pages.ContactUsPage;
import automationpractice.com.pages.HeaderBox;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

public class ContactUsFeatures {

    private HeaderBox headerBox;
    private ContactUsPage contactUsPage;


    @When("^user opens contact us page$")
    public void userOpensContactUsPage() {
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

    @Then("^message is send$")
    public void messageIsSend() {
        final boolean isSuccessfulMessageSentVisible = contactUsPage.isSuccessfulMessageSentVisible();
        assertThat(isSuccessfulMessageSentVisible).isTrue();
    }

    @When("^he doesn't fill every field$")
    public void heDoesnTFillEveryField() {
        contactUsPage.clickOnSendMessage();
    }

    @Then("^message is not send$")
    public void messageIsNotSend() {
        final boolean isErrorMessageSentVisible = contactUsPage.isErrorMessageSentVisible();
        assertThat(isErrorMessageSentVisible).isTrue();
    }
}

