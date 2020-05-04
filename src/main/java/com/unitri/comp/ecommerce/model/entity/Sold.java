package com.unitri.comp.ecommerce.model.entity;

public class Sold {

    private Long id;
    private Long product_id;
    private int quantity;
    private double price;

    public Sold(long id, long product_id, int quantity, double price) {
        this.id = id;
        this.product_id = product_id;
        this.quantity = quantity;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
