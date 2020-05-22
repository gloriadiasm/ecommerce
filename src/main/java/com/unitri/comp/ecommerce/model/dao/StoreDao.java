package com.unitri.comp.ecommerce.model.dao;

import com.unitri.comp.ecommerce.model.entity.Store;

import java.sql.SQLException;
import java.util.List;

public interface StoreDao {
    Store findById(int id) throws SQLException;
    List<Store> findStore(String name) throws SQLException;
    Store create(Store store) throws SQLException;
    Store update(Store store) throws SQLException;
    void delete(Store store) throws SQLException;
    void deleteById(int id) throws SQLException;
    List<Store> findAll() throws SQLException;
}
