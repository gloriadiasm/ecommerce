package com.unitri.comp.ecommerce.model.dao.impl;

import com.unitri.comp.ecommerce.model.dao.SupplierDao;
import com.unitri.comp.ecommerce.model.entity.Supplier;
import com.unitri.comp.ecommerce.model.factory.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SupplierDaoImpl implements SupplierDao {
    private final Connection connection = new ConnectionFactory().getConnection();

    public SupplierDaoImpl() {}

    @Override
    public Supplier findById(int id) {
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
       }
       return supplier;
    }

    @Override
    public Supplier create(Supplier supplier) {
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
    public void update(Supplier supplier) {
        String sql = "update supplier set name=?, address=? where id=?";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, supplier.getName());
            statement.setLong(2, supplier.getAddress());
            statement.setLong(3, supplier.getId());

            statement.execute();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement("delete from supplier where id=?");
            statement.setLong(1, id);
            statement.execute();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Supplier> findAll() {
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
