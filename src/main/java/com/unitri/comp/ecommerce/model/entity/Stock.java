package com.unitri.comp.ecommerce.model.entity;

public class Stock {
    public Long id;
    public Long productId;
    public int quantity;

    public Stock(Long id, Long productId, int quantity) {
        this.id = id;
        this.productId = productId;
        this.quantity = quantity;
    }
    public Stock(int id, int quantity, int product_id) {
    }

    public Stock(int quantity, int product_id) {
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Long getProduct_id() {
        return productId;
    }

    public void setProduct_id(Long product_id) {
        this.productId = product_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void getProductId() {
    }

    public static void getInt(String id) {
    }

    public void add(Stock stock) {
    }
}
