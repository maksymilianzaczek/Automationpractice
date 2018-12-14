package automationpractice.com.pages;

import com.opera.core.systems.OperaWebElement;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.w3c.dom.html.HTMLInputElement;

import java.util.Set;

public class FirstProductPage extends PageObject {

    @FindBy(id = "add_to_cart")
    private WebElementFacade clickOnAddToCartButton;

    @FindBy(xpath = "//*[contains(@class,'button-medium')]//*[contains(@class,'icon-chevron-right')]")
    private WebElementFacade clickProceedToCheckoutButton;

    @FindBy(className = "icon-plus")
    private WebElementFacade clickPlusQuantityButton;

    @FindBy(className = "icon-minus")
    private WebElementFacade clickMinusQuantityButton;

    @FindBy(xpath = "//*[@id='group_1']//option[2]")
    private WebElementFacade selectMSize;

    @FindBy(xpath = "//*[@id='group_1']//option[3]")
    private WebElementFacade selectLSize;

    @FindBy(id = "color_14")
    private WebElementFacade changeColorToBlue;

    @FindBy(className = "btn-twitter")
    private WebElementFacade clickOnTwitterButton;

    @FindBy(className = "btn-facebook")
    private WebElementFacade clickOnFacebookButton;

    @FindBy(className = "btn-google-plus")
    private WebElementFacade clickOnGooglePlusButton;

    @FindBy(className = "btn-pinterest")
    private WebElementFacade clickOnPinteresButton;

    public void clickOnAddToCartButton() {
        clickOnAddToCartButton.click();
    }

    public void clickProceedToCheckoutButton() {
        clickProceedToCheckoutButton.click();
    }

    public void clickPlusQuantityButton() {
        clickPlusQuantityButton.click();
    }

    public void clickMinusQuantityButton() {
        clickMinusQuantityButton.click();
    }

    public void changeSize() {
        selectMSize.click();
        selectLSize.click();
    }

    public void changeColorToBlue() {
        changeColorToBlue.click();
    }

    public void clickOnTwitterButton() {
        clickOnTwitterButton.click();
    }

    public void clickOnFacebookButton() {
        clickOnFacebookButton.click();
    }

    public void clickOnGooglePlusButton() {
        clickOnGooglePlusButton.click();
    }

    public void clickOnPinteresButton() {
        clickOnPinteresButton.click();
    }

    public void checkoutToTweeterWindow() {
//        System.out.println(getDriver().getCurrentUrl());
//        Set<String> windowHandles = getDriver().getWindowHandles();  //zbior otwartych okien
//        for(String s : windowHandles){
//            System.out.println(s);
//        }
        getDriver().switchTo().window("2147483679");
        waitABit(1000);
    }


    public void checkoutToFacebookWindow() {
        getDriver().switchTo().window("2147483679");
        waitABit(1000);
    }

    public void checkoutToGooglePlusWindow() {
        getDriver().switchTo().window("2147483679");
        waitABit(1000);
    }

//    public void checkoutToPinteresWindow() {
//        getDriver().switchTo().window("2147483679");
//        waitABit(6000);
//    }

    public boolean isTwitterDomain() {
        return getDriver().getCurrentUrl().contains("https://twitter.");
    }

    public boolean isFacebookDomain() {
        return getDriver().getCurrentUrl().contains("https://www.facebook.");
    }

    public boolean isGooglePlusDomain() {
        return getDriver().getCurrentUrl().contains("plus.google");
    }

//    public boolean isPinterestDomain() {
//        return getDriver().getCurrentUrl().contains("pl.pinterest");
//    }
}
