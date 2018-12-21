package automationpractice.com.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductDetailsPage extends PageObject {

    @FindBy(id = "add_to_cart")
    private WebElementFacade clickOnAddToCartButton;

    @FindBy(xpath = "//*[contains(@class,'button-medium')]//*[contains(@class,'icon-chevron-right')]")
    private WebElementFacade clickProceedToCheckoutButton;

    @FindBy(className = "icon-plus")
    private WebElementFacade clickPlusQuantityButtonOnProductDetailsPage;

    @FindBy(className = "icon-minus")
    private WebElementFacade clickMinusQuantityButtonOnProductDetailsPage;

    @FindBy(xpath = "//*[@id='group_1']//option[1]")
    private WebElementFacade selectSSize;

    @FindBy(xpath = "//*[@id='group_1']//option[2]")
    private WebElementFacade selectMSize;

    @FindBy(xpath = "//*[@id='group_1']//option[3]")
    private WebElementFacade selectLSize;

    @FindBy(id = "color_14")
    private WebElementFacade changeColorToBlue;

    @FindBy(id = "color_13")
    private WebElementFacade changeColorToOrange;

    @FindBy(id = "color_8")
    private WebElementFacade changeColorToWhite;

    @FindBy(id = "color_11")
    private WebElementFacade changeColorToBlack;

    @FindBy(id = "color_15")
    private WebElementFacade changeColorToGreen;

    @FindBy(id = "color_16")
    private WebElementFacade changeColorToYellow;

    @FindBy(className = "btn-twitter")
    private WebElementFacade clickOnTwitterButton;

    @FindBy(className = "btn-facebook")
    private WebElementFacade clickOnFacebookButton;

    @FindBy(className = "btn-google-plus")
    private WebElementFacade clickOnGooglePlusButton;

    @FindBy(className = "btn-pinterest")
    private WebElementFacade clickOnPinteresButton;

    private String currentSize;
    @FindBy(xpath = "//*[@id = 'color_to_pick_list']//a")
    private List<WebElementFacade> listOfColors;
    private String currentColor;

    public void clickOnAddToCartButton() {
        clickOnAddToCartButton.click();
    }

    public void clickProceedToCheckoutButton() {
        clickProceedToCheckoutButton.click();
    }

    public void clickPlusQuantityButtonOnProductDetailsPage() {
        clickPlusQuantityButtonOnProductDetailsPage.click();
    }

    public void clickMinusQuantityButtonOnProductDetailsPage() {
        clickMinusQuantityButtonOnProductDetailsPage.click();
    }

    public int clickPlusAndMinusButtonGivenNumberOfTimesOnDetailsPage(int plus, int minus) {
        int quantityOfItems = 1;
        for (int i = 0; i <= plus; i++) {
            clickPlusQuantityButtonOnProductDetailsPage();
            quantityOfItems++;
        }
        for (int i = 0; i <= minus; i++) {
            clickMinusQuantityButtonOnProductDetailsPage();
            quantityOfItems--;
        }
        return quantityOfItems;
    }

    public String getCurrentSizeSetUpInProductDetailsPage() {
        return currentSize;
    }

    public String changeSizeToGivenSize(String sizeWrittenInLargeLetters) {
        currentSize = sizeWrittenInLargeLetters;
        switch (sizeWrittenInLargeLetters) {
            case "S":
                selectSSize.click();
                break;
            case "M":
                selectMSize.click();
                break;
            case "L":
                selectLSize.click();
                break;
            default:
                selectSSize.click();
                break;
        }
        return sizeWrittenInLargeLetters;
    }

    public String getCurrentColor() {
        return currentColor;
    }

    public String changeColorToGivenColor(String colorStartedWithCapitalLetter) {
        currentColor = colorStartedWithCapitalLetter;
        Object[] listOfColors = this.listOfColors.toArray();

        for (Object o : listOfColors) {
            if (o.toString().contains(colorStartedWithCapitalLetter)) {

                System.out.println("przed switch");
                switch (colorStartedWithCapitalLetter) {
                    case "Orange":
                        changeColorToOrange.click();
                        break;
                    case "White":
                        changeColorToWhite.click();
                        break;
                    case "Black":
                        changeColorToBlack.click();
                        break;
                    case "Green":
                        changeColorToGreen.click();
                        break;
                    case "Yellow":
                        changeColorToYellow.click();
                        break;
                    case "Blue":
                        changeColorToBlue.click();
                        break;
                }
            }
        }
        return colorStartedWithCapitalLetter;
    }

    public void clickOnTwitterButton() {
        clickOnTwitterButton.click();
    }

    public void clickOnFacebookButton() {
        clickOnFacebookButton.click();
    }

    public void clickOnGooglePlusButton() {
        clickOnGooglePlusButton.click();
    }

    public void clickOnPinterestButton() {
        clickOnPinteresButton.click();
    }

    public void checkoutToTweeterWindow() {
        waitABit(1000);
        for (String s : getDriver().getWindowHandles()) {
            if (!s.equals("2147483649")) {
                getDriver().switchTo().window(s);
            }
        }
    }

    public void checkoutToFacebookWindow() {
        waitABit(1000);
        for (String s : getDriver().getWindowHandles()) {
            if (!s.equals("2147483649")) {
                getDriver().switchTo().window(s);
            }
        }
    }

    public void checkoutToGooglePlusWindow() {
        waitABit(1000);
        for (String s : getDriver().getWindowHandles()) {
            if (!s.equals("2147483649")) {
                getDriver().switchTo().window(s);
            }
        }
    }

    public void checkoutToPinterestWindow() {
        waitABit(3000);
        for (String s : getDriver().getWindowHandles()) {
            if (!s.equals("2147483649")) {
                getDriver().switchTo().window(s);
            }
        }
    }

    public boolean isTwitterDomainDisplayed() {
        return getDriver().getCurrentUrl().contains("https://twitter.");
    }

    public boolean isFacebookDomainDisplayed() {
        return getDriver().getCurrentUrl().contains("https://www.facebook.");
    }

    public boolean isGooglePlusDomainDisplayed() {
        return getDriver().getCurrentUrl().contains("plus.google");
    }

    public boolean isPinterestDomainDisplayed() {
        return getDriver().getCurrentUrl().contains("pinterest");
    }
}
