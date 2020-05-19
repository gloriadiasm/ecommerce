package com.unitri.comp.ecommerce.model.dao;

import java.util.List;

public interface CategoryDao {

    CartItems findById(Long id);
    void create(CartItems cartItems);
    CartItems update(CartItems cartItems);
    void deleteById(int id);
    List<CartItems> findAll();
}
