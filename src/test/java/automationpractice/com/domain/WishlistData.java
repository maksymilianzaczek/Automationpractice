package automationpractice.com.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.lang3.RandomStringUtils;

@Getter
@AllArgsConstructor
public class WishlistData {
    public final static String WISH_LIST_NAME = String.format("wishlist%s", RandomStringUtils.randomNumeric(5));

}
