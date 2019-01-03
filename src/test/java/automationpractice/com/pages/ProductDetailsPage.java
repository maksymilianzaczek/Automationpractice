package automationpractice.com.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    private int currentQuantityInProductDetailsPage;

    private String currentSizeInProductDetailsPage;

    @FindBy(xpath = "//*[@id = 'color_to_pick_list']//*[contains(@id,'color')]")
    private List<WebElementFacade> listOfColorsAndSizes;

    private String currentColorInProductDetailsPage;

    public ProductDetailsPage() {
    }

    public void clickOnAddToCartButton() {
        clickOnAddToCartButton.click();
    }

    public void clickProceedToCheckoutButton() {
        clickProceedToCheckoutButton.click();
    }

    private void clickPlusQuantityButtonOnProductDetailsPage() {
        clickPlusQuantityButtonOnProductDetailsPage.click();
    }

    private void clickMinusQuantityButtonOnProductDetailsPage() {
        clickMinusQuantityButtonOnProductDetailsPage.click();
    }

    public int clickPlusAndMinusButtonGivenNumberOfTimesOnProductDetailsPage(int plus, int minus) {
        currentQuantityInProductDetailsPage = 1;
        for (int i = 0; i < plus; i++) {
            waitABit(1000);
            clickPlusQuantityButtonOnProductDetailsPage();
            currentQuantityInProductDetailsPage++;
        }
        for (int i = 0; i < minus; i++) {
            waitABit(1000);
            clickMinusQuantityButtonOnProductDetailsPage();
            currentQuantityInProductDetailsPage--;
        }
        return currentQuantityInProductDetailsPage;
    }

    public int getCurrentQuantitySetUpInProductDetailsPage() {
        return currentQuantityInProductDetailsPage;
    }

    public String changeSizeToGivenSizeInProductDetailsPage(String sizeWrittenInLargeLetters) {
        currentSizeInProductDetailsPage = sizeWrittenInLargeLetters;
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

    public String getCurrentSizeSetUpInProductDetailsPage() {
        return currentSizeInProductDetailsPage;
    }

    private ArrayList getAvailableColorsInProductDetailsPage() {
        ArrayList<String> listOfColors = new ArrayList<>();

        for (WebElementFacade row : listOfColorsAndSizes) {
            String[] split = row.toString().split("<a id='color_(.*)' name='");
            String[] color = split[1].split("'>(.*)");
            listOfColors.add(color[0]);
        }
        return listOfColors;
    }

    public String changeColorToGivenColorInProductDetailsPage(String colorStartedWithCapitalLetter) {
        currentColorInProductDetailsPage = colorStartedWithCapitalLetter;
        ArrayList listOfAvailableColors = getAvailableColorsInProductDetailsPage();

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

    public String getCurrentColorSetUpInProductDetailsPage() {
        return currentColorInProductDetailsPage;
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
