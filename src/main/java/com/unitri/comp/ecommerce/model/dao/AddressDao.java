package com.unitri.comp.ecommerce.model.dao;

import com.unitri.comp.ecommerce.model.entity.Address;

import java.sql.SQLException;
import java.util.List;

public interface AddressDao {

    Address findById(int id) throws SQLException;
    Address findAddress(Address address) throws SQLException;
    Address create(Address address) throws SQLException;
    Address update(Address address) throws SQLException;
    void delete(Address address) throws SQLException;
    void deleteById() throws SQLException;
    List<Address> findAll() throws SQLException;
}
