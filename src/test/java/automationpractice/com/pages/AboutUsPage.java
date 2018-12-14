package automationpractice.com.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class AboutUsPage extends PageObject {

    @FindBy() //todo find xpath for contact us text
    private WebElementFacade AboutUsText;

    public boolean isAboutUsTextDisplayed() {
        return AboutUsText.isVisible();
    }
}

