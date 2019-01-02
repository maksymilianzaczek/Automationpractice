package automationpractice.com.pages.footerPages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class AboutUsPage extends PageObject {

    @FindBy(xpath = "//*[contains(@class,'navigation_page') and contains(text(), 'About us')]")
    private WebElementFacade aboutUsText;

    public boolean isAboutUsTextDisplayed() {
        return aboutUsText.isVisible();
    }
}

