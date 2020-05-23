package com.unitri.comp.ecommerce.model.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

public interface GenericDao <T,Type extends Serializable> {

    T findById(int id);
    T create(T address);
    void deleteById(int id) throws SQLException;
    List<T> findAll() throws SQLException;
}
