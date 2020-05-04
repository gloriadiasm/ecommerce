package com.unitri.comp.ecommerce.model.dao.impl;


import com.unitri.comp.ecommerce.model.dao.ConnectionFactory;
import com.unitri.comp.ecommerce.model.dao.StoreDao;
import com.unitri.comp.ecommerce.model.entity.Store;

import java.sql.*;
import java.util.List;

public class StoreDaoImpl implements StoreDao {

    private final Connection connection;

    public StoreDaoImpl() throws SQLException {
        this.connection =  new ConnectionFactory().getConnection();
    }

    @Override
    public Store findById(Long id) throws SQLException{

        Store store = null;

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from Store where id = "+id);
            while(resultSet.next()) {
                store = new Store(resultSet.getLong("id"),
                                  resultSet.getString("name"),
                                  resultSet.getLong("cnpj"),
                                  resultSet.getString("addresses"),
                                  resultSet.getLong("sold_id"),
                                  resultSet.getLong("stock_id"));
            }
            resultSet.close();
            return store;
        }catch (SQLException e){
            e.printStackTrace();
        } finally {
            connection.close();
        }
        return store;
    }

    @Override
    public Store findStore(Store store) {
        return null;
    }

    @Override
    public Store create(Store store) throws SQLException {

        try {
            Long id = store.getId();
            String name = store.getName();
            Long cnpj = store.getCnpj();
            String adds = store.getAddresses();
            Long sold = store.getSold_id();
            Long stock = store.getStock_id();

            String sql = "insert into store (id, name, cnpj, addresses, sold_id, stock_id) "+
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
    public Store update(Store store) {
        return null;
    }

    @Override
    public void delete(Store store) {

    }

    @Override
    public void deleteById() {

    }

    @Override
    public List<Store> findAll() {
        return null;
    }
}
