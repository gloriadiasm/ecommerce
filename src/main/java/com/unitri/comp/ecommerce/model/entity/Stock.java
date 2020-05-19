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
    public Stock() {
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
}
