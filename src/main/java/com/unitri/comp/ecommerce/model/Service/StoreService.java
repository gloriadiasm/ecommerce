package com.unitri.comp.ecommerce.model.service;

import com.unitri.comp.ecommerce.model.dao.impl.StoreDaoImpl;
import com.unitri.comp.ecommerce.model.entity.Store;

import java.sql.SQLException;
import java.util.List;

public class StoreService {

    StoreDaoImpl storeDAO;

    public StoreService() throws SQLException {
        this.storeDAO = new StoreDaoImpl();
    }
    public Store findById(int id) throws SQLException {
        return storeDAO.findById(id);
    }
    public Store create(Store store) throws SQLException {
        return storeDAO.create(store);
    }
    public Store update(Store store) throws SQLException {
        return storeDAO.update(store);
    }
    public void deleteById(int id) throws SQLException {
        storeDAO.deleteById(id);
    }
    public List<Store> findAll() throws SQLException {
        return storeDAO.findAll();
    }
}
