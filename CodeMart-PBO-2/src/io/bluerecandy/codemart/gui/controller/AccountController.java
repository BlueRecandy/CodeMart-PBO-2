package io.bluerecandy.codemart.gui.controller;

import io.bluerecandy.codemart.gui.service.AccountsService;

public class AccountController {

    private static AccountController instance = null;

    public static AccountController getInstance(){
        if (instance == null) instance = new AccountController();
        return instance;
    }

    private final AccountsService accountsService;

    private AccountController(){
        accountsService = AccountsService.getInstance();
    }

    public boolean login(String email, String password){
        return accountsService.login(email, password);
    }

    public boolean register(String email, String name, String password){
        return accountsService.register(email, name, password);
    }

}
