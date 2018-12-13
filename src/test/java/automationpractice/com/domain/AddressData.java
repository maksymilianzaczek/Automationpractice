package automationpractice.com.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.GregorianCalendar;

@Getter
@AllArgsConstructor
public class AddressData {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private GregorianCalendar dateOfBirth;
    private String firstNameAddress;
    private String lastNameAddress;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    private String country;
    private String mobilePhone;
    private String addressName;
}

