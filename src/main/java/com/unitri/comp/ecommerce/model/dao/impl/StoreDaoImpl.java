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
    public Store findById(int id) throws SQLException {

        Store store = null;
        String sql = "select * from store where id_store =?";

        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();
            rs.next();

            store = new Store(rs.getInt("id_store"),
                    rs.getString("name"),
                    rs.getLong("cnpj"),
                    rs.getString("addresses"),
                    rs.getInt("sold_id"),
                    rs.getInt("stock_id"));

            rs.close();
            stmt.close();
            return store;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public List<Store> findStore(String name) throws SQLException {
        String sql = "select * from store where name like '%"+name+"%'";
        Store store = null;
        List<Store> stores = new ArrayList<Store>();

        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);

            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                store = new Store(resultSet.getInt("id_store"),
                        resultSet.getString("name"),
                        resultSet.getLong("cnpj"),
                        resultSet.getString("addresses"),
                        resultSet.getInt("sold_id"),
                        resultSet.getInt("stock_id"));

                stores.add(store);
            }
            stmt.close();
            resultSet.close();
            return stores;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;

        }
    }

    @Override
    public Store create(Store store) throws SQLException {

        String sql = "insert into store( name, cnpj, addresses, sold_id, stock_id) " +
        "values (?,?,?,?,?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, store.getName());
            stmt.setLong(2, store.getCnpj());
            stmt.setString(3, store.getAddresses());
            stmt.setInt(4, store.getSold_id());
            stmt.setInt(5, store.getStock_id());

            stmt.execute();
            stmt.close();

            return null;

        } catch (SQLException e) {

            throw new RuntimeException(e);

        }
    }


    @Override
    public Store update(Store store) throws SQLException {

        String sql = "update store set name=?,cnpj=?,addresses=?,sold_id=?,stock_id=? where id_store =?";


        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);

            stmt.setString(1, store.getName());
            stmt.setLong(2, store.getCnpj());
            stmt.setString(3, store.getAddresses());
            stmt.setInt(4, store.getSold_id());
            stmt.setInt(5, store.getStock_id());
            stmt.setInt(6, store.getId());

            stmt.execute();
            stmt.close();

            return store;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Store store) throws SQLException {

        String sql = "delete from store where id_store = ?";

        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);

            stmt.setLong(1, store.getId());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    @Override
    public void deleteById(int id) throws SQLException {

        String sql = "delete from store where id_store = ?";

        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);

            stmt.setLong(1, id);

            stmt.execute();
            stmt.close();
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }

    }

    @Override
    public List<Store> findAll() throws SQLException {

        try {
            List<Store> stores = new ArrayList<Store>();
            String sql = "select * from store;";

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);


            while (resultSet.next()) {

                Store store = new Store(resultSet.getInt("id_store"),
                        resultSet.getString("name"),
                        resultSet.getLong("cnpj"),
                        resultSet.getString("addresses"),
                        resultSet.getInt("sold_id"),
                        resultSet.getInt("stock_id"));

                stores.add(store);
            }

            statement.close();

            return stores;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
