package automationpractice.com.features;

import automationpractice.com.data.NewAddressInformation;
import automationpractice.com.pages.*;
import automationpractice.com.steps.LoginSteps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;

public class CheckoutFeatures {

    private HomePage homePage;
    private HeaderBox headerBox;
    private LoginPage loginPage;
    private MyAccountPage myAccountPage;
    private FirstProductPage firstProductPage;
    private CheckoutPage checkoutPage;
    private AddressFeatures addressFeatures;
    @Steps
    private LoginSteps loginSteps;

    @Given("^logged customer is on home page$")
    public void loggedCustomerIsOnHomePage() {
        homePage.open();
        loginSteps.login();
        myAccountPage.clickMyStore();
    }

    @When("^user select first item from homepage and added it into cart$")
    public void userSelectFirstItemFromHomepageAndAddedItIntoCart() {
        homePage.clickOnNewProductImage();
        firstProductPage.clickOnAddToCartButton();
        firstProductPage.clickProceedToCheckoutButton();
    }

    @And("^he confirms every step to make order$")
    public void heConfirmsEveryStepToMakeOrder() {
        checkoutPage.clickOnProceedToCheckoutButtonInSummaryLabel();
        checkoutPage.clickOnProceedToCheckoutButtonInAddressLabel();
        checkoutPage.clickAgreeCheckbox();
        checkoutPage.clickOnProceedToCheckoutButtonInShippingLabel();
        checkoutPage.clickPayByBankWireButton();
    }

    @And("^he confirms order$")
    public void heConfirmsOrder() {
        checkoutPage.clickIConfirmMyOrder();
    }

    @Then("^order is created$")
    public void orderIsCreated() {
        Assert.assertTrue(checkoutPage.isOrderConfirmationMessage());
    }

    @When("^user select first item from homepage change quantity used plus and minus button before added to cart$")
    public void userSelectFirstItemFromHomepageChangeQuantityUsedPlusAndMinusButtonBeforeAddedToCart() {
        homePage.clickOnNewProductImage();
        firstProductPage.clickPlusQuantityButton();
        firstProductPage.clickPlusQuantityButton();
        firstProductPage.clickMinusQuantityButton();
        firstProductPage.clickOnAddToCartButton();
        firstProductPage.clickProceedToCheckoutButton();
    }

    @Then("^checkout page has two items$")
    public void checkoutPageHasTwoItems() {
        Assert.assertEquals("2", checkoutPage.isQuantityAfterAddToCartEqualsTwo());
    }

    @When("^user select first item from homepage and change size$")
    public void userSelectFirstItemFromHomepageAndChangeSize() {
        homePage.clickOnNewProductImage();
        firstProductPage.changeSize();
        firstProductPage.clickOnAddToCartButton();
        firstProductPage.clickProceedToCheckoutButton();
    }

    @Then("^checkout page has item in L size$")
    public void checkoutPageHasItemInLSize() {
        Assert.assertTrue(checkoutPage.isSizeL());
    }

    @When("^user select first item from homepage and change color$")
    public void userSelectFirstItemFromHomepageAndChangeColor() {
        homePage.clickOnNewProductImage();
        firstProductPage.changeColorToBlue();
        firstProductPage.clickOnAddToCartButton();
        firstProductPage.clickProceedToCheckoutButton();
    }

    @Then("^checkout page has item in different color$")
    public void checkoutPageHasItemInDifferentColor() {
        Assert.assertTrue(checkoutPage.isBlueColor());
    }

//    @When("^user select first item from homepage and chose twitter$")
//    public void userSelectFirstItemFromHomepageAndChoseTwitter() {
//        homePage.clickOnNewProductImage();
//        firstProductPage.clickOnTwitterButton();
//
////        firstProductPage.clickOnAddToCartButton();
////        firstProductPage.clickProceedToCheckoutButton();
//
//        System.out.println("!!!!!!!");
//        System.out.println("!!!!!!!");
//        System.out.println("!!!!!!!");
//        System.out.println(firstProductPage.getTitle());
////        firstProductPage.getDriver().switchTo().window("twitter");
//
//        Set<String> windowHandles = firstProductPage.getDriver().getWindowHandles();
//        for (String s : windowHandles){
//            System.out.println(s);
//        }
////        firstProductPage.getDriver().switchTo().frame("2147483679");
//        firstProductPage.getDriver().switchTo().window("Opublikuj tweet na Twitterze");
//
//        System.out.println("!!!!!!!");
//        System.out.println("!!!!!!!");
//        System.out.println("!!!!!!!");
//        System.out.println(firstProductPage.getTitle());
//
//    }
//
//    @Then("^new page in twitter domain is open$")
//    public void newPageInTwitterDomainIsOpern() {
//
//    }


    @Given("^logged customer is on home page and user select first item from homepage and added it into cart$")
    public void loggedCustomerIsOnHomePageAndUserSelectFirstItemFromHomepageAndAddedItIntoCart() {
        homePage.open();
        loginSteps.login();
        myAccountPage.clickMyStore();
        homePage.clickOnNewProductImage();
        firstProductPage.clickOnAddToCartButton();
        firstProductPage.clickProceedToCheckoutButton();
    }

    @When("^user change quantity used plus and minus button after added to cart$")
    public void userChangeQuantityUsedPlusAndMinusButtonAfterAddedToCart() {

//        checkoutPage.clickPlusQuantityButtonInSummaryLabel();
//        checkoutPage.clickPlusQuantityButtonInSummaryLabel();
//        checkoutPage.clickPlusQuantityButtonInSummaryLabel();
//        checkoutPage.clickPlusQuantityButtonInSummaryLabel();
//        checkoutPage.clickMinusQuantityButtonInSummaryLabel();



        checkoutPage.clickPlusQuantityButtonInSummaryLabel();
        checkoutPage.clickMinusQuantityButtonInSummaryLabel();
        checkoutPage.clickPlusQuantityButtonInSummaryLabel();
        checkoutPage.clickPlusQuantityButtonInSummaryLabel();
        checkoutPage.clickMinusQuantityButtonInSummaryLabel();
        checkoutPage.clickPlusQuantityButtonInSummaryLabel();
    }

    @Then("^checkout page has three items$")
    public void checkoutPageHasThreeItems() {
        Assert.assertEquals("3", checkoutPage.isQuantityAfterAddToCartEqualsThree());
    }

    @When("^user input new address$")
    public void userInputNewAddress() {
        checkoutPage.clickOnProceedToCheckoutButtonInSummaryLabel();
        checkoutPage.clickAddANewAddressButton();
        checkoutPage.inputExampleAddressesData();
    }

    @When("^user choices new address as delivery address$")
    public void userChoicesNewAddressAsDeliveryAddress() {
        checkoutPage.selectMyAddressList();
    }


    @Then("^the new address is selected as delivery address$")
    public void theNewAddressIsSelectedAsDeliveryAddress() {
        Assert.assertEquals((NewAddressInformation.NEW_ADDRESS_INFORMATION_1.getFirstNameAddress()
                + " " +NewAddressInformation.NEW_ADDRESS_INFORMATION_1.getLastNameAddress())
                ,checkoutPage.isDeliveryAddressCorrectNameAndLastName());


        Assert.assertEquals((NewAddressInformation.NEW_ADDRESS_INFORMATION_1.getCity()
                + ", " + NewAddressInformation.NEW_ADDRESS_INFORMATION_1.getState()
                + " " + NewAddressInformation.NEW_ADDRESS_INFORMATION_1.getZipCode())
                ,checkoutPage.isDeliveryAddressCorrectCityAndStateAndZipCode());

    }
}
