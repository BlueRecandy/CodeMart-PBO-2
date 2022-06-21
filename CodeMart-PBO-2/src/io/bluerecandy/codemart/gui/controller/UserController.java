package io.bluerecandy.codemart.gui.controller;

import io.bluerecandy.codemart.gui.model.Product;
import io.bluerecandy.codemart.gui.model.PurchasedProduct;
import io.bluerecandy.codemart.gui.model.User;
import io.bluerecandy.codemart.gui.model.UserProducts;
import io.bluerecandy.codemart.gui.service.ProductsService;
import io.bluerecandy.codemart.gui.service.PurchasesService;
import io.bluerecandy.codemart.gui.service.UsersService;

import java.io.File;
import java.sql.SQLException;

public class UserController {

    private static UserController instance = null;

    public static UserController getInstance(){
        if (instance == null) instance = new UserController();
        return instance;
    }

    private final UsersService usersService;
    private final PurchasesService purchasesService;
    private final ProductsService productsService;

    private UserController(){
        usersService = UsersService.getInstance();
        purchasesService = PurchasesService.getInstance();
        productsService = ProductsService.getInstance();
    }

    /**
     * Get user object model by using its id
     *
     * @param id user's id
     * @return user object
     */
    public User getUserById(int id){
        User user = usersService.getUserById(id);

        UserProducts userProducts = new UserProducts();
        userProducts.setUserId(id);
        try {
            userProducts.setPurchasedProducts(purchasesService.getAllLog(id));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        user.setUserProducts(userProducts);

        return user;
    }

    public PurchasedProduct purchaseProduct(User user, Product product){
        if (user.getCoin() >= product.getPrice()) {
            try {
                user.setCoin(user.getCoin() - product.getPrice());
                boolean successPay = usersService.subtractUserCoin(user.getId(), product.getPrice());
                boolean successReceive = usersService.addUserCoin(product.getOwner(), product.getPrice());
                boolean successPayment = successPay && successReceive;

                if (successPayment) {
                    boolean successCreateLog = purchasesService.createPurchaseLog(user.getId(), product.getId());

                    if (successCreateLog) {
                        PurchasedProduct log = purchasesService.getLog(user.getId(), product.getId());
                        user.getUserProducts().getPurchasedProducts().add(log);
                        return log;
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public boolean download(int productId){
        File file = productsService.download(productId);
        return file != null;
    }

    public void topUp(User user, int amount){
        usersService.addUserCoin(user, amount);
    }

    public void changeName(int id, String newName){
        usersService.setUserName(id, newName);
    }

}