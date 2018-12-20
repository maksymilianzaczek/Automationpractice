package automationpractice.com.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class MyPersonalInfoPage extends PageObject {

    @FindBy(xpath = "//*[contains(@class,'navigation_page') and contains(text(), 'Your personal information')]")
    private WebElementFacade myPersonalInfoText;


    public boolean isMyPersonalInfoTextDisplayed() {
        return myPersonalInfoText.isVisible();
    }
}


