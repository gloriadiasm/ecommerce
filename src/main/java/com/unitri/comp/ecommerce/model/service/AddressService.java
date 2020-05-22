package com.unitri.comp.ecommerce.model.service;

import com.unitri.comp.ecommerce.model.dao.impl.AddressDaoImpl;
import com.unitri.comp.ecommerce.model.entity.Address;

import java.sql.SQLException;

public class AddressService {
    AddressDaoImpl addressDao;

    public AddressService() throws SQLException {
        this.addressDao = new AddressDaoImpl();
    }

    public Address findById(int id) throws SQLException {
        return addressDao.findById(id);
    }
}
