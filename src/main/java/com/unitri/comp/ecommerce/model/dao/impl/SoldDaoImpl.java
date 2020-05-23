package com.unitri.comp.ecommerce.model.dao.impl;

import com.unitri.comp.ecommerce.model.dao.SoldDao;
import com.unitri.comp.ecommerce.model.entity.Sold;
import com.unitri.comp.ecommerce.model.factory.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SoldDaoImpl implements SoldDao {

    private final Connection connection;

    public SoldDaoImpl() {
        this.connection =  new ConnectionFactory().getConnection();
    }

    @Override
    public Sold findById(int id) {

        Sold sold = null;

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from sold where id = "+id);
            while(resultSet.next()) {
                sold = new Sold(resultSet.getInt("id"),
                                resultSet.getInt("product"),
                                resultSet.getInt("quantity"));
            }
            resultSet.close();
            return sold;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return sold;
    }

    @Override
    public Sold create(Sold sold) {
        try {
            int id = sold.getId();
            int product_id = sold.getProduct();
            int quantity = sold.getQuantity();

            String sql = "insert into sold(id, product, quantity) "+
                    "values ("+id+","+product_id+","+quantity+","+")";

            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);

            statement.close();
            return null;

        } catch (SQLException e) {

            throw new RuntimeException(e);

        }
    }

    @Override
    public Sold update(Sold sold) {
        int id = sold.getId();
        int product= sold.getProduct();
        int quantity = sold.getQuantity();

        String sql ="update sold set id ="+ id +
                ", product ="+ product +
                ", quantity="+ quantity;

        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            statement.close();
            return sold;
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void deleteById(int id) throws SQLException {
        String sql = "delete from sold where id="+id;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            statement.close();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            this.connection.close();
        }

    }

    @Override
    public List<Sold> findAll() throws SQLException {
        try {
            List<Sold> sold = new ArrayList<>();
            PreparedStatement statement = this.connection.prepareStatement("select * from sold");

            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()) {

                Sold sold_ = new Sold(resultSet.getInt("id"),
                                     resultSet.getInt("product"),
                                     resultSet.getInt("quantity"));

                sold.add(sold_);
            }

            resultSet.close();
            statement.close();

            return sold;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            this.connection.close();
        }

    }
}
