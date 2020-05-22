package com.unitri.comp.ecommerce.model.service;

import com.unitri.comp.ecommerce.model.dao.CartDao;
import com.unitri.comp.ecommerce.model.dao.impl.CartDaoImpl;
import com.unitri.comp.ecommerce.model.entity.Cart;

import java.sql.SQLException;
import java.util.List;

public class CartService{

    final CartDao cartDao = new CartDaoImpl();

    public CartService() throws SQLException {
    }

    public Cart findById(int id) throws SQLException {
        return cartDao.findById(id);
    }

    public void create(Cart cart) throws SQLException {
        cartDao.create(cart);
    }

    public void deleteById(int id) throws SQLException {
        cartDao.deleteById(id);
    }

    public List<Cart> findAll() throws SQLException {
        return cartDao.findAll();
    }
}
