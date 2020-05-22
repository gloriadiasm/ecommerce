package com.unitri.comp.ecommerce.model.service;

import com.unitri.comp.ecommerce.model.dao.SupplierDao;
import com.unitri.comp.ecommerce.model.dao.impl.SupplierDaoImpl;
import com.unitri.comp.ecommerce.model.entity.Supplier;

import java.sql.SQLException;
import java.util.List;

public class SupplierService {
    final SupplierDao supplierDao = new SupplierDaoImpl();

    public SupplierService() throws SQLException {}

    public Supplier findById(int id) throws SQLException {
        return supplierDao.findById(id);
    }

    public void create(Supplier supplier) throws SQLException {
        supplierDao.create(supplier);
    }

    public void deleteById(int id) throws SQLException {
        supplierDao.deleteById(id);
    }

    public List<Supplier> findAll() throws SQLException {
        return supplierDao.findAll();
    }
}
