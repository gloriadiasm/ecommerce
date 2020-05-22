package com.unitri.comp.ecommerce.model.dao.impl;

import com.unitri.comp.ecommerce.model.dao.AddressDao;
import com.unitri.comp.ecommerce.model.entity.Address;
import com.unitri.comp.ecommerce.model.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class AddressDaoImpl implements AddressDao {

    private Connection connection;

    public AddressDaoImpl() throws SQLException {
        this.connection = new ConnectionFactory().getConnection();
    }

    @Override
    public Address findById(int id) throws SQLException{
        Address address = null;

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from ecommerce.address where id = "+id);
            while (resultSet.next()){
                address = new Address(resultSet.getInt("id"));
            }
            resultSet.close();
            return address;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            connection.close();
        }
        return address;
    }

    @Override
    public Address findAddress(Address address) {
        return null;
    }

    @Override
    public Address create(Address address) {
        return null;
    }

    @Override
    public Address update(Address address) {
        return null;
    }

    @Override
    public void delete(Address address) {

    }

    @Override
    public void deleteById() {

    }

    @Override
    public List<Address> findAll() {
        return null;
    }
}
