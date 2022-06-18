package io.bluerecandy.codemart.gui.controller;

import io.bluerecandy.codemart.gui.model.Account;
import io.bluerecandy.codemart.gui.service.AccountsService;
import io.bluerecandy.codemart.gui.service.UsersService;

public class AccountController {

    private static AccountController instance = null;

    public static AccountController getInstance(){
        if (instance == null) instance = new AccountController();
        return instance;
    }

    private final AccountsService accountsService;
    private final UsersService usersService;

    private AccountController(){
        accountsService = AccountsService.getInstance();
        usersService = UsersService.getInstance();
    }

    public Account login(String email, final char[] password){
        boolean isSuccess = accountsService.login(email, password);

        if (isSuccess){
            return accountsService.getAccountByEmail(email);
        }

        return null;
    }

    public boolean register(String email, String name, char[] password){
        boolean accountSuccess = accountsService.createAccount(email, password);
        if (accountSuccess){
            Account account = accountsService.getAccountByEmail(email);
            return usersService.createUser(account.getId(), name);
        }
        return false;
    }

}
