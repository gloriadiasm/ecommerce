package com.unitri.comp.ecommerce.model.service;

import com.unitri.comp.ecommerce.model.dao.SupplierDao;
import com.unitri.comp.ecommerce.model.dao.impl.SupplierDaoImpl;
import com.unitri.comp.ecommerce.model.entity.Supplier;

import java.sql.SQLException;
import java.util.List;

public class SupplierService {
    final SupplierDao supplierDao = new SupplierDaoImpl();

    public SupplierService() {}

    public Supplier findById(int id) {
        return supplierDao.findById(id);
    }

    public void create(Supplier supplier) {
        supplierDao.create(supplier);
    }

    public void deleteById(int id) throws SQLException {
        supplierDao.deleteById(id);
    }

    public List<Supplier> findAll() throws SQLException {
        return supplierDao.findAll();
    }
    public void update(Supplier supplier) {

        supplierDao.update(supplier);
    }
}
