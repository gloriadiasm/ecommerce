package com.unitri.comp.ecommerce.model.dao.impl;

import com.unitri.comp.ecommerce.model.dao.ClientDao;
import com.unitri.comp.ecommerce.model.dao.ConnectionFactory;
import com.unitri.comp.ecommerce.model.entity.Client;

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
            ResultSet resultSet = statement.executeQuery("select * from ecommerce.address where id = "+id);
            while (resultSet.next()){
                client = new Client(resultSet.getInt("id"),
                        resultSet.getInt("address_id"),
                        resultSet.getInt("cart_id"),
                        resultSet.getInt("orders_id"));
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
    public Client findClient(Client client) {
        return null;
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
    public void delete(Client client) {

    }

    @Override
    public void deleteById() {

    }

    @Override
    public List<Client> findAll() {
        return null;
    }
}
