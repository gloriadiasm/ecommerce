package com.unitri.comp.ecommerce.model.dao;

import com.unitri.comp.ecommerce.model.entity.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductDao {
    Product findById(Long id) throws SQLException;
    void create(Product product) throws SQLException;
    void deleteById(Long id) throws SQLException;
    List<Product> findAll() throws SQLException;
}
