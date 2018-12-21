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

    public String getGivenSizeInSummaryCheckoutPage(){
        String[] givenSize = colorAndSizeFirstProductOnSummaryCheckoutPage.getText().split("Color\\s:\\s.*\\sSize\\s:\\s");
        System.out.println(givenSize[1]);
          return givenSize[1];
    }


    public String getGivenColorInSummaryCheckoutPage() {
        String[] split1 = colorAndSizeFirstProductOnSummaryCheckoutPage.getText().split("Color\\s:\\s");
        String[] color = split1[1].split(",\\sSize\\s:\\s");
        return color[0];
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
