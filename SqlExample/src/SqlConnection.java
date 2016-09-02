import java.util.*;
import java.io.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import classfile.*;

// Notice, do not import com.mysql.jdbc.*
// or you will have problems!

public class SqlConnection{
    public static void main(String[] args) {
        Connection connect = null;
        Statement statement = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {

            // -----------------------------------------------------
            // database: testdb
            // table: item
            // user: root
            // password: {empty}
            // no ssh: autoReconnect=true&useSSL=false 
            //-------------------------------------------------------------------------------- 
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connect = DriverManager
                      .getConnection("jdbc:mysql://localhost/testdb?autoReconnect=true&useSSL=false&"
                                     + "user=root&password=");

            // Statements allow to issue SQL queries to the database
            statement = connect.createStatement();
            // Result set get the result of the SQL query
            resultSet = statement
                        .executeQuery("select * from testdb.item");
            if(resultSet.next()){
                // get the second column
               String name = resultSet.getString(2);
                Print.plb(name);
            }
        }catch (Exception ex) {
            // handle the error
            Print.plb(ex.getMessage());
        }
    }
}
