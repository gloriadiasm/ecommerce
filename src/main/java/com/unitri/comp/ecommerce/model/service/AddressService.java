package com.unitri.comp.ecommerce.model.service;

import com.unitri.comp.ecommerce.model.dao.impl.AddressDaoImpl;
import com.unitri.comp.ecommerce.model.entity.Address;

import java.util.List;

public class AddressService {
    final AddressDaoImpl addressDao;

    public AddressService() {
        this.addressDao = new AddressDaoImpl();
    }

    public Address findById(int id) {
        return addressDao.findById(id);
    }
    public void create(Address address) {
        addressDao.create(address);
    }
    public void deleteById(int id) {
        addressDao.deleteById(id);
    }
    public List<Address> findAll() {
        return addressDao.findAll();
    }

}
