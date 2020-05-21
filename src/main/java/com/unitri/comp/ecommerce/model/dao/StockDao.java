package com.unitri.comp.ecommerce.model.dao;

import com.unitri.comp.ecommerce.model.entity.Stock;

import java.util.List;

public interface StockDao {


    Stock findById(Long id);

    Stock findByClientId(Stock stock);

    void create(Stock stock);

    static void deleteById(int id) {
    }


    static List<Stock> findAll() {
        return null;
    }

}
