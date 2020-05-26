package com.unitri.comp.ecommerce.model.dao;

import com.unitri.comp.ecommerce.model.entity.Sold;

import java.sql.SQLException;
import java.util.List;

public interface SoldDao {
    Sold findById(int id) throws SQLException;
    Sold create(Sold sold) throws SQLException;
    Sold update(Sold sold) throws SQLException;
    void delete(Sold sold) throws SQLException;
    void deleteById(int id) throws SQLException;
    List<Sold> findAll() throws SQLException;
}
