package com.unitri.comp.ecommerce.model.entity;

public class CartItems {

    private int id;
    private int cart;
    private int product;
    private double total_price;
    private int quantity;

    public CartItems(int id, int cart, int product, double total_price, int quantity) {
        this.id = id;
        this.cart = cart;
        this.product = product;
        this.total_price = total_price;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCart() {
        return cart;
    }

    public void setCart(int cart) {
        this.cart = cart;
    }

    public int getProduct() {
        return product;
    }

    public void setProduct(int product) {
        this.product = product;
    }

    public double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
