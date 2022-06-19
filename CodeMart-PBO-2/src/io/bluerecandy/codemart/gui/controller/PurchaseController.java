package io.bluerecandy.codemart.gui.controller;

import io.bluerecandy.codemart.gui.model.Product;
import io.bluerecandy.codemart.gui.model.PurchasedProduct;
import io.bluerecandy.codemart.gui.model.User;
import io.bluerecandy.codemart.gui.service.PurchasesService;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class PurchaseController {

    private static PurchaseController instance = null;

    public static PurchaseController getInstance(){
        if (instance == null) instance = new PurchaseController();
        return instance;
    }

    private final PurchasesService purchasesService;

    private PurchaseController(){
        purchasesService = PurchasesService.getInstance();
    }

    public boolean hasPurchased(int userId, int productId){
        try {
            return purchasesService.getLog(userId, productId) != null;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<PurchasedProduct> getAllLog(int userId){
        try {
            return purchasesService.getAllLog(userId);
        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

}
