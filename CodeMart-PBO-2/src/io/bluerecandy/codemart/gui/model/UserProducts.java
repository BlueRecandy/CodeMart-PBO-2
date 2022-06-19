package io.bluerecandy.codemart.gui.model;

import java.util.ArrayList;
import java.util.List;

public class UserProducts {

    private int userId;
    private List<PurchasedProduct> purchasedProducts = new ArrayList<>();

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<PurchasedProduct> getPurchasedProducts() {
        return purchasedProducts;
    }

    public void setPurchasedProducts(List<PurchasedProduct> purchasedProducts) {
        this.purchasedProducts = purchasedProducts;
    }
}
