package automationpractice.com.steps;

import automationpractice.com.pages.NewAddressPage;
import net.thucydides.core.annotations.Step;

import static automationpractice.com.data.NewAddressInformation.NEW_ADDRESS_INFORMATION_1;

public class AddressesDataSteps {

    private NewAddressPage newAddressPage;

    @Step
    public void inputExampleAddressesData() {
        newAddressPage.typeFirstNameAddress(NEW_ADDRESS_INFORMATION_1.getFirstNameAddress());
        newAddressPage.typeLastNameAddress(NEW_ADDRESS_INFORMATION_1.getLastNameAddress());
        newAddressPage.typeAddress(NEW_ADDRESS_INFORMATION_1.getAddress());
        newAddressPage.typeCity(NEW_ADDRESS_INFORMATION_1.getCity());
        newAddressPage.typePostCode(NEW_ADDRESS_INFORMATION_1.getZipCode());
        newAddressPage.clickCountryList();
        newAddressPage.clickCountrySelect();
        newAddressPage.typeMobilePhone(NEW_ADDRESS_INFORMATION_1.getMobilePhone());
        newAddressPage.typeTitle(NEW_ADDRESS_INFORMATION_1.getNewAddressName());
        newAddressPage.clickStateList();
        newAddressPage.clickStateSelect(NEW_ADDRESS_INFORMATION_1.getState());
        newAddressPage.clickSaveNewAddressButton();
    }
}
