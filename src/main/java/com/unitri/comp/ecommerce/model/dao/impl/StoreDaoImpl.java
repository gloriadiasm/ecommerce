package com.unitri.comp.ecommerce.model.dao.impl;

import com.unitri.comp.ecommerce.model.dao.StoreDao;
import com.unitri.comp.ecommerce.model.entity.Store;
import com.unitri.comp.ecommerce.model.factory.ConnectionFactory;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StoreDaoImpl implements StoreDao {

    private final Connection connection;

    public StoreDaoImpl() {
        this.connection =  new ConnectionFactory().getConnection();
    }

    @Override
    public Store findById(int id) {

        Store store = null;


        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from store where id = "+id);

            store = new Store(resultSet.getInt("id"),
                              resultSet.getString("name"),
                              resultSet.getInt("cnpj"),
                              resultSet.getInt("address"));

            statement.close();
            return store;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return store;
    }

    @Override
    public Store create(Store store) {

        try {
            int id = store.getId();
            String name = store.getName();
            int cnpj = store.getCnpj();
            int adds = store.getAddress();

            String sql = "insert into store(id, name, cnpj, address) "+
                    "values ("+id+",'"+name+"',"+cnpj+",'"+adds+")";

            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);

            statement.close();
            return null;

        } catch (SQLException e) {

            throw new RuntimeException(e);

        }
    }


    @Override
    public Store update(Store store) {

        int id = store.getId();
        String name = store.getName();
        int cnpj = store.getCnpj();
        int address = store.getAddress();

        String sql ="update store set id_store ="+ id +
                    ", name='"+ name +"', cnpj="+ cnpj +
                    ", addresses='"+ address +
                    "' +";

        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            statement.close();
            return store;
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "delete from store where id_store="+id;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);


            statement.close();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Store> findAll() {

        try {
            List<Store> stores = new ArrayList<>();
            PreparedStatement statement = this.connection.prepareStatement("select * from store;");

            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()) {

                Store store = new Store(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("cnpj"),
                        resultSet.getInt("address"));

                stores.add(store);
            }

            resultSet.close();
            statement.close();

            return stores;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
