package com.unitri.comp.ecommerce.model.service;

import com.unitri.comp.ecommerce.model.dao.impl.ClientDaoImpl;
import com.unitri.comp.ecommerce.model.entity.Client;

import java.sql.SQLException;

public class ClientService {

    ClientDaoImpl clientDao;

    public ClientService() throws SQLException{
        this.clientDao = new ClientDaoImpl();
    }

    public Client findById(int id) throws SQLException{
        return clientDao.findById(id);
    }
}
