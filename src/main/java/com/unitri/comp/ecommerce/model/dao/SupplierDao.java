package com.unitri.comp.ecommerce.model.dao;

import com.unitri.comp.ecommerce.model.entity.Supplier;

import java.sql.SQLException;
import java.util.List;

public interface SupplierDao {
    Supplier findById(Long id) throws SQLException;
    void create(Supplier supplier) throws SQLException;
    void update(Supplier supplier) throws SQLException;
    void deleteByid(Long id) throws SQLException;
    List<Supplier> findAll() throws SQLException;
}
