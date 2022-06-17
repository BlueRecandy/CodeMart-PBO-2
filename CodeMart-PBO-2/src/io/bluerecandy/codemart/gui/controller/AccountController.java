package io.bluerecandy.codemart.gui.controller;

import io.bluerecandy.codemart.gui.model.Account;
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

    public Account login(String email, final char[] password){
        boolean isSuccess = accountsService.login(email, password);

        if (isSuccess){
            return accountsService.getAccountByEmail(email);
        }

        return null;
    }

    public boolean register(String email, String name, char[] password){
        return accountsService.register(email, name, password);
    }

}
