package automationpractice.com.data;

import automationpractice.com.domain.CommentAboutOrderData;

public class CommentAboutOrder {

    public static final CommentAboutOrderData entranceFromTheYard = new CommentAboutOrderData("entrance from the yard");

    public static final String entranceFromTheYardXpath = "//*[@id='block-order-detail']//*[contains(text(),'entrance from the yard')]";
    // this is hardcoded because you can not give variable value into @annotation

}
