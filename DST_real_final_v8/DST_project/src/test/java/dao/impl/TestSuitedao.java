package dao.impl;


import junit.framework.Test;
import junit.framework.TestSuite;


public class TestSuitedao extends TestSuite {
    public static Test suite(){
        TestSuite suite =new TestSuite();
        suite.addTestSuite(DrugdaoImplTest.class);
        suite.addTestSuite(DrugLabeldaoImplTest.class);
        suite.addTestSuite(DosingGuidelinedaoImplTest.class);
        suite.addTestSuite(UserdaoImplTest.class);


        return suite;

    }

}
