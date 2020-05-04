package com.unitri.comp.ecommerce.model.dao;

import com.unitri.comp.ecommerce.model.entity.Store;

import java.sql.SQLException;
import java.util.List;

public interface StoreDao {
    Store findById(Long id) throws SQLException;
    Store findStore(Store store) throws SQLException;
    Store create(Store store) throws SQLException;
    Store update(Store store) throws SQLException;
    void delete(Store store) throws SQLException;
    void deleteById() throws SQLException;
    List<Store> findAll() throws SQLException;
}
