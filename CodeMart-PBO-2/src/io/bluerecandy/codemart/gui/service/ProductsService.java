package io.bluerecandy.codemart.gui.service;

import io.bluerecandy.codemart.gui.model.Product;
import io.bluerecandy.codemart.gui.model.User;

public class ProductsService {

    private static ProductsService instance = null;

    public static ProductsService getInstance(){
        if (instance == null) instance = new ProductsService();
        return instance;
    }

    private ProductsService(){}

    public Product getProductById(int productId){
        Product found = null;
        // TODO Find product in db

        return found;
    }

    public void setProductName(int productId, String newName){
        Product product = getProductById(productId);
        if (product != null) {
            product.setName(newName);

            // TODO update product name to db
        }
    }

    public void setProductDescription(int productId, String newDescription){
        Product product = getProductById(productId);
        if (product != null) {
            product.setDescription(newDescription);

            // TODO update product description to db
        }
    }

}
