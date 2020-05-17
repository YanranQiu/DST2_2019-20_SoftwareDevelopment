package dao.impl;

import dao.IUserdao;
import domain.User;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class UserdaoImplTest extends TestCase {

    @Test
    public void testuserdao() {
        IUserdao dao = new UserdaoImpl();
        User user= new User("1","2","3");
        // save d into dao by using the saveDosingGuideline() method
        dao.saveUserInfo(user);
        // Test whether the user information has been imported by using the findPassword() method.
        Assert.assertEquals(true,dao.findPassword(user));


    }
}