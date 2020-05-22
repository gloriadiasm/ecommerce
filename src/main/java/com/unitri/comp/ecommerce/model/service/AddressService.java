package com.unitri.comp.ecommerce.model.service;

import com.unitri.comp.ecommerce.model.dao.impl.AddressDaoImpl;
import com.unitri.comp.ecommerce.model.entity.Address;

import java.sql.SQLException;
import java.util.List;

public class AddressService {
    AddressDaoImpl addressDao;

    public AddressService() throws SQLException {
        this.addressDao = new AddressDaoImpl();
    }

    public Address findById(int id) throws SQLException {
        return addressDao.findById(id);
    }
    public Address create(Address address) throws SQLException {
        return addressDao.create(address);
    }
    public Address deleteById(int id) throws SQLException {
        return addressDao.deleteById(id);
    }
    public List<Address> findAll() throws SQLException {
        return addressDao.findAll();
    }

}
