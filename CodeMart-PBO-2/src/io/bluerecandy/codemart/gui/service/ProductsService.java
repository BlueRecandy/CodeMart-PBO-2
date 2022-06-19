package io.bluerecandy.codemart.gui.service;

import io.bluerecandy.codemart.gui.model.Product;
import io.bluerecandy.codemart.gui.model.User;
import io.bluerecandy.codemart.gui.sql.SQLConnector;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
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
    private final static String SELECT_PRODUCT_BY_OWNER_AND_NAME = "SELECT * FROM products WHERE owner_id = ? AND name = ?;";
    private final static String SELECT_PRODUCT_FILE = "SELECT name, version, file FROM products WHERE id = ?;";

    private final static String INSERT_PRODUCT_ALL = "INSERT INTO products(name, version, description, price, owner_id, file) VALUES (?,?,?, ?,?,?);";
    private final static String INSERT_PRODUCT_NO_FILE = "INSERT INTO products(name, version, description, price, owner_id) VALUES (?,?,?, ?,?);";

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
        }catch (SQLException | IOException e){
            e.printStackTrace();
        }

        return found;
    }

    public Product getOwnerProductsByName(int ownerId, String name){
        Connection connect = SQLConnector.getInstance().connect();
        PreparedStatement statement = null;
        try {
            statement = connect.prepareStatement(SELECT_PRODUCT_BY_OWNER_AND_NAME);
            statement.setInt(1, ownerId);
            statement.setString(2, name);

            ResultSet rs = statement.executeQuery();
            if (rs.next()){
                return processProductResultSet(rs);
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        return null;
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

        } catch (SQLException | IOException e) {
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

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }

        return products;
    }

    public boolean uploadProduct(String name, String version, String description, int price, int ownerId, File file){
        Connection connect = SQLConnector.getInstance().connect();

        boolean isCreated = getOwnerProductsByName(ownerId, name) != null;
        boolean hasSourceFile = file != null;

        if (isCreated){
            return false;
        }

        try {
            PreparedStatement statement = connect.prepareStatement(hasSourceFile ? INSERT_PRODUCT_ALL : INSERT_PRODUCT_NO_FILE);
            statement.setString(1, name);
            statement.setString(2, version);
            statement.setString(3, description);
            statement.setInt(4, price);
            statement.setInt(5, ownerId);

            if (hasSourceFile){
                FileInputStream fis = new FileInputStream(file);
                statement.setBinaryStream(6, fis, file.length());
            }

            statement.executeUpdate();
            return true;
        } catch (SQLException | FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }
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

    public File download(int productId){
        File file = null;
        Connection connect = SQLConnector.getInstance().connect();
        try {
            PreparedStatement statement = connect.prepareStatement(SELECT_PRODUCT_FILE);
            statement.setInt(1, productId);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                Blob fileBlob = resultSet.getBlob(3);
                if (fileBlob != null) {
                    InputStream inputStream = fileBlob.getBinaryStream();
                    String name = resultSet.getString(1);
                    String version = resultSet.getString(2);
                    String fileName = name + "-" + version + ".zip";

                    file = new File(fileName);
                    FileOutputStream outputStream = new FileOutputStream(file);

                    byte[] buffer = new byte[1024];
                    while (inputStream.read(buffer) > 0) {
                        outputStream.write(buffer);
                    }

                    inputStream.close();
                    outputStream.flush();
                    outputStream.close();
                }
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        return file;
    }

    private Product processProductResultSet(ResultSet rs) throws SQLException, IOException {
        Product product = new Product();

        int id = rs.getInt(1);
        String name = rs.getString(2);
        String version = rs.getString(3);
        String description = rs.getString(4);
        int price = rs.getInt(5);
        int ownerId = rs.getInt(6);

        product.setId(id);
        product.setName(name);
        product.setVersion(version);
        product.setDescription(description);
        product.setPrice(price);

        User user = UsersService.getInstance().getUserById(ownerId);
        product.setOwner(user);

        return product;
    }

}
