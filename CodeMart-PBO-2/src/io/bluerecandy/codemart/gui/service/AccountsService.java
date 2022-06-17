package io.bluerecandy.codemart.gui.service;

import io.bluerecandy.codemart.gui.model.Account;
import io.bluerecandy.codemart.gui.model.User;
import io.bluerecandy.codemart.gui.model.UserProducts;
import io.bluerecandy.codemart.gui.sql.SQLConnector;
import io.bluerecandy.codemart.gui.utils.IdUtility;
import java.sql.Connection;
import java.sql.PreparedStatement;

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

    private final static String SELECT_ACCOUNT_BY_EMAIL = "SELECT * FROM accounts WHERE email = ?;";

    private AccountsService(){}

    public Account getAccountByEmail(String email){
        Account found = null;

        // TODO get account by email in db
        Connection connection = SQLConnector.getInstance().connect();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_ACCOUNT_BY_EMAIL);
            statement.setString(1, email);

            ResultSet result = statement.executeQuery();
            while (result.next()){
                int id = result.getInt(1);
                final char[] password = result.getString(3).toCharArray();
                int isLoggedInInteger = result.getInt(4);
                boolean isLoggedIn = isLoggedInInteger == 1;

                Account account = new Account();
                account.setId(id);
                account.setEmail(email);
                account.setPassword(password);
                account.setLoggedIn(isLoggedIn);

                found = account;
                break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return found;
    }

    public boolean login(String email, char[] password){
        Account account = getAccountByEmail(email);
        if (!account.isLoggedIn() && Arrays.equals(account.getPassword(), password)){
            // TODO Set account logged in state to true
            System.out.println(account);
            // TODO Update account data to db
            return true;
        }else if (account.isLoggedIn()){
            // TODO Send alert if account has been logged in
        }
        return false;
    }

    public boolean register(String email, String name, char[] password){
        if (getAccountByEmail(email) == null){
            Account account = new Account();

            account.setId(IdUtility.generateRandomId());
            account.setEmail(email);
            account.setPassword(password);

            User user = new User();
            user.setId(account.getId());
            user.setName(name);
            user.setCoin(0);
            user.setUserProducts(new UserProducts());
            user.setAccount(account);

            // TODO Insert account and user to db
            Connection connection = SQLConnector.getInstance().connect();
            try{
                String query = "INSERT INTO 'accounts'('email', 'password') VALUES(?,?)";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1, email);
                statement.setString(2, String.valueOf(password));
                statement.executeUpdate();
                return true;
            } catch(Exception e){
                e.printStackTrace();
            }
            
        }
        return false;
    }

}
