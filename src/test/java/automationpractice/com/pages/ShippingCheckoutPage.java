package automationpractice.com.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class ShippingCheckoutPage extends PageObject {

    @FindBy(className = "standard-checkout")
    private WebElementFacade proceedToCheckoutButton;

    @FindBy(id = "uniform-cgv")
    private WebElementFacade agreeCheckbox;

    @FindBy(className = "fancybox-error")
    private WebElementFacade alertDisplayed;

    @FindBy(xpath = "//*[contains(@class,'fancybox-close')]")
    private WebElementFacade closeAlert;

    @FindBy(className = "fancybox-error")
    private WebElementFacade allertMessage;


    public void clickOnProceedToCheckoutButton() {
        proceedToCheckoutButton.click();
    }

    public void clickAgreeCheckbox() {
        allertMessage.waitUntilNotVisible();
        agreeCheckbox.click();
    }

    public boolean isAlertDisplayed() {
        return alertDisplayed.isVisible();
    }

    public void closeAlert() {
        closeAlert.click();
    }
}
