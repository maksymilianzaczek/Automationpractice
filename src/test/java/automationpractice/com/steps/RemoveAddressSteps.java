package automationpractice.com.steps;

import automationpractice.com.pages.AddressPage;
import net.thucydides.core.annotations.Step;
import java.util.List;

public class RemoveAddressSteps {

    private AddressPage addressPage;

    @Step
    public void checkAddressNameExistsAndIfIsDeleteIt(final String addressName) {
        final List<String> addressNameList = addressPage.getAddressNameList();
        for (String name : addressNameList) {
            if (name.toUpperCase().equals(addressName.toUpperCase())) {
                addressPage.removeAddressFromAddressPage(addressName);
            }
        }
    }
}
