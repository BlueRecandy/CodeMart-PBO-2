package io.bluerecandy.codemart.gui.controller;

import io.bluerecandy.codemart.gui.model.Product;
import io.bluerecandy.codemart.gui.service.ProductsService;

import java.io.File;
import java.util.List;

public class ProductController {

    private static ProductController instance = null;

    public static ProductController getInstance(){
        if (instance == null) instance = new ProductController();
        return instance;
    }


    private ProductsService productsService;
    private ProductController(){
        productsService = ProductsService.getInstance();
    }

    public Product uploadProduct(String name, String version, String description, int price, int ownerId, File file){
        boolean isSuccess = productsService.uploadProduct(name, version, description, price, ownerId, file);

        if (isSuccess){
            return productsService.getOwnerProductsByName(ownerId, name);
        }
        return null;
    }

    public List<Product> getOwnerProducts(int ownerId){
        return productsService.getOwnerProducts(ownerId);
    }

    public List<Product> getAllProducts(){
        return productsService.getAllProducts();
    }

}
