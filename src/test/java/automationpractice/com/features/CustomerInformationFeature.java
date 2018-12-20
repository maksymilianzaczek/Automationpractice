package automationpractice.com.features;

import automationpractice.com.pages.CustomerInformationPage;
import automationpractice.com.pages.HomePage;
import automationpractice.com.pages.MyAccountPage;
import automationpractice.com.steps.LoginSteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

import static automationpractice.com.data.Users.MACIEJ_STAFIJOWSKI;
import static org.assertj.core.api.Assertions.assertThat;

public class CustomerInformationFeature {

    private HomePage homePage;
    @Steps
    private LoginSteps loginSteps;
    private MyAccountPage myAccountPage;
    private CustomerInformationPage customerInformationPage;

    @Given("^logged in customer is on customer information page$")
    public void loggedInCustomerIsOnCustomerInformationPage() {
        homePage.open();
        loginSteps.login();
        myAccountPage.clickPersonalInformation();
    }

    @When("^he edit his personal information$")
    public void heEditHisPersonalInformation() {
        customerInformationPage.editFirstName(MACIEJ_STAFIJOWSKI.getFirstName());
        customerInformationPage.editLastName(MACIEJ_STAFIJOWSKI.getLastName());
        customerInformationPage.editEmailAddress(MACIEJ_STAFIJOWSKI.getLogin());
        customerInformationPage.enterPassword(MACIEJ_STAFIJOWSKI.getPassword());
        customerInformationPage.clickSaveButton();

    }

    @Then("^personal information are changed$")
    public void personalInformationAreChanged() {
        assertThat(customerInformationPage.isMessageVisible()).isTrue();
    }
}