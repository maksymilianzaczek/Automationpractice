package automationpractice.com.data;

import automationpractice.com.domain.NewAddressData;

import java.util.GregorianCalendar;

public class NewAddressInformation {
    public static final NewAddressData NEW_ADDRESS_INFORMATION = new NewAddressData(
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

    public static final NewAddressData NEW_ADDRESS_INFORMATION_1 = new NewAddressData(
            "firstName",
            "lastName",
            "email@gmai.com",
            "password",
            new GregorianCalendar(2018, 12, 5),
            "Ola",
            "Makota",
            "Pieskowa",
            "Pacanow",
            "Florida",
            "44444",
            "United States",
            "213456789",
            "Zwierzogrod");
}
