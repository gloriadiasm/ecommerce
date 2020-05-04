package com.unitri.comp.ecommerce.model.dao;

import com.unitri.comp.ecommerce.model.entity.CartItems;

import java.util.List;

public interface CartItemsDao {

    CartItems findById(Long id);
    void create(CartItems cartItems);
    CartItems update(CartItems cartItems);
    void deleteById(int id);
    List<CartItems> findAll();
}
