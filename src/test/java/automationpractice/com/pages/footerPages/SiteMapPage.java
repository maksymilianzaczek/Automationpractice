package automationpractice.com.pages.footerPages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class SiteMapPage extends PageObject {



    @FindBy(xpath = "//*[contains(@class, 'page-heading')]")
    private WebElementFacade siteMapText;

    public String HeadlingTitle() {
        return siteMapText.isVisible();
    }
}


