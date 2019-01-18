package automationpractice.com.pages.footerPages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class MyPersonalInfoPage extends PageObject {

    @FindBy(xpath = "//*[contains(@class, 'page-subheading')]")
    private WebElementFacade myPersonalInfoText;


    public String HeadlingTitle() {
        return myPersonalInfoText.isVisible();
    }
}


