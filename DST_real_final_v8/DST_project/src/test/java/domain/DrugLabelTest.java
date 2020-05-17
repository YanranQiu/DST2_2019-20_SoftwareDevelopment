package domain;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class DrugLabelTest extends TestCase {
    DrugLabel drugLabel =new DrugLabel("1","2","3",true,true,"5","6","7","8","9","10");

    //Test the method which return a string value.
    @Test
    public void testgetID() {
        String id=drugLabel.getDrugId();
        Assert.assertEquals("10",id);

    }

    //Test the method which return a boolean value.
    @Test
    public void testisDosingInformation() {

        Boolean dosinginformation =drugLabel.isDosingInformation();
        Assert.assertTrue(dosinginformation);
    }
}