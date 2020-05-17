package domain;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class UserTest extends TestCase {
    User user=new User("1","2","3");

    //Test the method which return a string value.
    @Test
    public void testUser() {
        String name=user.getUser_name();
        Assert.assertEquals("1",name);

    }
}