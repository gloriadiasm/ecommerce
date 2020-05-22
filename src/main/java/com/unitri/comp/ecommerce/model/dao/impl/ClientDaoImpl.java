package com.unitri.comp.ecommerce.model.dao.impl;

import com.unitri.comp.ecommerce.model.dao.ClientDao;
import com.unitri.comp.ecommerce.model.entity.Address;
import com.unitri.comp.ecommerce.model.entity.Client;
import com.unitri.comp.ecommerce.model.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class ClientDaoImpl implements ClientDao {
    private Connection connection;

    public ClientDaoImpl() throws SQLException{
        this.connection = new ConnectionFactory().getConnection();
    }

    @Override
    public Client findById(int id) throws SQLException {
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
        }finally {
            connection.close();
        }
        return client;
    }

    @Override
    public Client create(Client client) {
        return null;
    }

    @Override
    public Client update(Client client) {
        return null;
    }

    @Override
    public Address deleteById(int id) throws SQLException {

        return null;
    }

    @Override
    public List<Client> findAll() {
        return null;
    }
}
