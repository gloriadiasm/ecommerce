package com.unitri.comp.ecommerce.model.dao.impl;

import com.unitri.comp.ecommerce.model.dao.AddressDao;
import com.unitri.comp.ecommerce.model.entity.Address;
import com.unitri.comp.ecommerce.model.factory.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AddressDaoImpl implements AddressDao {

    private final Connection connection;

    public AddressDaoImpl() {
        this.connection = new ConnectionFactory().getConnection();
    }

    @Override
    public Address findById(int id) {
        Address address = null;

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select *from address where id = "+id);
            while (resultSet.next()){
                address = new Address(resultSet.getInt("id"), resultSet.getString("street"),
                        resultSet.getString("district"), resultSet.getString("state"), resultSet.getString("city"),
                        resultSet.getInt("number"), resultSet.getString("zip_code"));
            }
            resultSet.close();
            return address;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return address;
    }

    @Override
    public Address create(Address address) {
        try {
            PreparedStatement statement = connection.prepareStatement("insert into address(street, district, state, city, number, zip_code) values(?,?,?,?,?,?)");
            statement.setString(1, address.getStreet());
            statement.setString(2, address.getDistrict());
            statement.setString(3, address.getState());
            statement.setString(4, address.getCity());
            statement.setInt(5, address.getNumber());
            statement.setString(6, address.getZip_code());
            statement.execute();
            statement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return address;
    }

    @Override
    public void deleteById(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement("delete from address where id=?");
            statement.setInt(1, id);
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
            ResultSet resultSet = statement.executeQuery("select *from address");
            while (resultSet.next()){
                Address address = new Address(resultSet.getInt("id"), resultSet.getString("street"),
                        resultSet.getString("district"), resultSet.getString("state"), resultSet.getString("city"),
                        resultSet.getInt("number"), resultSet.getString("zip_code"));
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
