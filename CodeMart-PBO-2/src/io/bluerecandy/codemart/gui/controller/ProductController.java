package io.bluerecandy.codemart.gui.controller;

public class ProductController {

    private static ProductController instance = null;

    public static ProductController getInstance(){
        if (instance == null) instance = new ProductController();
        return instance;
    }

    private ProductController(){}

}
