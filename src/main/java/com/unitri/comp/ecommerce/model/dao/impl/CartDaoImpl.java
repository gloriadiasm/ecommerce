package com.unitri.comp.ecommerce.model.dao.impl;

import com.unitri.comp.ecommerce.model.dao.CartDao;
import com.unitri.comp.ecommerce.model.factory.ConnectionFactory;
import com.unitri.comp.ecommerce.model.entity.Cart;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CartDaoImpl implements CartDao {

    private final Connection connection =  new ConnectionFactory().getConnection();

    public CartDaoImpl() {
    }

    @Override
    public Cart findById(Long id){

        Cart cart = null;

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select *from cart where id = "+id);

            while(resultSet.next()) {
                cart = new Cart(resultSet.getInt("id"),
                        resultSet.getInt("client_id"));
            }
            statement.close();
           return cart;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return cart;
    }

    @Override
    public Cart findByClientId(Cart cart) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select *from cart where client_id = "+cart.getClientId());
            while(resultSet.next()) {
                cart = new Cart(resultSet.getInt("id"),
                        resultSet.getInt("client_id"));
            }
            statement.close();
            return cart;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return cart;
    }

    @Override
    public void create(Cart cart) {

        try {
            PreparedStatement statement = connection.prepareStatement("insert into cart values(?,?)");
            statement.setInt(1, cart.getId());
            statement.setInt(2, cart.getClientId());
            statement.execute();
            statement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(int id) {

        try {
            PreparedStatement statement = connection.prepareStatement("delete from cart where id=?");
            statement.setInt(1, id);
            statement.execute();
            statement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Cart> findAll() {

        List<Cart> carts = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select *from cart");
            while (resultSet.next()){
                Cart cart = new Cart(resultSet.getInt("id"), resultSet.getInt("client_id"));
                 carts.add(cart);
            }
            statement.close();
            return carts;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return carts;
    }
}
