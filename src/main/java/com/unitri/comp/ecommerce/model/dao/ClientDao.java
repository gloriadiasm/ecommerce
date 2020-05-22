package com.unitri.comp.ecommerce.model.dao;

import com.unitri.comp.ecommerce.model.entity.Client;

import java.sql.SQLException;
import java.util.List;

public interface ClientDao {
    Client findById(int id) throws SQLException;
    Client findClient(Client client) throws SQLException;
    Client create(Client client) throws SQLException;
    Client update(Client client) throws SQLException;
    void delete(Client client) throws SQLException;
    void deleteById() throws SQLException;
    List<Client> findAll() throws SQLException;
}
