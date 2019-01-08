package automationpractice.com.data;

import automationpractice.com.domain.UserData;
import org.apache.commons.lang3.RandomStringUtils;

public class Users {
    public static final UserData MACIEJ_STAFIJOWSKI = new UserData("maciej.stafijowski@solsoft.pl",
            "12345678", "Maciej", "Stafijowski");

    private static final String RANDOM_STRING = RandomStringUtils.randomAlphanumeric(13);
    public static final String RANDOM_EMAIL = String.format("%s@gmai.com", RANDOM_STRING);
}
