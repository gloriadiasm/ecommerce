package com.unitri.comp.ecommerce.model.entity;

public class CartItems {

    private int id;
    private int cart_id;
    private int product_id;
    private Long totalPrice;
    private int quantity;

    public CartItems(int id, int cart_id, int product_id, Long totalPrice, int quantity) {
        this.id = id;
        this.cart_id = cart_id;
        this.product_id = product_id;
        this.totalPrice = totalPrice;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCart_id() {
        return cart_id;
    }

    public void setCart_id(int cart_id) {
        this.cart_id = cart_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public Long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
