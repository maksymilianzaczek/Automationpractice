package automationpractice.com.features;

import automationpractice.com.pages.FooterBox;
import automationpractice.com.pages.HomePage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;

import static org.assertj.core.api.Assertions.assertThat;

public class NewsletterFeatures {

    final private String randomString = RandomStringUtils.randomAlphanumeric(13);
    final private String randomEmail = String.format("%s@gmai.com", randomString);

    private HomePage homePage;
    private FooterBox footer;

    @When("^he types correct email$")
    public void heTypesCorrectEmail() {
        footer.typeEmailRegistration(randomEmail);
        footer.clickOnNewsletter();
    }

    @Then("^his email is added to newsletter$")
    public void hisEmailIsAddedToNewsletter() {
        final boolean isSuccessfulNewsletterMessageDisplayed = homePage.isSuccessfulNewsletterMessageDisplayed();
        assertThat(isSuccessfulNewsletterMessageDisplayed).isTrue();
    }

    @When("^he types incorrect email$")
    public void heTypesIncorrectEmail() {
        footer.typeEmailRegistration("testemail@ddsad,.fs");
        footer.clickOnNewsletter();
    }

    @Then("^his email is not added to newsletter$")
    public void hisEmailIsNotAddedToNewsletter() {
        final boolean isSuccessfulNewsletterMessageDisplayed = homePage.isSuccessfulNewsletterMessageDisplayed();
        assertThat(isSuccessfulNewsletterMessageDisplayed).isFalse();
    }
}