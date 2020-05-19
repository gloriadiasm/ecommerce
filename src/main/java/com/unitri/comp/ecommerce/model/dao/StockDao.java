package com.unitri.comp.ecommerce.model.dao;

import java.util.List;

public interface StockDao {

    Cart findById(Long id);
    Cart findByClientId(Cart cart);
    void create(Cart cart);
    void deleteById(int id);
    List<Cart> findAll();
}
