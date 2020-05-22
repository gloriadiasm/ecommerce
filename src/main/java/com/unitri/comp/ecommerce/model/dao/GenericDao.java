package com.unitri.comp.ecommerce.model.dao;

import com.unitri.comp.ecommerce.model.entity.Address;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

public interface GenericDao <T,Type extends Serializable> {

    T findById(int id) throws SQLException;
    T create(T address) throws SQLException;
    T update(T address) throws SQLException;
    Address deleteById(int id) throws SQLException;
    List<T> findAll() throws SQLException;
}
