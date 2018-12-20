package automationpractice.com.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class WomenCategoriesPage extends PageObject {


    @FindBy(xpath = "//*[contains(@class,'navigation_page') and contains(text(), 'Women')]")
    private WebElementFacade womenCategoriesText;


    public boolean isWomenCategoriesTextDisplayed() {  return womenCategoriesText.isVisible();
    }
}


