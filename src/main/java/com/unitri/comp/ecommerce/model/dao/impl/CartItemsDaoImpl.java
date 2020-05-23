package com.unitri.comp.ecommerce.model.dao.impl;

import com.unitri.comp.ecommerce.model.dao.CartItemsDao;
import com.unitri.comp.ecommerce.model.entity.CartItems;
import com.unitri.comp.ecommerce.model.factory.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CartItemsDaoImpl implements CartItemsDao {

    private final Connection connection =  new ConnectionFactory().getConnection();

    public CartItemsDaoImpl() {
    }

    @Override
    public CartItems findById(int id){

        CartItems cartItems = null;

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select *from cart_items where id = "+id);

            while(resultSet.next()) {
                cartItems = new CartItems(resultSet.getInt("id"),
                        resultSet.getInt("cart_id"),
                        resultSet.getInt("product_id"),
                        resultSet.getLong("total_price"),
                        resultSet.getInt("quantity"));
            }
            statement.close();
            return cartItems;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return cartItems;
    }

    @Override
    public CartItems create(CartItems cartItems) {

        try {
            PreparedStatement statement = connection.prepareStatement("insert into cart_items values(?,?,?,?,?)");
            statement.setInt(1, cartItems.getId());
            statement.setInt(2, cartItems.getCart());
            statement.setInt(3, cartItems.getProduct());
            statement.setDouble(4, cartItems.getTotal_price());
            statement.setInt(5, cartItems.getQuantity());
            statement.execute();
            statement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return cartItems;
    }

    @Override
    public void deleteById(int id) {

        try {
            PreparedStatement statement = connection.prepareStatement("delete from cart_items where id=?");
            statement.setInt(1, id);
            statement.execute();
            statement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<CartItems> findAll() {

        List<CartItems> carts = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select *from cart_iems");
            while (resultSet.next()){
                CartItems cartItems = new CartItems(resultSet.getInt("id"),
                        resultSet.getInt("cart_id"),
                        resultSet.getInt("product_id"),
                        resultSet.getLong("total_price"),
                        resultSet.getInt("quantity"));
                carts.add(cartItems);
            }
            statement.close();
            return carts;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return carts;
    }
}
