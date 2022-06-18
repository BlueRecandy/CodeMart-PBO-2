package io.bluerecandy.codemart.gui.service;

import io.bluerecandy.codemart.gui.model.Account;
import io.bluerecandy.codemart.gui.model.User;
import io.bluerecandy.codemart.gui.sql.SQLConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersService {

    private static UsersService instance = null;

    public static UsersService getInstance(){
        if (instance == null) instance = new UsersService();
        return instance;
    }

    private final static String SELECT_USER_BY_ID = "SELECT * FROM users WHERE id = ?;";

    private final static String INSERT_USER_REGISTER = "INSERT INTO users(id, name) VALUES(?, ?);";

    private final static String UPDATE_USER_COIN = "UPDATE users SET coin=? WHERE id=?;";

    private UsersService(){}


    public User getUserById(int id){
        User found = null;
        Connection connection = SQLConnector.getInstance().connect();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_USER_BY_ID);
            statement.setInt(1, id);

            ResultSet rs = statement.executeQuery();
            if (rs.next()){
                found = processUserResultSet(rs);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return found;
    }

    public boolean createUser(int id, String name){
        Connection connection = SQLConnector.getInstance().connect();
        try {
            PreparedStatement statement = connection.prepareStatement(INSERT_USER_REGISTER);
            statement.setInt(1, id);
            statement.setString(2, name);

            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void setUserName(int id, String newName){
        User user = getUserById(id);
        if (user != null){
            user.setName(newName);

            // TODO Update name at database
        }
    }

    public void addUserCoin(User user, int amount){
        if (user != null){
            user.setCoin(user.getCoin() + amount);

            // TODO Update coin at database
            Connection connection = SQLConnector.getInstance().connect();
            try {
                PreparedStatement statement = connection.prepareStatement(UPDATE_USER_COIN);
                statement.setInt(1, user.getCoin());
                statement.setInt(2, user.getId());

                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean subtractUserCoin(int id, int amount){
        User user = getUserById(id);
        if (user != null){
            int coin = user.getCoin();
            if (coin >= amount) {
                user.setCoin(user.getCoin() - amount);

                // TODO Update coin at database
                return true;
            }else{
                return false;
            }
        }
        return false;
    }

    private User processUserResultSet(ResultSet rs) throws SQLException {
        int userId = rs.getInt(1);
        String name = rs.getString(2);
        int coin = rs.getInt(3);

        Account account = AccountsService.getInstance().getAccountById(userId);

        User user = new User();
        user.setId(userId);
        user.setName(name);
        user.setCoin(coin);
        user.setAccount(account);

        return user;
    }

}
