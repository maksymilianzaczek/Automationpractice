package automationpractice.com.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class SummaryCheckoutPage extends PageObject {

    @FindBy(className = "standard-checkout")
    private WebElementFacade clickOnProceedToCheckoutButtonInSummaryLabel;

    @FindBy(xpath = "//*[contains(@class,'stock-management-on')]//*[contains(@class,'odd')]//*[@class='cart_description']/small[2]/a")
    private WebElementFacade colorAndSizeFirstProductOnSummaryCheckoutPage;

    @FindBy(className = "cart_quantity_input")
    private WebElementFacade quantityOfItemsInSummaryCheckoutPage;

    @FindBy(xpath = "//*[contains(@class,'button-plus')]//*[@class='icon-plus']")
    private WebElementFacade clickPlusQuantityButtonInSummaryLabel;

    @FindBy(xpath = "//*[contains(@class,'button-minus')]//*[@class='icon-minus']")
    private WebElementFacade clickMinusQuantityButtonInSummaryLabel;

    public void clickOnProceedToCheckoutButtonInSummaryLabel() {
        clickOnProceedToCheckoutButtonInSummaryLabel.click();
    }

    public String getFirstProductQuantityInSummaryCheckoutPage(){
        return quantityOfItemsInSummaryCheckoutPage.getValue();
    }

    public boolean isSizeL() {
        return colorAndSizeFirstProductOnSummaryCheckoutPage.getText().contains("Size : L");
    }

    public boolean isSizeM() {
        return colorAndSizeFirstProductOnSummaryCheckoutPage.getText().contains("Size : M");
    }

    public boolean isBlueColor() {
        return colorAndSizeFirstProductOnSummaryCheckoutPage.getText().contains("Color : Blue");
    }

    public void clickPlusQuantityButtonOnSummaryLabel() {
        clickPlusQuantityButtonInSummaryLabel.click();
        waitABit(2000);
    }

    public void clickMinusQuantityButtonOnSummaryLabel() {
        clickMinusQuantityButtonInSummaryLabel.click();
        waitABit(2000);
    }

    public int clickPlusAndMinusButtonGivenNumberOfTimesOnSummaryCheckoutPage(int plus, int minus){
        int quantityOfItems = 1;
        for (int i = 0; i <= plus; i++) {
            clickPlusQuantityButtonOnSummaryLabel();
            quantityOfItems++;
        }
        for (int i = 0; i <= minus; i++) {
            clickMinusQuantityButtonOnSummaryLabel();
            quantityOfItems--;
        }
        return quantityOfItems;
    }
}
