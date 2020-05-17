package AppConfig;

import appconfig.AppConfig;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class AppConfigTest {
    AppConfig a=new AppConfig();

    @Test
    public void testgetJdbcUrl() {
        assertEquals("jdbc:mysql:///DBforDrug?serverTimezone=GMT%2B8&useSSL=false",a.getJdbcUrl());
    }

    @Test
    public void testgetJdbcUsername() {
        assertEquals("root",a.getJdbcUsername());
    }

    @Test
    public void testgetJdbcPassword() {
        assertEquals("129118cz",a.getJdbcPassword());
    }
}