package com.unitri.comp.ecommerce.model.dao.impl;

import com.unitri.comp.ecommerce.model.dao.ClientDao;
import com.unitri.comp.ecommerce.model.entity.Client;
import com.unitri.comp.ecommerce.model.factory.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientDaoImpl implements ClientDao {

    private final Connection connection =  new ConnectionFactory().getConnection();

    public ClientDaoImpl(){

    }

    @Override
    public Client findById(Long id) {
        Client client = null;

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from ecommerce.address where id = "+id);

            while (resultSet.next()){
                client = new Client(resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("phone_number"),
                        resultSet.getString("email"),
                        resultSet.getLong("address_id"),
                        resultSet.getDouble("shipping_cost"),
                        resultSet.getLong("cart_id"),
                        resultSet.getLong("orders_id"));
            }
            statement.close();
            return client;

        }catch (SQLException e){
            e.printStackTrace();
        }
        return client;
    }

    @Override
    public void create(Client client) {
        try {
            PreparedStatement statement = connection.prepareStatement("insert into client values(?,?,?)");
            statement.setLong(1, client.getId());
            statement.setString(2, client.getName());
            statement.setString(3, client.getPhoneNumber());
            statement.setString(4, client.getEmail());
            statement.setLong(5, client.getAddressId());
            statement.setDouble(6, client.getShippingCost());
            statement.setLong(7, client.getCartId());
            statement.setLong(8, client.getOrdersId());

            statement.execute();
            statement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Client update(Client client) {
        return null;
    }


    @Override
    public void deleteById (Long id) {
        try {
            PreparedStatement statement = connection.prepareStatement("delete from client where id=?");
            statement.setLong(1, id);
            statement.execute();
            statement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Client> findAll() {
        List<Client> clients = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            String sql = "select *from ´address´";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                Client client = new Client(resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("phone_number"),
                        resultSet.getString("email"),
                        resultSet.getLong("address_id"),
                        resultSet.getDouble("shipping_cost"),
                        resultSet.getLong("cart_id"),
                        resultSet.getLong("orders_id"));
                clients.add(client);
            }
            statement.close();

            return clients;
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return clients;
    }
}
