package automationpractice.com.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class AddressPage extends PageObject {

    private final String deleteButtonXpathPattern = "//*[contains(text(), '%s')]//ancestor::*["
        + "contains(@class, 'address') and not(contains(@class, 'addresses'))]//*[contains(@class,'icon-remove')]";
    @FindBy(xpath = "//*[contains(@class,'button-medium')and not(@rel)]")
    private WebElementFacade addNewAddressButton;
    @FindBy(xpath = "//*[@class='addresses']//*[@class='page-subheading']")
    private List<WebElementFacade> addressNameList;

    public List<String> getAddressNameList() {
        return addressNameList.stream().map(WebElementFacade::getText).collect(Collectors.toList());
    }

    public void clickAddNewAddressButton() {
        addNewAddressButton.click();
    }

    public void clickDeleteButton(final String addressName) {
        final String deleteButtonXpath = String.format(deleteButtonXpathPattern, addressName);
        find(By.xpath(deleteButtonXpath)).click();
    }

    public void acceptAlert() {
        getAlert().accept();
    }

    public void removeAddressFromAddressPage(final String addressName) {
        clickDeleteButton(addressName);
        acceptAlert();
    }

}
