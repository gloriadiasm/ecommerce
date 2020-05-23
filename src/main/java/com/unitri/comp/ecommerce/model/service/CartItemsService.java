package com.unitri.comp.ecommerce.model.service;

import com.unitri.comp.ecommerce.model.dao.CartItemsDao;
import com.unitri.comp.ecommerce.model.dao.impl.CartItemsDaoImpl;
import com.unitri.comp.ecommerce.model.entity.CartItems;

import java.sql.SQLException;
import java.util.List;

public class CartItemsService {

    final CartItemsDao cartItemsDao = new CartItemsDaoImpl();

    public CartItemsService() {
    }

    public CartItems findById(int id) {
        return cartItemsDao.findById(id);
    }

    public void create(CartItems cart) {
        cartItemsDao.create(cart);
    }

    public void deleteById(int id) throws SQLException {
        cartItemsDao.deleteById(id);
    }

    public List<CartItems> findAll() throws SQLException {
        return cartItemsDao.findAll();
    }
}
