package com.unitri.comp.ecommerce.model.Service;

import com.unitri.comp.ecommerce.model.dao.impl.StoreDaoImpl;
import com.unitri.comp.ecommerce.model.entity.Store;

import java.sql.SQLException;

public class StoreService {

    StoreDaoImpl storeDAO;

    StoreService() throws SQLException {
        this.storeDAO = new StoreDaoImpl();
    }
    public Store findById(Long id) throws SQLException {
        return storeDAO.findById(id);
    }
}
