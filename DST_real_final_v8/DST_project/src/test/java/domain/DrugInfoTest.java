package domain;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class DrugInfoTest extends TestCase {
    DrugInfo info =new DrugInfo("1","2","3","4",true,true,true,"6","7","8","9");

    //Test the method which return a string value.
    @Test
    public void testgetId() {
        String dosingguidelineid=info.getDosing_guideline_id();
        Assert.assertEquals("1",dosingguidelineid);

    }

    //Test the method which return a boolean value.
    @Test
    public void testgetbiomarker() {

        Boolean biomarker=info.getDrug_biomarker();
        Assert.assertTrue(biomarker);

    }
}