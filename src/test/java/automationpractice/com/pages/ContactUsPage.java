package automationpractice.com.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends PageObject {


    @FindBy(id = "message")
    private WebElementFacade message;
    @FindBy(xpath = "//*[@name='id_order']//ancestor::*[@class='selector']")
    private WebElementFacade orderReferenceList;
    @FindBy(xpath = "//*[@name = 'id_order']/option[2]")
    private WebElementFacade orderReferenceSelect;
    @FindBy(id = "uniform-id_contact")
    private WebElementFacade subjectHeadingList;
    @FindBy(xpath = "//*[@id='id_contact']/option[2]")
    private WebElementFacade subjectHeadingSelect;
    @FindBy(id = "submitMessage")
    private WebElementFacade sendMessage;
    @FindBy(xpath = "//*[contains(@class, 'alert alert-success')]")
    private WebElementFacade successfulMessageSent;
    @FindBy(xpath = "//*[contains(@class, 'alert alert-danger')]")
    private WebElementFacade errorMessageSent;
    @FindBy(xpath = "//*[contains(@class,'navigation_page') and contains(text(), 'Contact')]")
    private WebElementFacade contactUsText;


    public boolean isSuccessfulMessageSentVisible() {
        return successfulMessageSent.isVisible();
    }

    public boolean isErrorMessageSentVisible() {
        return errorMessageSent.isVisible();
    }

    public void clickOnOrderReferenceList() {
        orderReferenceList.click();
    }

    public void clickOnOrderReferenceSelect() {
        orderReferenceSelect.click();
    }

    public void clickOnSubjectHeadingList() {
        subjectHeadingList.click();
    }

    public void clickOnSubjectHeadingSelect() {
        subjectHeadingSelect.click();

    }


    public void typeMessage(final String testMessage) {
        message.type(testMessage);
    }

    public void clickOnSendMessage() {
        sendMessage.click();
    }

    public boolean isContactUsTextDisplayed() {
        return contactUsText.isVisible();
    }
}




