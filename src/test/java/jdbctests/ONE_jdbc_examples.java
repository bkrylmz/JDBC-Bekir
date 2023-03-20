package jdbctests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.*;

public class ONE_jdbc_examples {


    String dbUrl = "jdbc:oracle:thin:@54.236.47.147:1521:XE";
    String dbUsername = "hr";
    String dbPassword = "hr";


    @Test
    public void test1() throws SQLException {
        Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);// Connection ve DriverManager java.sql olmalı -helps our java project connect to database
        Statement statement = connection.createStatement(); //Statement =>helps to write and execute SQL query
        ResultSet resultSet = statement.executeQuery("SELECT * FROM departments"); //ResultSet=> a database structure where we can store the data that came from database

        //move to first row
        //display departments table in 10 - Administration - 200 - 1700
        // resultSet.next();
        //  System.out.println(resultSet.getString(1)+ " - " + resultSet.getString(2) + " - " + resultSet.getInt(3) + " - " + resultSet.getInt(4));


        // all tables
        System.out.println("-----");
        while (resultSet.next()) {
            System.out.println(resultSet.getInt(1) + " - " + resultSet.getString(2) + " - " + resultSet.getInt(3) + " - " + resultSet.getInt(4));
        }

        connection.close();
        statement.close();
        resultSet.close();
    }


    @Test
    public void test2() throws SQLException {
        Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY); // TYPE_SCROLL_INSENSITIVE allow us to navigate up and down in query result, CONCUR_READ_ONLY=> read only  do not update the results
        ResultSet resultSet = statement.executeQuery("SELECT * FROM departments");


        // how to find how many rows we have for the query?
        // ==> move to last row and then get the row count
        resultSet.last();
        System.out.println(resultSet.getRow());
        //veya bu şekilde de yazılabilir
        // int rowCount= resultSet.getRow();
        //System.out.println(rowCount);

        System.out.println("------");


        // print all second column information
        resultSet.beforeFirst(); // çünkü pointer last row da onu başlangıç noktasına almamız gerekir

        while (resultSet.next()) {
            System.out.println(resultSet.getString(2));
        }


        connection.close();
        statement.close();
        resultSet.close();
    }

    @DisplayName("ResultSet Method")
    @Test
    public void test3() throws SQLException {
        Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY); // TYPE_SCROLL_INSENSITIVE allow us to navigate up and down in query result, CONCUR_READ_ONLY=> read only  do not update the results
        ResultSet resultSet = statement.executeQuery("SELECT * FROM departments");



        //get the database related inside the "dbMetadata" object
        DatabaseMetaData databaseMetaData = connection.getMetaData();

        System.out.println("dbMetadata.getUserName() = " + databaseMetaData.getUserName());
        System.out.println("dbMetadata.getDatabaseProductName() = " + databaseMetaData.getDatabaseProductName());
        System.out.println("dbMetadata.getDatabaseProductVersion() = " + databaseMetaData.getDatabaseProductVersion());
        System.out.println("dbMetadata.getDriverName() = " + databaseMetaData.getDriverName());
        System.out.println("dbMetadata.getDriverVersion() = " + databaseMetaData.getDriverVersion());
        System.out.println("dbMetadata.getURL() = " + databaseMetaData.getURL());
        System.out.println("---------");


        //get the "resultSetMetaData"
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

        // how many columns we have?
        int columnCounts = resultSetMetaData.getColumnCount();
        System.out.println("columnCounts = " + columnCounts);

        // getting columns names
        System.out.println("resultSetMetaData.getColumnName(1) = " + resultSetMetaData.getColumnName(1));
        System.out.println("resultSetMetaData.getColumnName(4) = " + resultSetMetaData.getColumnName(4));
        System.out.println("-----");

        // print all the column names dynamically

        for (int i = 1; i <= columnCounts; i++) {
            System.out.println("Column Name = " + resultSetMetaData.getColumnName(i));
        }

        connection.close();
        statement.close();
        resultSet.close();
    }


}
