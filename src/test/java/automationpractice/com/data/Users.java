package automationpractice.com.data;

        import automationpractice.com.domain.User;
        import org.apache.commons.lang3.RandomStringUtils;

public class Users {
    public static final User MACIEJ_STAFIJOWSKI = new User("maciej.stafijowski@solsoft.pl", "12345678");

    private static final String PASSWORD = "12345678";

//    public static final User WITH_OBJECT_NUMBER = new User("selenium2", PASSWORD, "selenium2@opoTest.pl");
//    public static final User WITH_NOT_UNIQUE_EMAIL = new User("selenium4", PASSWORD, "selenium4@test.pl");
//    public static final User WITH_LOGIN_SAME_AS_NOT_UNIQUE_EMAIL = new User("selenium7@test.pl", PASSWORD, "selenium7@test.pl");

    final private String randomString = RandomStringUtils.randomAlphanumeric(13);
    final private String randomEmail = String.format("%s@gmai.com", randomString);


}
