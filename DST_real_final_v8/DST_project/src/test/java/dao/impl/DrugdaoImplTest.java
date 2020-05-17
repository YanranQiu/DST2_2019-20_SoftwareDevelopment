package dao.impl;

import dao.IDrugdao;
import domain.Drug;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.List;

public class DrugdaoImplTest extends TestCase {

    @Test
    public void testDrugdao() {
        IDrugdao dao = new DrugdaoImpl();
        Drug d = new Drug("1","2",true,"3","4");
        // save d into dao by using the saveDosingGuideline() method
        dao.saveDrug(d);
        // get the information in the table using findAll() method and compare it with the content of d.
        List<Drug> drugs = dao.findAll();
        System.out.println(drugs.get(0));
    }
}