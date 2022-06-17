package io.bluerecandy.codemart.gui.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLInitialization {

    private static SQLInitialization instance = null;

    public static SQLInitialization getInstance(){
        if (instance == null) instance = new SQLInitialization();
        return instance;
    }

    private final static String CREATE_TABLE_ACCOUNTS = "CREATE TABLE IF NOT EXISTS accounts(\n" +
            "    id INT PRIMARY KEY AUTO_INCREMENT,\n" +
            "    email VARCHAR(40) NOT NULL,\n" +
            "    password VARCHAR(64) NOT NULL,\n" +
            "    is_logged TINYINT NOT NULL DEFAULT 0\n" +
            ");";

    private final static String CREATE_TABLE_USERS = "CREATE TABLE IF NOT EXISTS users(\n" +
            "\tid INT PRIMARY KEY,\n" +
            "    name VARCHAR(36) NOT NULL,\n" +
            "    coin INT DEFAULT 0,\n" +
            "    CONSTRAINT FK_users_accounts_id FOREIGN KEY(id) REFERENCES accounts(id) ON DELETE CASCADE\n" +
            ");";

    private final static String CREATE_TABLE_PRODUCTS = "CREATE TABLE IF NOT EXISTS products(\n" +
            "\tid INT PRIMARY KEY AUTO_INCREMENT,\n" +
            "    name VARCHAR(36) NOT NULL,\n" +
            "    version VARCHAR(8) NOT NULL,\n" +
            "\tdescription VARCHAR(255) NOT NULL,\n" +
            "\tprice INT NOT NULL DEFAULT 0,\n" +
            "    owner_id INT NOT NULL,\n" +
            "\tfile BLOB,\n" +
            "    CONSTRAINT FK_products_accounts_id FOREIGN KEY(owner_id) REFERENCES accounts(id) ON DELETE CASCADE\n" +
            ");";

    private SQLInitialization(){}

    public void init(){
        createTable();
    }

    private void createTable(){
        Connection connection = SQLConnector.getInstance().connect();

        try {
            Statement s = connection.createStatement();
            s.executeUpdate(CREATE_TABLE_ACCOUNTS);
            s.executeUpdate(CREATE_TABLE_USERS);
            s.executeUpdate(CREATE_TABLE_PRODUCTS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
