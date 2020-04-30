package com.unitri.comp.ecommerce.model.dao;

import com.unitri.comp.ecommerce.model.entity.Cart;

import java.sql.SQLException;
import java.util.List;

public interface CartDao{

    Cart findById(Long id) throws SQLException;
    Cart findCart(Cart cart) throws SQLException;
    Cart create(Cart cart) throws SQLException;
    Cart update(Cart cart) throws SQLException;
    void delete(Cart cart) throws SQLException;
    void deleteById() throws SQLException;
    List<Cart> findAll() throws SQLException;
}
