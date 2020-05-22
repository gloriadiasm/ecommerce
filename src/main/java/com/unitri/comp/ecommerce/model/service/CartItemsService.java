package com.unitri.comp.ecommerce.model.service;

import com.unitri.comp.ecommerce.model.dao.CartItemsDao;
import com.unitri.comp.ecommerce.model.dao.impl.CartItemsDaoImpl;
import com.unitri.comp.ecommerce.model.entity.CartItems;

import java.sql.SQLException;
import java.util.List;

public class CartItemsService {

    final CartItemsDao cartItemsDao = new CartItemsDaoImpl();

    public CartItemsService() throws SQLException {
    }

    public CartItems findById(Long id) {
        return cartItemsDao.findById(id);
    }

    public void create(CartItems cart) {
        cartItemsDao.create(cart);
    }

    public void deleteById(int id) {
        cartItemsDao.deleteById(id);
    }

    public List<CartItems> findAll() {
        return cartItemsDao.findAll();
    }
}
