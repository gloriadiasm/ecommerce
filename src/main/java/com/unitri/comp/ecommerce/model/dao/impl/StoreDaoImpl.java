package com.unitri.comp.ecommerce.model.dao.impl;


import com.unitri.comp.ecommerce.model.dao.ConnectionFactory;
import com.unitri.comp.ecommerce.model.dao.StoreDao;
import com.unitri.comp.ecommerce.model.entity.Store;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StoreDaoImpl implements StoreDao {

    private final Connection connection;

    public StoreDaoImpl() throws SQLException {
        this.connection =  new ConnectionFactory().getConnection();
    }

    @Override
    public Store findById(int id) throws SQLException{

        Store store = null;


        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from store where id = "+id);

            store = new Store(resultSet.getInt("id"),
                              resultSet.getString("name"),
                              resultSet.getLong("cnpj"),
                              resultSet.getString("addresses"),
                              resultSet.getInt("sold_id"),
                              resultSet.getInt("stock_id"));

            statement.close();
            return store;
        }catch (SQLException e){
            e.printStackTrace();
        } finally {
            connection.close();
        }
        return store;
    }

    @Override
    public List<Store> findStore(String name) throws SQLException {
        Store store = null;
        List<Store> stores = new ArrayList<Store>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from store where name like '%"+name+"%';");

            while(resultSet.next()) {
                store = new Store(resultSet.getInt("id"),
                                  resultSet.getString("name"),
                                  resultSet.getLong("cnpj"),
                                  resultSet.getString("addresses"),
                                  resultSet.getInt("sold_id"),
                                  resultSet.getInt("stock_id"));

                stores.add(store);
            }

            statement.close();
            return stores;
        }catch (SQLException e){
            e.printStackTrace();

        } finally {
            connection.close();

        }
        return stores;

    }

    @Override
    public Store create(Store store) throws SQLException {

        try {
            int id = store.getId();
            String name = store.getName();
            Long cnpj = store.getCnpj();
            String adds = store.getAddresses();
            int sold = store.getSold_id();
            int stock = store.getStock_id();

            String sql = "insert into store(id, name, cnpj, addresses, sold_id, stock_id) "+
                    "values ("+id+",'"+name+"',"+cnpj+",'"+adds+"',"+sold+","+stock+");";

            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);

            statement.close();
            return null;

        } catch (SQLException e) {

            throw new RuntimeException(e);

        }finally {
            connection.close();
        }
    }


    @Override
    public Store update(Store store) throws SQLException {

        int id = store.getId();
        String name = store.getName();
        Long cnpj = store.getCnpj();
        String address = store.getAddresses();
        int sold_id = store.getSold_id();
        int stock = store.getStock_id();

        String sql ="update store set id_store ="+ id +
                    ", name='"+ name +"', cnpj="+ cnpj +
                    ", addresses='"+ address +
                    "', sold_id= "+ sold_id +",stock_id="+ stock +";";

        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            statement.close();
            return store;
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            this.connection.close();
            return null;

        }
    }

    @Override
    public void delete(Store store) throws SQLException {

        int id = store.getId();

        String sql = "delete from store where id_store = "+id;
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
    public void deleteById(int id) throws SQLException {
        String sql = "delete from store where id_store="+id;
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
    public List<Store> findAll() throws SQLException {

        try {
            List<Store> stores = new ArrayList<Store>();
            PreparedStatement statement = this.connection.prepareStatement("select * from store;");

            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()) {

                Store store = new Store(resultSet.getInt("id_store"),
                                        resultSet.getString("name"),
                                        resultSet.getLong("cnpj"),
                                        resultSet.getString("addresses"),
                                        resultSet.getInt("sold_id"),
                                        resultSet.getInt("stock_id"));

                stores.add(store);
            }

            resultSet.close();
            statement.close();

            return stores;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            this.connection.close();
        }

    }
}
