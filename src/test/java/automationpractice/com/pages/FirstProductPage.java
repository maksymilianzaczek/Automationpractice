package automationpractice.com.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;
import org.w3c.dom.html.HTMLInputElement;

public class FirstProductPage extends PageObject {

    @FindBy(className = "exclusive added")
    private WebElementFacade clickOnAddToCartButton;
    @FindBy(xpath = "//*[@title='Proceed to checkout']")
    private WebElementFacade clickProceedToCheckoutButton;

    public void clickOnAddToCartButton() {
        clickOnAddToCartButton.click();
    }


    public void clickProceedToCheckoutButton() {
        clickProceedToCheckoutButton.click();
    }
}
