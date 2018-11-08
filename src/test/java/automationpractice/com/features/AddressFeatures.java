package automationpractice.com.features;

import automationpractice.com.pages.HeaderBox;
import automationpractice.com.pages.HomePage;
import automationpractice.com.pages.LoginPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.SoftAssertions;

import static org.assertj.core.api.Assertions.assertThat;

public class AddressFeatures {

    final private String login = "maks.zaczek@solsoft.pl";
    final private String password = "12345678";

    private HomePage homePage;
    private HeaderBox headerBox;
    private LoginPage loginPage;

    @Given("^logged in customer is on address page$")
    public void loggedInCustomerIsOnAddressPage() {
        homePage.open();
        headerBox.clickOnSignIn();
        loginPage.typeLogin(login);
        loginPage.typePassword(password);
        loginPage.clickOnSignIn();

    }


}
