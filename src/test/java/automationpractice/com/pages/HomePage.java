package automationpractice.com.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends PageObject {

    @FindBy(id = "create_account_error")
    private WebElementFacade homePageError;

    @FindBy(xpath = "//*[@id='homefeatured']//*[@class='product-container']")
    private List<WebElementFacade> listOfProducts;

    public List<WebElementFacade> getListOfProducts() {
        return listOfProducts;
    }

    public void clickOnSelectedProductImage(final String productName) {
        for (WebElementFacade product : listOfProducts) {
            if (productName.equals(product.getText())) {
                product.click();
                break;
            }
        }
    }
}
