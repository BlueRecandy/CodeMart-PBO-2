package io.bluerecandy.codemart.gui.service;

import io.bluerecandy.codemart.gui.model.Account;
import io.bluerecandy.codemart.gui.sql.SQLConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

public class AccountsService {

    private static AccountsService instance = null;

    public static AccountsService getInstance(){
        if (instance == null) instance = new AccountsService();
        return instance;
    }

    private final static String SELECT_ACCOUNT_BY_ID = "SELECT * FROM accounts WHERE id = ?;";
    private final static String SELECT_ACCOUNT_BY_EMAIL = "SELECT * FROM accounts WHERE email = ?;";

    private final static String INSERT_ACCOUNT_REGISTER = "INSERT INTO accounts(email, password) VALUES (?,?);";

    private final static String UPDATE_ACCOUNT_LOGGED = "UPDATE accounts SET is_logged=? WHERE id = ?;";

    private AccountsService(){}

    public Account getAccountById(int id){
        Account found = null;

        try{
            Connection connect = SQLConnector.getInstance().connect();
            PreparedStatement statement = connect.prepareStatement(SELECT_ACCOUNT_BY_ID);
            statement.setInt(1, id);

            ResultSet rs = statement.executeQuery();

            if (rs.next()){
                found = processAccountResultSet(rs);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return found;
    }

    public Account getAccountByEmail(String email){
        Account found = null;

        // TODO get account by email in db
        Connection connection = SQLConnector.getInstance().connect();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_ACCOUNT_BY_EMAIL);
            statement.setString(1, email);

            ResultSet result = statement.executeQuery();
            if (result.next()){
                found = processAccountResultSet(result);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return found;
    }

    public boolean login(String email, char[] password){
        Account account = getAccountByEmail(email);
        if (account != null) {
            if (!account.isLoggedIn() && Arrays.equals(account.getPassword(), password)) {
                account.setLoggedIn(true);
                updateAccount(account.getId(), account.isLoggedIn());
                return true;
            }
        }
        return false;
    }

    public boolean updateAccount(int id, boolean isLoggedIn){
        Connection connection = SQLConnector.getInstance().connect();
        try {
            PreparedStatement statement = connection.prepareStatement(UPDATE_ACCOUNT_LOGGED);
            statement.setInt(1, isLoggedIn ? 1 : 0);
            statement.setInt(2, id);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean createAccount(String email, char[] password){
        if (getAccountByEmail(email) != null) {
            return false;
        }

        Connection connection = SQLConnector.getInstance().connect();
        try {
            PreparedStatement statement = connection.prepareStatement(INSERT_ACCOUNT_REGISTER);
            statement.setString(1, email);
            statement.setString(2, String.valueOf(password));
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private Account processAccountResultSet(ResultSet result) throws SQLException {
        int id = result.getInt(1);
        String email = result.getString(2);
        final char[] password = result.getString(3).toCharArray();
        int isLoggedInInteger = result.getInt(4);
        boolean isLoggedIn = isLoggedInInteger == 1;

        Account account = new Account();
        account.setId(id);
        account.setEmail(email);
        account.setPassword(password);
        account.setLoggedIn(isLoggedIn);

        return account;
    }

}
