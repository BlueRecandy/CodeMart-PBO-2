package io.bluerecandy.codemart.gui.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLConnector {

    private static SQLConnector instance = null;

    public static SQLConnector getInstance(){
        if (instance == null) instance = new SQLConnector();
        return instance;
    }

    private Connection connection = null;

    private SQLConnector(){}

    public Connection connect(){
        try {
            if (connection == null || connection.isClosed()){
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public boolean isConnected(){
        try {
            return connection != null && !connection.isClosed();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
