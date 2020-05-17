package domain;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class DrugTest extends TestCase {
    Drug drug = new Drug("1","2",true,"3","4");

    //Test the method which return a string value.
    @Test
    public void testgetID() {
        String id= drug.getId();
        Assert.assertEquals("1",id);


    }

    //Test the method which return a boolean value.
    @Test
    public void testisBiomarker() {

        Boolean biomarker =drug.isBiomarker();
        Assert.assertTrue(biomarker);

    }
}