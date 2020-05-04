package com.unitri.comp.ecommerce.model.entity;

public class Cart {

    private int id;
    private int clientId;

    public Cart(int id, int clientId) {
        this.id = id;
        this.clientId = clientId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

}
