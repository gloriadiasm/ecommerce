package com.unitri.comp.ecommerce.model.dao;

import com.unitri.comp.ecommerce.model.entity.Cart;

import java.util.List;

public interface CartDao{

    Cart findById(Long id);
    Cart findByClientId(Cart cart);
    void create(Cart cart);
    void deleteById(int id);
    List<Cart> findAll();
}
