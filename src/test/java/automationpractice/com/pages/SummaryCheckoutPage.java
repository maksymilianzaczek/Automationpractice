package automationpractice.com.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SummaryCheckoutPage extends PageObject {

    @FindBy(className = "standard-checkout")
    private WebElementFacade proceedToCheckoutButton;

    @FindBy(xpath = "//*[contains(@class,'stock-management-on')]//*[contains(@class,'odd')]//*[@class='cart_description']/small[2]/a")
    private WebElementFacade colorAndSizeFirstProduct;

    @FindBy(className = "cart_quantity_input")
    private WebElementFacade quantityOfItems;

    @FindBy(xpath = "//*[contains(@class,'button-plus')]//*[@class='icon-plus']")
    private WebElementFacade plusQuantityButton;

    @FindBy(xpath = "//*[contains(@class,'button-minus')]//*[@class='icon-minus']")
    private WebElementFacade minusQuantityButton;

    private String quantity;

    public String getCurrentQuantity() {
        return quantityOfItems.getValue();
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public void clickOnProceedToCheckoutButton() {
        proceedToCheckoutButton.click();
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

    /**
     * This method checks 10 times per second whether the quantity value is changed
     */
    private void clickPlusQuantityButton() {
        String valueBeforeClick = getCurrentQuantity();
        plusQuantityButton.click();

        for (int i = 0; i < 50; i++) {
            String valueAfterClick = getCurrentQuantity();
            if (!valueBeforeClick.equals(valueAfterClick)){
                break;
            }
            else {
                waitABit(100);
            }
        }
    }

//    /**
//     * This method checks 10 times per second whether the quantity value is changed
//     */
//    private void minusQuantityButton() {
//        String valueBeforeClick = getCurrentQuantity();
//        minusQuantityButton.click();
//
//        for (int i = 0; i < 50; i++) {
//            String valueAfterClick = getCurrentQuantity();
//            if (!valueBeforeClick.equals(valueAfterClick)){
//                break;
//            }
//            else {
//                waitABit(100);
//            }
//        }
//    }
    /**
     * This method checks 10 times per second whether the quantity value is changed
     */
    private void clickMinusQuantityButton() {
        int valueBeforeClick = Integer.parseInt(getCurrentQuantity());
        System.out.println("valueBeforeClick: " + valueBeforeClick);


        minusQuantityButton.click();
//        waitForCondition().until(ExpectedConditions.attributeToBe(minusQuantityButton, "value", String.valueOf(valueBeforeClick + 1)));
        waitForCondition().until(ExpectedConditions.attributeToBe(quantityOfItems, "value", String.valueOf(valueBeforeClick + 1)));

//        for (int i = 0; i < 50; i++) {
//            String valueAfterClick = getCurrentQuantity();
//            if (!valueBeforeClick.equals(valueAfterClick)){
//                break;
//            }
//            else {
//                waitABit(100);
//            }
//        }
    }

    public void clickPlusAndMinusButtonGivenNumberOfTimes(int plus, int minus) {
        for (int i = 0; i < plus; i++) {
            clickPlusQuantityButton();
        }
        for (int i = 0; i < minus; i++) {
            clickMinusQuantityButton();
        }
    }
}
