package automationpractice.com.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class FirstProductPage extends PageObject {

    @FindBy(id = "add_to_cart")
    private WebElementFacade clickOnAddToCartButton;

    @FindBy(xpath = "//*[@class='btn btn-default button button-medium']")
    private WebElementFacade clickProceedToCheckoutButton;

    @FindBy(className = "icon-plus")
    private WebElementFacade clickPlusQuantityButton;

    @FindBy(className = "icon-minus")
    private WebElementFacade clickMinusQuantityButton;

    @FindBy(xpath = "//*[@id='group_1']//*[@title='M']")
    private WebElementFacade selectMSize;

    @FindBy(xpath = "//*[@id='group_1']//*[@title='L']")
    private WebElementFacade selectLSize;

    @FindBy(id = "color_14")
    private WebElementFacade changeColorToBlue;

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
}
