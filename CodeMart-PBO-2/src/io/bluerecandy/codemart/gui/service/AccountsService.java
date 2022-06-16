package io.bluerecandy.codemart.gui.service;

import io.bluerecandy.codemart.gui.model.Account;
import io.bluerecandy.codemart.gui.model.User;
import io.bluerecandy.codemart.gui.model.UserProducts;
import io.bluerecandy.codemart.gui.sql.SQLConnector;
import io.bluerecandy.codemart.gui.utils.IdUtility;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class AccountsService {

    private static AccountsService instance = null;

    public static AccountsService getInstance(){
        if (instance == null) instance = new AccountsService();
        return instance;
    }

    private AccountsService(){}

    public Account getAccountByEmail(String email){
        Account found = null;
        // TODO get account by email in db

        return found;
    }

    public boolean login(String email, String password){
        Account account = getAccountByEmail(email);
        if (!account.isLoggedIn() && account.getPassword().equals(password)){
            // TODO Set account logged in state to true
            // TODO Update account data to db
            return true;
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
