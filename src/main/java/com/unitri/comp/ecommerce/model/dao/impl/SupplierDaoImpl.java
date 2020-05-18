package com.unitri.comp.ecommerce.model.dao.impl;

import com.unitri.comp.ecommerce.model.dao.ConnectionFactory;
import com.unitri.comp.ecommerce.model.dao.SupplierDao;
import com.unitri.comp.ecommerce.model.entity.Supplier;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SupplierDaoImpl implements SupplierDao {
    private final Connection connection = new ConnectionFactory().getConnection();

    public SupplierDaoImpl() throws SQLException{}

    @Override
    public Supplier findById(Long id) throws SQLException {
       Supplier supplier = null;
       try {
           Statement statement = connection.createStatement();
           ResultSet resultSet = statement.executeQuery("select * from ecommerce.supplier where id="+id);
           while(resultSet.next()) {
               supplier = new Supplier(resultSet.getLong("id"),
                                       resultSet.getString("name"),
                                       resultSet.getLong("address_id"));
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
    public void create(Supplier supplier) throws SQLException {
        try {
            PreparedStatement statement = connection.prepareStatement("insert into supplier values (?, ?, ?)");
            statement.setLong(1, supplier.getId());
            statement.setString(2, supplier.getName());
            statement.setLong(3, supplier.getAddress());
            statement.execute();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteByid(Long id) throws SQLException {
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
    public List<Supplier> findAll() throws SQLException {
        List<Supplier> suppliers = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String sql = "select * from `supplier`";
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()) {
                Supplier supplier = new Supplier(resultSet.getLong("id"),
                                                 resultSet.getString("name"),
                                                 resultSet.getLong("address_id"));
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
