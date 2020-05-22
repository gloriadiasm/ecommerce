package com.unitri.comp.ecommerce.model.dao.impl;

import com.unitri.comp.ecommerce.model.dao.StockDao;
import com.unitri.comp.ecommerce.model.entity.Address;
import com.unitri.comp.ecommerce.model.entity.Stock;
import com.unitri.comp.ecommerce.model.factory.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StockDaoImpl implements StockDao {

    private final Connection connection =  new ConnectionFactory().getConnection();

    public StockDaoImpl() throws SQLException {
    }

    @Override
    public Stock findById(int id){

        Stock stock = null;

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select *from cart where id = "+id);

            while(resultSet.next()) {
                stock = new Stock(resultSet.getInt("id"),
                        resultSet.getInt("quantity"),
                        resultSet.getInt("product"));
            }
            statement.close();
            return stock;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return stock;
    }

    @Override
    public Stock create(Stock stock) {

        try {
            PreparedStatement statement = connection.prepareStatement("insert into stock values(?,?)");
            statement.setInt(1, stock.getId());
            statement.setInt(2, stock.getQuantity());
            statement.execute();
            statement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return stock;
    }

    @Override
    public Stock update(Stock address) throws SQLException {
        return null;
    }

    @Override
    public Address deleteById(int id) {

        try {
            PreparedStatement statement = connection.prepareStatement("delete from stock where id=?");
            statement.setInt(1, id);
            statement.execute();
            statement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Stock> findAll() {

        List<Stock> stock = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select *from Stock");
            while (resultSet.next()){
                Stock stock_ = new Stock(resultSet.getInt("id"), resultSet.getInt("product"), resultSet.getInt("quantity"));
                stock.add(stock_);
            }
            statement.close();
            return stock;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stock;
    }
}