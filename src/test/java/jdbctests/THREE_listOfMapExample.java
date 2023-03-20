package jdbctests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.*;

public class THREE_listOfMapExample {
    String dbUrl = "jdbc:oracle:thin:@54.236.47.147:1521:XE";
    String dbUsername = "hr";
    String dbPassword = "hr";

    @DisplayName("ListOfMapTask")
    @Test
    public void test1() throws SQLException {

        //creating list for keeping all the rows map
        List<Map<String,Object>> queryData = new ArrayList<>();


        Map<String, Object> row1 = new HashMap<>();

        row1.put("FIRST_NAME", "Steven");
        row1.put("Last_Name", "King");
        row1.put("salary",24000);
        row1.put("Job_ID","Ad_Press");
        System.out.println(row1.toString());



        Map<String,Object> row2= new HashMap<>();

        row2.put("FIRST_NAME", "Neena");
        row2.put("Last_Name", "Kochhar");
        row2.put("salary",17000);
        row2.put("Job_ID","Ad_VP");
        System.out.println(row2.toString());


        // adding rows one by one to my list
        queryData.add(row1);
        queryData.add(row2);

        System.out.println("-----");
        // get the Steven lastname directly from the list
        System.out.println(queryData.get(0).get("Last_Name"));// ilk get list için(roew number ı gösterir) ikinci get map için

        System.out.println("-----");
        // get the Neena salary directly from the list
        System.out.println(queryData.get(1).get("salary"));

    }

    @Test
    public  void test2() throws SQLException {
        Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);// Connection ve DriverManager java.sql olmalı -helps our java project connect to database
        Statement statement = connection.createStatement(); //Statement =>helps to write and execute SQL query
        ResultSet resultSet = statement.executeQuery("SELECT * FROM departments"); //ResultSet=> a database structure where we can store the data that came from database

        //creating list for keeping all the rows map
        List<Map<String,Object>> queryData = new ArrayList<>();


        Map<String, Object> row1 = new HashMap<>();

        row1.put("FIRST_NAME", "Steven");
        row1.put("Last_Name", "King");
        row1.put("salary",24000);
        row1.put("Job_ID","Ad_Press");
        System.out.println(row1.toString());


        Map<String,Object> row2= new HashMap<>();

        row2.put("FIRST_NAME", "Neena");
        row2.put("Last_Name", "Kochhar");
        row2.put("salary",17000);
        row2.put("Job_ID","Ad_VP");
        System.out.println(row2.toString());


        // adding rows one by one to my list
        queryData.add(row1);
        queryData.add(row2);




        connection.close();
        statement.close();
        resultSet.close();
    }


}
