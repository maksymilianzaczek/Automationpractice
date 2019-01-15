package automationpractice.com.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class SummaryCheckoutPage extends PageObject {

    @FindBy(className = "standard-checkout")
    private WebElementFacade proceedToCheckoutButton;

    @FindBy(xpath = "//*[contains(@class,'stock-management-on')]//*[contains(@class,'odd')]//*[@class='cart_description']/small[2]/a")
    private WebElementFacade colorAndSizeFirstProduct;

    @FindBy(className = "cart_quantity_input")
    private WebElementFacade quantityOfItems;

    @FindBy(xpath = "//*[contains(@class,'button-plus')]//*[@class='icon-plus']")
    private WebElementFacade clickPlusQuantityButton;

    @FindBy(xpath = "//*[contains(@class,'button-minus')]//*[@class='icon-minus']")
    private WebElementFacade clickMinusQuantityButton;

    private int currentQuantity;

    public int getCurrentQuantity() {
        return currentQuantity;
    }

    public void clickOnProceedToCheckoutButton() {
        proceedToCheckoutButton.click();
    }

    public String getFirstProductQuantity() {
        return quantityOfItems.getValue();
    }

    public String getGivenSize() {
        String[] givenSize = colorAndSizeFirstProduct.getText().split("Color\\s:\\s.*\\sSize\\s:\\s");
        return givenSize[1];
    }

    public String getGivenColor() {
        String[] split1 = colorAndSizeFirstProduct.getText().split("Color\\s:\\s");
        String[] color = split1[1].split(",\\sSize\\s:\\s");
        return color[0].toUpperCase();
    }

    private void clickPlusQuantityButton() {
        clickPlusQuantityButton.click();
    }

    private void clickMinusQuantityButton() {
        clickMinusQuantityButton.click();
    }

    public int clickPlusAndMinusButtonGivenNumberOfTimes(int plus, int minus) {
        currentQuantity = 1;
        for (int i = 0; i < plus; i++) {
            waitABit(1000);
            clickPlusQuantityButton();
            currentQuantity++;
        }
        for (int i = 0; i < minus; i++) {
            waitABit(1000);
            clickMinusQuantityButton();
            currentQuantity--;
        }
        waitABit(1000);
        return currentQuantity;
    }

}
