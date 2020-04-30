package com.unitri.comp.ecommerce.model.entity;

public class Cart {

    private Long id;
    private Long clientId;

    public Cart(Long id, Long clientId) {
        this.id = id;
        this.clientId = clientId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

}
