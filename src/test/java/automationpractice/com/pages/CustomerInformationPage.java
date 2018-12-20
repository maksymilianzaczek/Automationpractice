package automationpractice.com.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class CustomerInformationPage extends PageObject {

    @FindBy(id = "firstname")
    private WebElementFacade firstName;
    @FindBy(id = "firstname")
    private WebElementFacade lastName;
    @FindBy(id = "email")
    private WebElementFacade emailAddress;
    @FindBy(xpath = "//*[@id='center_column']//*[@class='form-group']//*[contains(@class,'btn')]")
    private WebElementFacade saveButton;
    @FindBy(className = "alert-success")
    private WebElementFacade successMessage;
    @FindBy(id = "old_passwd")
    private WebElementFacade passowrdInput;

    public void editFirstName(String name) {
        firstName.type(name);
    }

    public void editLastName(String l_name) {
        lastName.type(l_name);
    }

    public void editEmailAddress(String email) {
        emailAddress.type(email);
    }

    public void clickSaveButton() {
        saveButton.click();
    }

    public boolean isMessageVisible() {
        return successMessage.isVisible();
    }

    public void enterPassword(String password) {
        passowrdInput.type(password);
    }
}
