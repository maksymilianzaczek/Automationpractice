package automationpractice.com.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Registration
{
    private String firstName;
    private String lastName;
    private String password;
    private String dateOfBirth;
    private String firstNameAddress;
    private String lastNameAddress;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    private String country;
    private String mobilePhone;

}

