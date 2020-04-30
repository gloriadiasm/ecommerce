package com.unitri.comp.ecommerce.model.dao.impl;

import com.unitri.comp.ecommerce.model.dao.CartDao;
import com.unitri.comp.ecommerce.model.dao.ConnectionFactory;
import com.unitri.comp.ecommerce.model.entity.Cart;
import com.unitri.comp.ecommerce.model.entity.Order;
import com.unitri.comp.ecommerce.model.enums.OrderStatusEnum;

import java.sql.*;
import java.text.ParseException;
import java.util.List;

public class CartDaoImpl implements CartDao {

    private Connection connection;

    public CartDaoImpl() throws SQLException {
        this.connection =  new ConnectionFactory().getConnection();
    }

    @Override
    public Cart findById(Long id) throws SQLException{

        Cart cart = null;

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select *from driver where id = "+id);
            while(resultSet.next()) {
                cart = new Cart(resultSet.getLong("id"),
                        resultSet.getLong("client_id"));
            }
            resultSet.close();
           return cart;
        }catch (SQLException e){
            e.printStackTrace();
        } finally {
            connection.close();
        }
        return cart;
    }

    @Override
    public Cart findCart(Cart cart) {
        return null;
    }

    @Override
    public Cart create(Cart cart) {
        return null;
    }

    @Override
    public Cart update(Cart cart) {
        return null;
    }

    @Override
    public void delete(Cart cart) {

    }

    @Override
    public void deleteById() {

    }

    @Override
    public List<Cart> findAll() {
        return null;
    }

}
