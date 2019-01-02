package automationpractice.com.pages.footerPages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class SiteMapPage extends PageObject {



    @FindBy(xpath = "//*[contains(@class,'navigation_page') and contains(text(), 'Sitemap')]")
    private WebElementFacade siteMapText;

    public boolean isSitemapTextDisplayed() { return siteMapText.isVisible();
    }
}



