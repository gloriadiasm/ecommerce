package com.unitri.comp.ecommerce.model.entity;

public class OrderItems {

    private int id;
    private int client_order;
    private int product;
    private double price;
    private int quantity;

    public OrderItems(int id, int client_order, int product, double price, int quantity) {
        this.id = id;
        this.client_order = client_order;
        this.product = product;
        this.price = price;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClient_order() {
        return client_order;
    }

    public void setClient_order(int client_order) {
        this.client_order = client_order;
    }

    public int getProduct() {
        return product;
    }

    public void setProduct(int product) {
        this.product = product;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
