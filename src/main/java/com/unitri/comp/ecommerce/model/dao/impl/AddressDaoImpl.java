package com.unitri.comp.ecommerce.model.dao.impl;

import com.unitri.comp.ecommerce.model.dao.AddressDao;
import com.unitri.comp.ecommerce.model.entity.Address;
import com.unitri.comp.ecommerce.model.factory.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AddressDaoImpl implements AddressDao {

    private final Connection connection =  new ConnectionFactory().getConnection();

    public AddressDaoImpl() {
    }

    @Override
    public Address findById(Long id) {

        Address address = null;

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from ecommerce.address where id = "+id);

            while (resultSet.next()){
                address = new Address(resultSet.getLong("id"),
                        resultSet.getString("street"),
                        resultSet.getString("district"),
                        resultSet.getString("state"),
                        resultSet.getString("city"),
                        resultSet.getInt("number"),
                        resultSet.getString("zipcode"));
            }
            statement.close();
            return address;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return address;
    }

    @Override
    public void create(Address address) {

        try {
            PreparedStatement statement = connection.prepareStatement("insert into address values(?,?,?)");
            statement.setLong(1, address.getId());
            statement.setString(2, address.getStreet());
            statement.setString(3, address.getDistrict());
            statement.setString(4, address.getState());
            statement.setString(5, address.getCity());
            statement.setInt(6, address.getNumber());
            statement.setString(7, address.getZipCode());

            statement.execute();
            statement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Address update(Address address) {
        return null;
    }

    @Override
    public void deleteById (Long id) {
        try {
            PreparedStatement statement = connection.prepareStatement("delete from address where id=?");
            statement.setLong(1, id);
            statement.execute();
            statement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Address> findAll() {
        List<Address> addresses = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String sql = "select *from ´address´";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                Address address = new Address(resultSet.getLong("id"),
                        resultSet.getString("street"),
                        resultSet.getString("district"),
                        resultSet.getString("state"),
                        resultSet.getString("city"),
                        resultSet.getInt("number"),
                        resultSet.getString("zipcode"));
                addresses.add(address);
            }
            statement.close();
            return addresses;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return addresses;
    }
}
