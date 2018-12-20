package automationpractice.com.data;

import automationpractice.com.domain.User;

public class Users {

    private static final String PASSWORD = "12345678";

    public static final User MACIEJ_STAFIJOWSKI = new User("maciej.stafijowski@solsoft.pl", PASSWORD, "maciej.stafijowski@solsoft.pl");
    public static final User WRONG_PASSWORD = new User("maciej.stafijowski@solsoft.pl", "wrongpssw", "maciej.stafijowski@solsoft.pl");
    public static final User WRONG_LOGIN = new User ("wronguser@solsoft.pl", PASSWORD, "maciej.stafijowski@solsoft.pl");




}
