package io.bluerecandy.codemart.gui.model;

import java.util.List;

public class UserProducts {

    private int userId;
    private List<Product> ownedProducts, purchasedProducts;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<Product> getOwnedProducts() {
        return ownedProducts;
    }

    public void setOwnedProducts(List<Product> ownedProducts) {
        this.ownedProducts = ownedProducts;
    }

    public List<Product> getPurchasedProducts() {
        return purchasedProducts;
    }

    public void setPurchasedProducts(List<Product> purchasedProducts) {
        this.purchasedProducts = purchasedProducts;
    }
}
