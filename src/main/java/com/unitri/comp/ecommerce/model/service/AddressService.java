package com.unitri.comp.ecommerce.model.service;

import com.unitri.comp.ecommerce.model.dao.AddressDao;
import com.unitri.comp.ecommerce.model.dao.impl.AddressDaoImpl;
import com.unitri.comp.ecommerce.model.entity.Address;

import java.util.List;

public class AddressService {
    final AddressDao addressDao = new AddressDaoImpl();

    public AddressService() {

    }

    public Address findById(Long id){
        return addressDao.findById(id);
    }

    public void create (Address address){
        addressDao.create(address);
    }

    public void deleteById (Long id){
        addressDao.deleteById(id);
    }

    public List<Address> findAll() {
        return addressDao.findAll();
    }
}
