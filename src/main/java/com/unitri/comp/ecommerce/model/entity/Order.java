package com.unitri.comp.ecommerce.model.entity;

import com.unitri.comp.ecommerce.model.enums.OrderStatusEnum;

public class Order {

    private int id;
    private int client;
    private OrderStatusEnum status;

    public Order(int id, int client, OrderStatusEnum status) {
        this.id = id;
        this.client = client;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClient() {
        return client;
    }

    public void setClient(int client) {
        this.client = client;
    }

    public OrderStatusEnum getStatus() {
        return status;
    }

    public void setStatus(OrderStatusEnum status) {
        this.status = status;
    }
}
