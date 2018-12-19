package automationpractice.com.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import javax.swing.*;

public class ContactUsPage extends PageObject {


    @FindBy(id = "message")
    private WebElementFacade Message;
    @FindBy(id = "uniform-id_order")
    private WebElementFacade OrderReferenceList;
    @FindBy(xpath = "//*[@id='id_order']/option[2]")
    private WebElementFacade OrderReferenceSelect;
    @FindBy(id = "uniform-id_contact")
    private WebElementFacade subjectHeadingList;
    @FindBy(xpath = "//*[@id='id_contact']/option[2]")
    private WebElementFacade subjectHeadingSelect;
    @FindBy(id = "submitMessage")
    private WebElementFacade SendMessage;
    @FindBy(className = "alert alert-success")
    private WebElementFacade SuccessfullMessageSent;
    @FindBy(className = "alert alert-danger")
    private WebElementFacade ErrorMessageSent;

    private WebElementFacade ContactUsText;


    public boolean isSuccessfullMessageSentVisible() {
        return SuccessfullMessageSent.isVisible();
    }

    public boolean isErrorMessageSentVisible() {
        return ErrorMessageSent.isVisible();
    }

    public void clickOnOrderReferenceList() {
        OrderReferenceList.click();
    }

    public void clickOnOrderReferenceSelect() {
        OrderReferenceSelect.click();
    }

    public void clickOnSubjectHeadingList() {
        subjectHeadingList.click();
    }

    public void clickOnSubjectHeadingSelect() {
        find(By.xpath("//*[@id='id_contact']//*[contains(text(), 'Customer service')]")).click();
//        subjectHeadingSelect.click();

    }


    public void typeMessage(final String test_message) {
        Message.type(test_message);
    }

    public void clickOnSendMessage() {
        SendMessage.click();
    }

    public boolean isContactUsTextDisplayed() {
        return ContactUsText.isVisible();
    }
}




