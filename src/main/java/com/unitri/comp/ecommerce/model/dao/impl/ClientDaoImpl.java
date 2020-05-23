package com.unitri.comp.ecommerce.model.dao.impl;

import com.unitri.comp.ecommerce.model.dao.ClientDao;
import com.unitri.comp.ecommerce.model.entity.Client;
import com.unitri.comp.ecommerce.model.factory.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientDaoImpl implements ClientDao {
    private final Connection connection;

    public ClientDaoImpl() {
        this.connection = new ConnectionFactory().getConnection();
    }

    @Override
    public Client findById(int id) {
        Client client = null;

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from client where id = "+id);
            while (resultSet.next()){
                client = new Client(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("phone_number"),
                        resultSet.getString("email"),
                        resultSet.getInt("address"),
                        resultSet.getDouble("shipping"),
                        resultSet.getInt("cart"));
            }
            resultSet.close();
            return client;

        }catch (SQLException e){
            e.printStackTrace();
        }
        return client;
    }

    @Override
    public Client create(Client client) {
        try {
            PreparedStatement statement = connection.prepareStatement("insert into client values(?,?,?,?,?,?)");
                statement.setString(1, client.getName());
                statement.setString(2, client.getPhone_number());
                statement.setString(3, client.getEmail());
                statement.setInt(4, client.getAddress());
                statement.setDouble(5, client.getShipping());
                statement.setInt(6, client.getCart());
            statement.execute();
            statement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return client;
    }


    @Override
    public void deleteById(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement("delete from client where id=?");
            statement.setInt(1, id);
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
            ResultSet resultSet = statement.executeQuery("select *from client");
            while (resultSet.next()){
                Client client = new Client(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("phone_number"),
                        resultSet.getString("email"),
                        resultSet.getInt("address"),
                        resultSet.getDouble("shipping"),
                        resultSet.getInt("cart"));
            }
            statement.close();
            return clients;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clients;
    }

}
