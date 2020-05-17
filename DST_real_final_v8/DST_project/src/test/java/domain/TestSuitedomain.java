package domain;

import junit.framework.Test;
import junit.framework.TestSuite;


public class TestSuitedomain extends junit.framework.TestSuite {
    public static Test suite(){
     TestSuite suite =new TestSuite();
     suite.addTestSuite(UserTest.class);
     suite.addTestSuite(UserHistoryTest.class);
     suite.addTestSuite(DosingGuidelineTest.class);
     suite.addTestSuite(DrugInfoTest.class);
     suite.addTestSuite(DrugLabelTest.class);
     suite.addTestSuite(DrugTest.class);

     return suite;

    }

}
