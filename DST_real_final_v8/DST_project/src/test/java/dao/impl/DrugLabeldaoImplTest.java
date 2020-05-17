package dao.impl;

import dao.IDrugLabeldao;
import domain.DrugLabel;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.List;

public class DrugLabeldaoImplTest extends TestCase {

    @Test
    public void testDrugLabeldao() {
        IDrugLabeldao dao = new DrugLabeldaoImpl();
        DrugLabel d = new DrugLabel("1","2","3",true,true,"5","6","7","8","9","10");
        // save d into dao by using the saveDosingGuideline() method
        dao.saveDrugLabel(d);
        // get the information in the table using findAll() method and compare it with the content of d.dao.saveDrugLabel(d);
        List<DrugLabel> drugLabels = dao.findAll();
        System.out.println(drugLabels.get(0));
    }
}