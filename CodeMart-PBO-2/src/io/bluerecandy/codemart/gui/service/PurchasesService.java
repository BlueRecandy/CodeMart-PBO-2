package io.bluerecandy.codemart.gui.service;

import io.bluerecandy.codemart.gui.model.PurchasedProduct;
import io.bluerecandy.codemart.gui.sql.SQLConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PurchasesService {

    private static PurchasesService instance = null;

    public static PurchasesService getInstance(){
        if (instance == null) instance = new PurchasesService();
        return instance;
    }

    private final static String SELECT_PURCHASED_BY_CUSTOMER = "SELECT * FROM purchased_products WHERE customer_id = ?;";
    private final static String SELECT_PURCHASED_BY_CUSTOMER_AND_PRODUCT = "SELECT * FROM purchased_products WHERE customer_id = ? AND product_id = ?;";

    private final static String INSERT_PURCHASE_LOG = "INSERT INTO purchased_products(customer_id, product_id) VALUES (?,?);";

    private PurchasesService(){}

    public boolean createPurchaseLog(int userId, int productId) throws SQLException {
        Connection connect = SQLConnector.getInstance().connect();

        try {
            PreparedStatement statement = connect.prepareStatement(INSERT_PURCHASE_LOG);
            statement.setInt(1, userId);
            statement.setInt(2, productId);
            statement.executeUpdate();
            return true;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    public PurchasedProduct getLog(int userId, int productId) throws SQLException {
        Connection connect = SQLConnector.getInstance().connect();

        PreparedStatement statement = connect.prepareStatement(SELECT_PURCHASED_BY_CUSTOMER_AND_PRODUCT);
        statement.setInt(1, userId);
        statement.setInt(2, productId);

        ResultSet rs = statement.executeQuery();

        if (rs.next()) {
            return processPurchasedResultSet(rs);
        }
        return null;
    }

    public List<PurchasedProduct> getAllLog(int userId) throws SQLException {
        List<PurchasedProduct> purchasedProducts = new ArrayList<>();

        Connection connection = SQLConnector.getInstance().connect();

        PreparedStatement statement = connection.prepareStatement(SELECT_PURCHASED_BY_CUSTOMER);
        statement.setInt(1, userId);

        ResultSet rs = statement.executeQuery();

        while (rs.next()){
            PurchasedProduct p = processPurchasedResultSet(rs);
            purchasedProducts.add(p);
        }

        return purchasedProducts;
    }

    private PurchasedProduct processPurchasedResultSet(ResultSet rs) throws SQLException {
        PurchasedProduct product = new PurchasedProduct();

        int transactionId = rs.getInt(1);
        int productId = rs.getInt(2);
        int customerId = rs.getInt(3);

        product.setTransactionId(transactionId);
        product.setProductId(productId);
        product.setCustomerId(customerId);

        return product;
    }

}
