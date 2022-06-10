/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.bluerecandy.codemart.gui.model;

/**
 *
 * @author Fathan
 */
public class User {
    
    private int id;
    private Account account;
    private String name;
    private UserProducts userProducts;
    private int coin = 0;

    public int getCoin() {
        return coin;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }

    public UserProducts getUserProducts() {
        return userProducts;
    }

    public void setUserProducts(UserProducts userProducts) {
        this.userProducts = userProducts;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
