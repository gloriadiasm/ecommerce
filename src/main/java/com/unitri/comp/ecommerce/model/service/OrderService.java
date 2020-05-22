package com.unitri.comp.ecommerce.model.service;

import com.unitri.comp.ecommerce.model.dao.OrderDao;
import com.unitri.comp.ecommerce.model.dao.impl.OrderDaoImpl;
import com.unitri.comp.ecommerce.model.entity.Order;

import java.sql.SQLException;
import java.util.List;

public class OrderService {

    final OrderDao orderDao = new OrderDaoImpl();

    public OrderService() throws SQLException {
    }

    public Order findById(int id) throws SQLException {
        return orderDao.findById(id);
    }

    public void create(Order order) throws SQLException {
        orderDao.create(order);
    }

    public void deleteById(int id) throws SQLException {
        orderDao.deleteById(id);
    }

    public List<Order> findAll() throws SQLException {
        return orderDao.findAll();
    }
}
