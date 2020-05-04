package com.unitri.comp.ecommerce.model.service;

import com.unitri.comp.ecommerce.model.dao.OrderDao;
import com.unitri.comp.ecommerce.model.dao.impl.OrderDaoImpl;
import com.unitri.comp.ecommerce.model.entity.Order;

import java.util.List;

public class OrderService {

    final OrderDao orderDao = new OrderDaoImpl();

    public OrderService() {
    }

    public Order findById(Long id) {
        return orderDao.findById(id);
    }

    public void create(Order order) {
        orderDao.create(order);
    }

    public void deleteById(int id) {
        orderDao.deleteById(id);
    }

    public List<Order> findAll() {
        return orderDao.findAll();
    }
}
