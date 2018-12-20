package automationpractice.com.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class MyCreditSlipsPage extends PageObject {

    @FindBy(xpath = "//*[contains(@class,'navigation_page') and contains(text(), 'Credit slips')]")
    private WebElementFacade myCreditSlipsText;

    public boolean isMyCreditSlipsTextDisplayed() {
        return myCreditSlipsText.isVisible();
    }

}
