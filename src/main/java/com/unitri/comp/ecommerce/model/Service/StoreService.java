package com.unitri.comp.ecommerce.model.service;

import com.unitri.comp.ecommerce.model.dao.impl.StoreDaoImpl;
import com.unitri.comp.ecommerce.model.entity.Store;

import java.util.List;

public class StoreService {

    final StoreDaoImpl storeDAO;

    public StoreService() {
        this.storeDAO = new StoreDaoImpl();
    }
    public Store findById(int id) {
        return storeDAO.findById(id);
    }
    public Store create(Store store) {
        return storeDAO.create(store);
    }
    public Store update(Store store) {
        return storeDAO.update(store);
    }
    public void deleteById(int id) {
        storeDAO.deleteById(id);
    }
    public List<Store> findAll() {
        return storeDAO.findAll();
    }
}
