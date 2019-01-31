package automationpractice.com.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SummaryCheckoutPage extends PageObject {

    @FindBy(className = "standard-checkout")
    private WebElementFacade proceedToCheckoutButton;

    @FindBy(xpath = "//*[contains(@class,'on')]//*[contains(@class,'odd')]//*[@class='cart_description']/small[2]")
    private WebElementFacade colorAndSizeFirstProduct;

    @FindBy(className = "cart_quantity_input")
    private WebElementFacade quantityOfItems;

    @FindBy(xpath = "//*[contains(@class,'button-plus')]//*[@class='icon-plus']")
    private WebElementFacade plusQuantityButton;

    @FindBy(xpath = "//*[contains(@class,'button-minus')]//*[@class='icon-minus']")
    private WebElementFacade minusQuantityButton;

    public int getCurrentQuantity() {
        return Integer.parseInt(quantityOfItems.getValue());
    }

    public void clickOnProceedToCheckoutButton() {
        proceedToCheckoutButton.click();
    }

    public String getGivenSize() {
        return divideColorAndSizeTextUsingRegex().group(2).toUpperCase();
    }

    public String getGivenColor() {
        return divideColorAndSizeTextUsingRegex().group(1).toUpperCase();
    }

    private Matcher divideColorAndSizeTextUsingRegex() {
        final String stringRegex = "Color : (.+)?,.*: (.+)?";
        final Pattern regex = Pattern.compile(stringRegex);
        final Matcher color = regex.matcher(colorAndSizeFirstProduct.getText());
        color.matches();
        return color;
    }

    private void clickPlusQuantityButton() {
        final int valueBeforeClick = getCurrentQuantity();
        plusQuantityButton.click();
        waitForCondition().until((ExpectedCondition<Boolean>) webDriver ->
                quantityOfItems.getValue().equals(String.valueOf(valueBeforeClick + 1)));
    }

    private void clickMinusQuantityButton() {
        final int valueBeforeClick = getCurrentQuantity();
        minusQuantityButton.click();
        waitForCondition().until((ExpectedCondition<Boolean>) webDriver ->
                quantityOfItems.getValue().equals(String.valueOf(valueBeforeClick - 1)));
    }

    public void clickPlusAndMinusButtonGivenNumberOfTimes(final int plus,final int minus) {
        for (int i = 0; i < plus; i++) {
            clickPlusQuantityButton();
        }
        for (int i = 0; i < minus; i++) {
            clickMinusQuantityButton();
        }
    }
}
