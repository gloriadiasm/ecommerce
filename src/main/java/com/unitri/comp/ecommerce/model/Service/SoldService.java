package com.unitri.comp.ecommerce.model.Service;

import com.unitri.comp.ecommerce.model.dao.impl.SoldDaoImpl;
import com.unitri.comp.ecommerce.model.entity.Sold;

import java.sql.SQLException;
import java.util.List;

public class SoldService {

    SoldDaoImpl soldDao;

    public SoldService() throws SQLException {
        this.soldDao = new SoldDaoImpl();
    }
    public Sold findById(int id) throws SQLException {
        return soldDao.findById(id);
    }
    public Sold create(Sold sold) throws SQLException {
        return soldDao.create(sold);
    }
    public Sold update(Sold sold) throws SQLException {
        return soldDao.update(sold);
    }
    public void delete(Sold sold) throws SQLException {
        soldDao.delete(sold);
    }
    public void deleteById(int id) throws SQLException {
        soldDao.deleteById(id);
    }
    public List<Sold> findAll() throws SQLException {
        return soldDao.findAll();
    }
}
