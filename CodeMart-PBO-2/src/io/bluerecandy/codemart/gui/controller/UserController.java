package io.bluerecandy.codemart.gui.controller;

import io.bluerecandy.codemart.gui.model.Product;
import io.bluerecandy.codemart.gui.model.User;
import io.bluerecandy.codemart.gui.service.ProductsService;
import io.bluerecandy.codemart.gui.service.UsersService;

public class UserController {

    private static UserController instance = null;

    public static UserController getInstance(){
        if (instance == null) instance = new UserController();
        return instance;
    }

    private final UsersService usersService;
    private final ProductsService productsService;

    private UserController(){
        usersService = UsersService.getInstance();
        productsService = ProductsService.getInstance();
    }

    public User getUserById(int id){
        return usersService.getUserById(id);
    }

    public void topUp(User user, int amount){
        usersService.addUserCoin(user, amount);
    }

    public void changeName(int id, String newName){
        usersService.setUserName(id, newName);
    }

    public void uploadProduct(int id, Product product){

    }

    public void purchaseProduct(int userId, int productId){
    }

    public void downloadProduct(int userId, int productId){

    }

}
