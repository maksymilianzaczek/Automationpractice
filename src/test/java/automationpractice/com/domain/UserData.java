package automationpractice.com.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor

public class UserData {
    private String login;
    private String password;
    private String firstName;
    private String lastName;
}
