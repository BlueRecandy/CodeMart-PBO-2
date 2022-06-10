package io.bluerecandy.codemart.gui.service;

import io.bluerecandy.codemart.gui.model.User;

public class UsersService {

    private static UsersService instance = null;

    public static UsersService getInstance(){
        if (instance == null) instance = new UsersService();
        return instance;
    }

    private UsersService(){}


    public User getUserById(int id){
        User found = null;
        // TODO find user by id in db

        return found;
    }

    public void setUserName(int id, String newName){
        User user = getUserById(id);
        if (user != null){
            user.setName(newName);

            // TODO Update name at database
        }
    }

    public void addUserCoin(int id, int amount){
        User user = getUserById(id);
        if (user != null){
            user.setCoin(user.getCoin() + amount);

            // TODO Update coin at database
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

}
