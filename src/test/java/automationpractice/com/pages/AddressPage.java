package automationpractice.com.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class AddressPage extends PageObject {

    @FindBy(xpath = "//*[contains(@class,'button-medium')and not(@rel)]")
    private WebElementFacade addNewAddressButton;

    @FindBy (xpath = "//div[@class='bloc_adresses row']//div[2]//*[@class='page-subheading']")
    private WebElementFacade newAddressName;

    @FindBy(xpath = "//div[@class='bloc_adresses row']//div[2]//*[@class='icon-remove right']")
    private WebElementFacade deleteButton;

    public void clickAddNewAddressButton() {
        addNewAddressButton.click();
    }

    public boolean isNewAddressNameVisible() {
        return newAddressName.isVisible();
    }

    public void clickDeleteButton() {
deleteButton.click();
    }
}


