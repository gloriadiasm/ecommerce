package com.unitri.comp.ecommerce.model.dao.impl;

import com.unitri.comp.ecommerce.model.dao.StockDao;
import com.unitri.comp.ecommerce.model.factory.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StockDaoImpl implements StockDao {

    private final Connection connection =  new ConnectionFactory().getConnection();

    public StockDaoImpl() {
    }

    @Override
    public Stock findById(Long id){

        Stock stock = null;

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select *from cart where id = "+id);

            while(resultSet.next()) {
                stock = new Stock(resultSet.getInt("id"),
                        resultSet.getInt("quantity"),
                        resultSet.getInt("product_id"));
            }
            statement.close();
           return stock;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return stock;
    }

    @Override
    public Stock findByClientId(Stock stock) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select *from stock where product_id = "+stock.getProductId());
            while(resultSet.next()) {
                stock = new Stock(resultSet.getInt("id"),
                        resultSet.getInt("quantity"),
                        resultSet.getInt("product_id"));
            }
            statement.close();
            return stock;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return stock;
    }

    @Override
    public void create(Stock stock) {

        try {
            PreparedStatement statement = connection.prepareStatement("insert into stock values(?,?)");
            statement.setInt(1, stock.getId());
            statement.setInt(2, stock.getQuabtity());
            statement.setInt(3, stock.getProductId());
            statement.execute();
            statement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(int id) {

        try {
            PreparedStatement statement = connection.prepareStatement("delete from stock where id=?");
            statement.setInt(1, id);
            statement.execute();
            statement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<stock> findAll() {

        List<Stock> stocks = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select *from Stock");
            while (resultSet.next()){
                Stock stock = new Stock(resultSet.getInt("id"), resultSet.getInt("product_id"));
                 stock.add(stock);
            }
            statement.close();
            return stocks;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stocks;
    }
}
