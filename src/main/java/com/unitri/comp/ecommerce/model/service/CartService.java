package com.unitri.comp.ecommerce.model.service;

import com.unitri.comp.ecommerce.model.dao.impl.CartDaoImpl;
import com.unitri.comp.ecommerce.model.entity.Cart;

import java.sql.SQLException;

public class CartService{

    CartDaoImpl cartDao;

    void CartService() throws SQLException {
        this.cartDao = new CartDaoImpl();
    }

    public Cart findById(Long id) throws SQLException {
        return cartDao.findById(id);
    }
}
