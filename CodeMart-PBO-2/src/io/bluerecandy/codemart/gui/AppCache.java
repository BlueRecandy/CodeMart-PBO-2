package io.bluerecandy.codemart.gui;

import io.bluerecandy.codemart.gui.model.Account;
import io.bluerecandy.codemart.gui.model.User;

public class AppCache {

    private static AppCache instance = null;

    public static AppCache getInstance(){
        if (instance == null) instance = new AppCache();
        return instance;
    }

    private Account activeAccount = null;
    private User activeUser = null;

    private AppCache(){}

    public Account getActiveAccount() {
        return activeAccount;
    }

    public void setActiveAccount(Account activeAccount) {
        this.activeAccount = activeAccount;
    }

    public User getActiveUser() {
        return activeUser;
    }

    public void setActiveUser(User activeUser) {
        this.activeUser = activeUser;
    }
}
