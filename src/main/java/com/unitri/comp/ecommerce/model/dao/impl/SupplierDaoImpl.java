package com.unitri.comp.ecommerce.model.dao.impl;

import com.unitri.comp.ecommerce.model.dao.SupplierDao;
import com.unitri.comp.ecommerce.model.entity.Address;
import com.unitri.comp.ecommerce.model.entity.Supplier;
import com.unitri.comp.ecommerce.model.factory.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SupplierDaoImpl implements SupplierDao {
    private final Connection connection = new ConnectionFactory().getConnection();

    public SupplierDaoImpl() throws SQLException{}

    @Override
    public Supplier findById(int id) throws SQLException {
       Supplier supplier = null;
       try {
           Statement statement = connection.createStatement();
           ResultSet resultSet = statement.executeQuery("select *from supplier where id="+id);
           while(resultSet.next()) {
               supplier = new Supplier(resultSet.getInt("id"),
                                       resultSet.getString("name"),
                                       resultSet.getInt("address"));
           }
           resultSet.close();
           return supplier;
       } catch (SQLException e) {
           e.printStackTrace();
       } finally {
           connection.close();
       }
       return supplier;
    }

    @Override
    public Supplier create(Supplier supplier) throws SQLException {
        try {
            PreparedStatement statement = connection.prepareStatement("insert into supplier values (?, ?, ?)");
            statement.setInt(1, supplier.getId());
            statement.setString(2, supplier.getName());
            statement.setInt(3, supplier.getAddress());
            statement.execute();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return supplier;
    }

    @Override
    public Supplier update(Supplier address) throws SQLException {
        return null;
    }

    @Override
    public Address deleteById(int id) throws SQLException {
        try {
            PreparedStatement statement = connection.prepareStatement("delete from supplier where id=?");
            statement.setLong(1, id);
            statement.execute();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Supplier> findAll() throws SQLException {
        List<Supplier> suppliers = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String sql = "select * from supplier";
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()) {
                Supplier supplier = new Supplier(resultSet.getInt("id"),
                                                 resultSet.getString("name"),
                                                 resultSet.getInt("address"));
                suppliers.add(supplier);
            }
            statement.close();
            return suppliers;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return suppliers;
    }
}
