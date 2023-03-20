package jdbctests;

import java.sql.*;

public class TestConnection {
    public static void main(String[] args) throws SQLException {

        //Connection String
        //dbUrl=jdbc:oracle:thin:@yourIPaddressandPort:1521:XE  ==> Database projeye git sağdaki Kırmızı HR 'e sağ click=> click properties
        //dbUsername="hr";
        //dbPassword="hr";
        String dbUrl = "jdbc:oracle:thin:@54.236.47.147:1521:XE";
        String dbUsername = "hr";
        String dbPassword = "hr";


        Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);// Connection ve DriberManager java.sql olmalı -helps our java project connect to database
        Statement statement = connection.createStatement(); //Statement =>helps to write and execute SQL query
        ResultSet resultSet = statement.executeQuery("SELECT * FROM regions"); //ResultSet=> a database structure where we can store the data that came from database

        /*
        resultSet.next();// next() --> in default pointer in 0(zero) row. with next() method move pointer to first row şu anda 1. satırda
        //getting information with column name
        System.out.println(resultSet.getString("Region_ID")); // in string case insensitive //1


        resultSet.next(); // şu anda 2. satırda
        System.out.println(resultSet.getString("region_name")); // Americas


        //getting information with column index (index starts 1)
        System.out.println(resultSet.getInt(1)); // sonuç=2 bu bize 2. satırdaki ilk sutün datasını getir demektedir.
        System.out.println(resultSet.getString(2)); // sonuç =Americas 2.satırdaki 2. sütunu getir.  getInt(2);==> dersek hata verir çünkü 2 satır da string data var(Americas) o yüzden getString() metodunu kullanmalısın


        System.out.println(resultSet.getInt(1) + " - " + resultSet.getString(2));

        resultSet.next();
        System.out.println(resultSet.getInt(1) + " - " + resultSet.getString(2));
*/

        System.out.println("-------------------");
        while (resultSet.next()) {
            System.out.println(resultSet.getInt(1) + " - " + resultSet.getString(2));
        }


        //close connection
        connection.close();
        statement.close();
        resultSet.close();

    }
}
