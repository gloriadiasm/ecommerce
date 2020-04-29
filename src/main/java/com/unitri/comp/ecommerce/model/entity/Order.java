package com.unitri.comp.ecommerce.model.entity;

import com.unitri.comp.ecommerce.model.enums.OrderStatusEnum;

public class Order {

    private Long id;
    private Long client_id;
    private OrderStatusEnum status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClient_id() {
        return client_id;
    }

    public void setClient_id(Long client_id) {
        this.client_id = client_id;
    }

    public OrderStatusEnum getStatus() {
        return status;
    }

    public void setStatus(OrderStatusEnum status) {
        this.status = status;
    }
}
