package com.unitri.comp.ecommerce.model.dao;

import com.unitri.comp.ecommerce.model.entity.Client;

import java.sql.SQLException;
import java.util.List;

public interface ClientDao {

    Client findById(Long id);
    void create(Client client);
    Client update(Client client);
    void deleteById(Long id);
    List<Client> findAll();
}
