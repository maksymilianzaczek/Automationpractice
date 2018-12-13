package automationpractice.com.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class AddressPage extends PageObject {

    private final String DELETE_BUTTON_XPATH_PATTERN = "//*[contains(text(), '%s')]//ancestor::*[contains(@class, 'address') and not(contains(@class, 'addresses'))]//*[contains(@class,'icon-remove')]";
    private final String EDIT_BUTTON_XPATH_PATTERN = "//*[contains(text(), '%s')]//ancestor::*[contains(@class, 'address') and not(contains(@class, 'addresses'))]//*[contains(@class,'address_update')]/a";

    @FindBy(xpath = "//*[contains(@class,'button-medium')and not(@rel)]")
    private WebElementFacade addNewAddressButton;
    @FindBy(xpath = "//*[@class='addresses']//*[@class='page-subheading']")
    private List<WebElementFacade> addressNameList;

    public void clickAddNewAddressButton() {
        addNewAddressButton.click();
    }

    public void clickDeleteButton(final String addressName) {
        final String deleteButtonXpath = String.format(DELETE_BUTTON_XPATH_PATTERN, addressName);
        find(By.xpath(deleteButtonXpath)).click();
    }

    public List<String> getAddressNameList() {
        return addressNameList.stream().map(WebElementFacade::getText).collect(Collectors.toList());
    }

    public void acceptAlert() {
        getDriver().switchTo().alert().accept();
        waitABit(2000);
    }

    public void updateYourAddress(final String addressName) {
        final String editButtonXpath = String.format(EDIT_BUTTON_XPATH_PATTERN, addressName);
        find(By.xpath(editButtonXpath)).click();
    }

    public List<String> updatedAddressName() {
        return addressNameList.stream().map(WebElementFacade::getText).collect(Collectors.toList());
    }
}