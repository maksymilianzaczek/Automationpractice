package automationpractice.com.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class AddressPage extends PageObject {


    @FindBy(xpath = "//*[contains(@class,'button-medium')and not(@rel)]")
    private WebElementFacade addNewAddressButton;


    public void clickAddNewAddressButton() {
        addNewAddressButton.click();
    }
}