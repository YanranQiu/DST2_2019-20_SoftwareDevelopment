package DBtest;

import com.google.gson.Gson;
import dbutils.DBUtils;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.sql.*;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DBTest extends TestCase {

    //This test case is to check whether the database has been created correctly.
    @Test
    public void testDB() throws SQLException {
        //get list from .data file and get the length of the data
        Gson gson = new Gson();
        InputStream is = getClass().getResourceAsStream("/drugs.data");
        String drugsContent =
                new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8)).lines().parallel().collect(Collectors.joining("\n"));

        Map drugs = gson.fromJson(drugsContent, Map.class);
        List<Map> drugList = (List<Map>) drugs.get("data");
        int length=drugList.size();
        //get connection to the created database;
        Connection conn =DBUtils.getConnection();
        Statement stmt = conn.createStatement();
        //delete the row added by 'UserdaoImplTest'
        PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM `drug` WHERE (`id` = '1')");
        preparedStatement.execute();
        ResultSet rs = stmt.executeQuery("SELECT * FROM drug ");
        //get the whole row numbers of the data selected from the created database
        rs.last();
        int column=rs.getRow();

        //compare the length and column to check that whether the database has been created correctly.
        Assert.assertEquals(length,column);

        //close the connection
        stmt.close();
        conn.close();

    }



}


