package automationpractice.com.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

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

//    @FindBy(className = "btn-twitter")
//    private WebElementFacade clickOnTwitterButton;

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

//    public void clickOnTwitterButton() {
//        clickOnTwitterButton.click();
//    }
}
