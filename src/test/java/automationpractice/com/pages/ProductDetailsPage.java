package automationpractice.com.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class ProductDetailsPage extends PageObject {

    @FindBy(id = "add_to_cart")
    private WebElementFacade addToCartButton;

    @FindBy(xpath = "//*[contains(@class,'button-medium')]//*[contains(@class,'icon-chevron-right')]")
    private WebElementFacade proceedToCheckoutButton;

    @FindBy(className = "icon-plus")
    private WebElementFacade plusQuantityButton;

    @FindBy(className = "icon-minus")
    private WebElementFacade minusQuantityButton;

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
    private WebElementFacade twitterButton;

    @FindBy(className = "btn-facebook")
    private WebElementFacade facebookButton;

    @FindBy(className = "btn-google-plus")
    private WebElementFacade googlePlusButton;

    @FindBy(className = "btn-pinterest")
    private WebElementFacade pinteresButton;

    private int currentQuantity;

    private String currentSize;

    @FindBy(xpath = "//*[@id = 'color_to_pick_list']//*[contains(@id,'color')]")
    private List<WebElementFacade> listOfColorsAndSizes;

    private String currentColor;

    public ProductDetailsPage() {
    }

    public void clickOnAddToCartButton() {
        addToCartButton.click();
    }

    public void clickProceedToCheckoutButton() {
        proceedToCheckoutButton.click();
    }

    private void clickPlusQuantityButton() {
        plusQuantityButton.click();
    }

    private void clickMinusQuantityButton() {
        minusQuantityButton.click();
    }

    public int clickPlusAndMinusButtonGivenNumberOfTimes(int plus, int minus) {
        currentQuantity = 1;
        for (int i = 0; i < plus; i++) {
            waitABit(1000);
            clickPlusQuantityButton();
            currentQuantity++;
        }
        for (int i = 0; i < minus; i++) {
            waitABit(1000);
            clickMinusQuantityButton();
            currentQuantity--;
        }
        return currentQuantity;
    }

    public int getCurrentQuantity() {
        return currentQuantity;
    }

    public String changeSizeToGivenSize(String size) {
        currentSize = size.toUpperCase();
        switch (size) {
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
        return size;
    }

    public String getCurrentSize() {
        return currentSize;
    }

    private ArrayList getAvailableColors() {
        ArrayList<String> listOfColors = new ArrayList<>();

        for (WebElementFacade row : listOfColorsAndSizes) {
            String[] split = row.toString().split("<a id='color_(.*)' name='");
            String[] color = split[1].split("'>(.*)");
            listOfColors.add(color[0]);
        }
        return listOfColors;
    }

    public String changeColorToGivenColor(String colorStartedWithCapitalLetter) {
        currentColor = colorStartedWithCapitalLetter;
        ArrayList listOfAvailableColors = getAvailableColors();

        for (Object listOfAvailableColor : listOfAvailableColors) {
            if (listOfAvailableColor.toString().equals(colorStartedWithCapitalLetter)) {
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
        // TODO: 02.01.2019 default choose first available color
        return colorStartedWithCapitalLetter;
    }

    public String getCurrentColor() {
        return currentColor;
    }

    public void clickOnTwitterButton() {
        twitterButton.click();
    }

    public void clickOnFacebookButton() {
        facebookButton.click();
    }

    public void clickOnGooglePlusButton() {
        googlePlusButton.click();
    }

    public void clickOnPinterestButton() {
        pinteresButton.click();
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
        Pattern twitterPattern = Pattern.compile("(.*)twitter(.*)");
        return twitterPattern.matcher(getDriver().getCurrentUrl()).matches();
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
