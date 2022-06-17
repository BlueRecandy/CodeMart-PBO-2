package io.bluerecandy.codemart.gui.service;

import io.bluerecandy.codemart.gui.model.Product;
import io.bluerecandy.codemart.gui.model.User;
import io.bluerecandy.codemart.gui.sql.SQLConnector;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductsService {

    private static ProductsService instance = null;

    public static ProductsService getInstance(){
        if (instance == null) instance = new ProductsService();
        return instance;
    }

    private final static String SELECT_PRODUCT_BY_ID = "SELECT * FROM products WHERE id = ?;";

    private final static String SELECT_ALL_PRODUCTS = "SELECT * FROM products;";

    private final static String SELECT_PRODUCT_BY_OWNER = "SELECT * FROM products WHERE owner_id = ?;";

    private ProductsService(){}

    public Product getProductById(int productId){
        Product found = null;

        Connection connection = SQLConnector.getInstance().connect();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_PRODUCT_BY_ID);
            statement.setInt(1, productId);

            ResultSet rs = statement.executeQuery();
            if (rs.next()){
                found = processProductResultSet(rs);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return found;
    }

    public List<Product> getOwnerProducts(int ownerId){
        List<Product> products = new ArrayList<>();

        Connection connection = SQLConnector.getInstance().connect();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_PRODUCT_BY_OWNER);
            statement.setInt(1, ownerId);

            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                products.add(processProductResultSet(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return products;
    }

    public List<Product> getAllProducts(){
        List<Product> products = new ArrayList<>();

        Connection connection = SQLConnector.getInstance().connect();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(SELECT_ALL_PRODUCTS);

            while (rs.next()){
                products.add(processProductResultSet(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return products;
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

    private Product processProductResultSet(ResultSet rs) throws SQLException {
        Product product = new Product();

        int id = rs.getInt(1);
        String name = rs.getString(2);
        String version = rs.getString(3);
        String description = rs.getString(4);
        int price = rs.getInt(5);
        int ownerId = rs.getInt(6);
        Blob fileContent = rs.getBlob(7);

        product.setId(id);
        product.setName(name);
        product.setVersion(version);
        product.setDescription(description);
        product.setPrice(price);
        // TODO set owner using User Model

        return product;
    }

}
