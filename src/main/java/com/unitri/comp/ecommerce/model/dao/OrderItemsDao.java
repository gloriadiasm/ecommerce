package com.unitri.comp.ecommerce.model.dao;

import com.unitri.comp.ecommerce.model.entity.OrderItems;

import java.util.List;

public interface OrderItemsDao {
    OrderItems findById(Long id);
    OrderItems create(OrderItems orderItems);
    OrderItems update(OrderItems orderItems);
    void deleteById(int id);
    List<OrderItems> findAll();
}
