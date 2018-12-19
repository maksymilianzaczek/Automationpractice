package automationpractice.com.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class SpecialsPage extends PageObject {

    @FindBy(xpath = "//*[contains(@class,'navigation_page')]")
    private WebElementFacade SpecialsText;

    public boolean isSpecialsTextDisplayed() {  return SpecialsText.isVisible();
    }
}




