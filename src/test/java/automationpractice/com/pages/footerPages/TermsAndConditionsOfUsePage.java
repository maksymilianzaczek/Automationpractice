package automationpractice.com.pages.footerPages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class TermsAndConditionsOfUsePage extends PageObject {

    @FindBy(xpath = "//*[contains(@class,'navigation_page') and contains(text(), 'Terms and conditions of use')]")
    private WebElementFacade termsAndConditionsOfUseText;


    public boolean isTermsAndConditionsOfUseTextDisplayed() {  return termsAndConditionsOfUseText.isVisible();
    }
}


