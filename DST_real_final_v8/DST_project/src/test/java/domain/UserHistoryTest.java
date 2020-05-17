package domain;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class UserHistoryTest extends TestCase {
    UserHistory history =new UserHistory("1","2","3","5","6","7");

    //Test the method which return a string value.
    @Test
    public void testUserHistory() {
        String name=history.getUser_name();
        Assert.assertEquals("1",name);
    }
}