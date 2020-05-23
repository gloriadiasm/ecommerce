package com.unitri.comp.ecommerce.model.service;

import com.unitri.comp.ecommerce.model.dao.impl.SoldDaoImpl;
import com.unitri.comp.ecommerce.model.entity.Sold;

import java.sql.SQLException;
import java.util.List;

public class SoldService {

    final SoldDaoImpl soldDao;

    public SoldService() {
        this.soldDao = new SoldDaoImpl();
    }
    public Sold findById(int id) {
        return soldDao.findById(id);
    }
    public Sold create(Sold sold) {
        return soldDao.create(sold);
    }
    public Sold update(Sold sold) {
        return soldDao.update(sold);
    }
    public void deleteById(int id) throws SQLException {
        soldDao.deleteById(id);
    }
    public List<Sold> findAll() throws SQLException {
        return soldDao.findAll();
    }
}
