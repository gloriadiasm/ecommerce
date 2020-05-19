package com.unitri.comp.ecommerce.model.dao;

import java.util.List;

public interface OrderDao {

    Order findById(Long id);
    void create(Order order);
    Order update(Order order);
    void deleteById(int id);
    List<Order> findAll();
}
