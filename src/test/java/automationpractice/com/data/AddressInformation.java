package automationpractice.com.data;

import automationpractice.com.domain.AddressData;
import automationpractice.com.domain.EditAddressData;

import java.util.GregorianCalendar;

public class AddressInformation {
    public static final AddressData NEW_ADDRESS_INFORMATION = new AddressData(
            "firstName",
            "lastName",
            "email@gmai.com",
            "password",
            new GregorianCalendar(2018, 12, 5),
            "firstNameAddress",
            "lastNameAddress",
            "address",
            "city",
            "Arizona",
            "55555",
            "country",
            "515515515",
            "newaddress");

    public static final EditAddressData EDIT_ADDRESS_INFORMATION = new EditAddressData(
            "Maciej",
            "Stafijowski",
            "editAddress",
            "Wrocław",
            "Columbia",
            "12345",
            "Country",
            "123456789",
            "098765432",
            "AdresMaciek");
}