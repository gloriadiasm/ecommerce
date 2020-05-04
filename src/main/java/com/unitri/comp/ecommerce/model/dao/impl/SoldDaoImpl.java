package com.unitri.comp.ecommerce.model.dao.impl;

import com.unitri.comp.ecommerce.model.dao.ConnectionFactory;
import com.unitri.comp.ecommerce.model.dao.SoldDao;
import com.unitri.comp.ecommerce.model.entity.Sold;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class SoldDaoImpl implements SoldDao {

    private final Connection connection;

    public SoldDaoImpl() throws SQLException {
        this.connection =  new ConnectionFactory().getConnection();
    }

    @Override
    public Sold findById(Long id) throws SQLException {

        Sold sold = null;

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from Store where id = "+id);
            while(resultSet.next()) {
                sold = new Sold(resultSet.getLong("id"),
                                resultSet.getLong("product_id"),
                                resultSet.getInt("quantity"),
                                resultSet.getDouble("price"));
            }
            resultSet.close();
            return sold;
        }catch (SQLException e){
            e.printStackTrace();
        } finally {
            connection.close();
        }
        return sold;
    }

    @Override
    public Sold findStore(Sold sold) throws SQLException {
        return null;
    }

    @Override
    public Sold create(Sold sold) throws SQLException {
        return null;
    }

    @Override
    public Sold update(Sold sold) throws SQLException {
        return null;
    }

    @Override
    public void delete(Sold sold) throws SQLException {

    }

    @Override
    public void deleteById() throws SQLException {

    }

    @Override
    public List<Sold> findAll() throws SQLException {
        return null;
    }
}
