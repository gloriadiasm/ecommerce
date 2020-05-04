package com.unitri.comp.ecommerce.model.entity;

import com.unitri.comp.ecommerce.model.enums.OrderStatusEnum;

public class Order {

    private int id;
    private int clientId;
    private OrderStatusEnum status;

    public Order(int id, int clientId, OrderStatusEnum status) {
        this.id = id;
        this.clientId = clientId;
        this.status = status;
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

    public OrderStatusEnum getStatus() {
        return status;
    }

    public void setStatus(OrderStatusEnum status) {
        this.status = status;
    }
}
