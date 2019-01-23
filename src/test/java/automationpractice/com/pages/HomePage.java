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

    private List<WebElementFacade> getListOfProducts() {
        return listOfProducts;
    }

//    public boolean isValidationMessageDisplayed() {
//        return homePageError.isVisible();
//    }

    public void clickOnProductImage(){
        getListOfProducts().stream().findAny().get().click();
    }

    public void clickOnSelectedProductImage(int indexOfProduct) {
        if (indexOfProduct < listOfProducts.size()){
            listOfProducts.get(indexOfProduct).click();
        }
        else {
            clickOnProductImage();
        }
    }

}
