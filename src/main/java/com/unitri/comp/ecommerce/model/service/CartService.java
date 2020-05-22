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

    public Cart findById(Long id) {
        return cartDao.findById(id);
    }

    public Cart findByClientId(Cart cart) {
        return cartDao.findByClientId(cart);
    }

    public void create(Cart cart) {
        cartDao.create(cart);
    }

    public void deleteById(int id) {
        cartDao.deleteById(id);
    }

    public List<Cart> findAll() {
        return cartDao.findAll();
    }
}
