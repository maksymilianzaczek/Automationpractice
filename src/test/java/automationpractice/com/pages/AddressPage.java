package automationpractice.com.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class AddressPage extends PageObject {



    @FindBy(xpath = "//*[contains(@class,'button-medium')and not(@rel)]")
    private WebElementFacade addNewAddressButton;
    @FindBy(xpath = "//*[contains(@class,'alternate_item')]")
    private WebElementFacade newListName;
    @FindBy(xpath = "//*[contains(@class,'last_item')]//*[contains(@class,'icon-remove')]")
    private WebElementFacade deleteButton;


    public void clickAddNewAddressButton() {
        addNewAddressButton.click();
    }

    public boolean isNewAddressNameVisible() {
        return newListName.isVisible();
    }

    public void clickDeleteButton() {
        deleteButton.click();
    }
}