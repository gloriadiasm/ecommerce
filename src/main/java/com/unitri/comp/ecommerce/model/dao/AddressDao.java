package com.unitri.comp.ecommerce.model.dao;

import com.unitri.comp.ecommerce.model.entity.Address;

import java.sql.SQLException;
import java.util.List;

public interface AddressDao {

    Address findById(Long id);
    void create(Address address);
    Address update(Address address);
    void deleteById(Long id);
    List<Address> findAll();
}
