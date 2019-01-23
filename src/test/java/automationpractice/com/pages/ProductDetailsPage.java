package automationpractice.com.pages;

import automationpractice.com.exceptions.NoColorAvailableException;
import automationpractice.com.exceptions.NoSizeAvailableException;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ProductDetailsPage extends PageObject {

    private final String SELECT_SIZE_XPATH_PATTERN = "//*[@id='group_1']//option[@title='%s']";
    private final String SELECT_COLOR_XPATH_PATTERN = "//*[@id='color_to_pick_list']//a[@title='%s']";
    @FindBy(id = "add_to_cart")
    private WebElementFacade addToCartButton;
    @FindBy(xpath = "//*[contains(@class,'medium')]//*[contains(@class,'right')]")
    private WebElementFacade proceedToCheckoutButton;
    @FindBy(className = "icon-plus")
    private WebElementFacade plusQuantityButton;
    @FindBy(className = "icon-minus")
    private WebElementFacade minusQuantityButton;
    @FindBy(className = "btn-twitter")
    private WebElementFacade twitterButton;
    @FindBy(className = "btn-facebook")
    private WebElementFacade facebookButton;
    @FindBy(className = "btn-google-plus")
    private WebElementFacade googlePlusButton;
    @FindBy(className = "btn-pinterest")
    private WebElementFacade pinteresButton;
    @FindBy(xpath = "//*[@id = 'color_to_pick_list']//*[contains(@id,'color')]")
    private List<WebElementFacade> listOfColorsAndSizes;
    @FindBy(id = "quantity_wanted")
    private WebElementFacade quantityOfItem;

    private String currentSize;
    private String currentColor;
    private String currentQuantity;

    public String getQuantityOfItem() {
        return quantityOfItem.getValue();
    }

    public String getCurrentSize() {
        return currentSize;
    }

    public String getCurrentColor() {
        return currentColor;
    }

    public String getCurrentQuantity() {
        return currentQuantity;
    }

    public void setCurrentQuantity(final String currentQuantity) {
        this.currentQuantity = currentQuantity;
    }

    private List<String> getAvailableColors() {
        return listOfColorsAndSizes.stream().map(row -> row.getAttribute("name")).collect(Collectors.toList());
    }

    private void selectSize(final String size) {
        final String sizeXpath = String.format(SELECT_SIZE_XPATH_PATTERN, size);
        find(By.xpath(sizeXpath)).click();
    }

    private void selectColor(final String color) {
        final String colorXpath = String.format(SELECT_COLOR_XPATH_PATTERN, color);
        find(By.xpath(colorXpath)).click();
    }

    public void clickOnAddToCartButton() {
        addToCartButton.click();
    }

    public void clickProceedToCheckoutButton() {
        proceedToCheckoutButton.click();
    }

    private void clickPlusQuantityButton() {
        int valueBeforeClick = Integer.parseInt(quantityOfItem.getValue());
        plusQuantityButton.click();
        waitForCondition().until((ExpectedCondition<Boolean>) webDriver ->
                quantityOfItem.getValue().equals(String.valueOf(valueBeforeClick + 1)));
    }

    private void clickMinusQuantityButton() {
        int valueBeforeClick = Integer.parseInt(quantityOfItem.getValue());
        minusQuantityButton.click();
        waitForCondition().until((ExpectedCondition<Boolean>) webDriver ->
                quantityOfItem.getValue().equals(String.valueOf(valueBeforeClick - 1)));
    }

    public void clickPlusAndMinusButtonGivenNumberOfTimes(int plus, int minus) {
        for (int i = 0; i < plus; i++) {
            clickPlusQuantityButton();
        }
        for (int i = 0; i < minus; i++) {
            clickMinusQuantityButton();
        }
    }

    public String changeSizeToGivenSize(final String size) {
        currentSize = size.toUpperCase();
        switch (currentSize) {
            case "S":
                selectSize("S");
                break;
            case "M":
                selectSize("M");
                break;
            case "L":
                selectSize("L");
                break;
            default:
                selectSize("S");
                try {
                    throw new NoSizeAvailableException("Size: " + size + " is not available");
                } catch (NoSizeAvailableException e) {
                    e.printStackTrace();
                }
        }
        return currentSize;
    }

    public String changeColorToGivenColor(final String color) {
        currentColor = color.toUpperCase();
        List<String> listOfAvailableColors = getAvailableColors();

        for (String c : listOfAvailableColors) {
            if ((c.toUpperCase()).equals(color.toUpperCase())) {
                switch (color.toUpperCase()) {

                    case "ORANGE":
                        selectColor("Orange");
                        break;
                    case "WHITE":
                        selectColor("White");
                        break;
                    case "BLACK":
                        selectColor("Black");
                        break;
                    case "GREEN":
                        selectColor("Green");
                        break;
                    case "YELLOW":
                        selectColor("Yellow");
                        break;
                    case "BLUE":
                        selectColor("Blue");
                        break;

                    default:
                        try {
                            throw new NoColorAvailableException("Color: " + color + " is not available");
                        } catch (NoColorAvailableException e) {
                            e.printStackTrace();
                        }
                }
            }
        }
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

    public void checkoutToExternalSocialMediaWindow() {
        final ArrayList tabs = new ArrayList<>(getDriver().getWindowHandles());
        getDriver().switchTo().window(tabs.get(1).toString());
        waitForOpenedNewDomain();
    }

    private void waitForOpenedNewDomain() {
        waitForCondition().until((ExpectedCondition<Boolean>) webDriver ->
                !getDriver().getCurrentUrl().contains("about:blank"));
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
