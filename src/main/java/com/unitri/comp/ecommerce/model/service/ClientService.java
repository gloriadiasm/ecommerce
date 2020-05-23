package com.unitri.comp.ecommerce.model.service;

import com.unitri.comp.ecommerce.model.dao.impl.ClientDaoImpl;
import com.unitri.comp.ecommerce.model.entity.Client;

import java.util.List;

public class ClientService {

    final ClientDaoImpl clientDao = new ClientDaoImpl();

    public ClientService() {
    }

    public Client findById(int id) {
        return clientDao.findById(id);
    }

    public void create (Client client){
        clientDao.create(client);
    }

    public void deleteById (int id) {
        clientDao.deleteById(id);
    }

    public List<Client> findAll() {
        return clientDao.findAll();
    }
}

