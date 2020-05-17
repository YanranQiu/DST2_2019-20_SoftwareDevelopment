package domain;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class DosingGuidelineTest extends TestCase {
    DosingGuideline dosingGuideline=new DosingGuideline("1","2","3",true,"4","5","6","7","8");

    //Test the method which return a string value.
    @Test
    public void testgetID() {
        String id=dosingGuideline.getDrugId();
        Assert.assertEquals("4",id);

    }

    //Test the method which return a boolean value.
    @Test
    public void testisRecommendation() {

        Boolean recommendation=dosingGuideline.isRecommendation();
        Assert.assertTrue(recommendation);

    }



}

