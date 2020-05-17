package dao.impl;

import dao.IDosingGuidelinedao;
import domain.DosingGuideline;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.List;

public class DosingGuidelinedaoImplTest extends TestCase {


    @Test
    public void testDosingGuidelinedao() {
        IDosingGuidelinedao dao = new DosingGuidelinedaoImpl();
        DosingGuideline d = new DosingGuideline("1","2","3",true,"4","5","6","7","8");
        // save d into dao by using the saveDosingGuideline() method
        dao.saveDosingGuideline(d);
        // get the information in the table using findAll() method and compare it with the content of d.
        List<DosingGuideline> dosingGuidelines = dao.findAll();
        String id= d.getId();
        System.out.println(dosingGuidelines.get(0));
    }
}