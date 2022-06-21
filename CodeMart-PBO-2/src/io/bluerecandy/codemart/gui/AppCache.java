package io.bluerecandy.codemart.gui;

import io.bluerecandy.codemart.gui.model.Account;
import io.bluerecandy.codemart.gui.model.User;

import java.io.File;

public class AppCache {

    private static AppCache instance = null;

    public static AppCache getInstance(){
        if (instance == null) instance = new AppCache();
        return instance;
    }

    private Account activeAccount = null;
    private User activeUser = null;

    private File choosenFile = null;

    private AppCache(){}

    public File getChoosenFile() {
        return choosenFile;
    }

    public void setChoosenFile(File choosenFile) {
        this.choosenFile = choosenFile;
    }

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
