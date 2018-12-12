package automationpractice.com.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageObject {

    private static final String FIRST_PRODUCT_PATH = "//*[@class='tab-content']//*[@id='homefeatured']//*[contains(text(),'%s')]//ancestor::*[contains(@class,'ajax')]//*[contains(@class,'product_img_link')]/img";

    @FindBy(id = "create_account_error")
    private WebElementFacade homePageError;

    public boolean isValidationMessageDisplayed() {
        return homePageError.isVisible();
    }


    public void selectFirstProduct(final String productName) {
        final String firstProduct = String.format(FIRST_PRODUCT_PATH, productName);
        final WebElementFacade goToProductDetailPage = find(By.xpath(firstProduct));
        goToProductDetailPage.click();
    }
}
