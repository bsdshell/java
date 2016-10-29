import classfile.Print;

import java.sql.*;

// Notice, do not import com.mysql.jdbc.*
// or you will have problems!

public class Main {
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
                                     + "user=root&password="); // password is empty

            // Statements allow to issue SQL queries to the database
            statement = connect.createStatement();
            // Result set get the result of the SQL query
            resultSet = statement
                        .executeQuery("select * from testdb.item");
            if(resultSet.next()) {
                // get the second column
                String name = resultSet.getString(2);
                Print.pbl(name);
            }

            preparedStatement = connect
                                .prepareStatement("insert into  testdb.item (name, phone, email, description)values (?, ?, ?, ?)");
            // "myuser, webpage, datum, summary, COMMENTS from feedback.comments");
            // Parameters start with 1
            preparedStatement.setString(1, "You have to be the first");
            preparedStatement.setString(2, "You have to be the first");
            preparedStatement.setString(3, "The third of food");
            preparedStatement.setString(4, "Build an array strip");

            preparedStatement.executeUpdate();
        } catch (Exception ex) {
            // handle the error
            Print.pbl(ex.getMessage());
        }
    }
}
