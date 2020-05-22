package com.unitri.comp.ecommerce.model.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

public interface GenericDao <T,Type extends Serializable> {

    T findById(int id) throws SQLException;
    T create(T address) throws SQLException;
    T update(T address) throws SQLException;
    void delete(T address) throws SQLException;
    void deleteById() throws SQLException;
    List<T> findAll() throws SQLException;
}
