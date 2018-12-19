package automationpractice.com.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor

public class User {
    private String login;
    private String password;
    public String email;
}
