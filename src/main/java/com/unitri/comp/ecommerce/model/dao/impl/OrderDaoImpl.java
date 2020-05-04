package com.unitri.comp.ecommerce.model.dao.impl;

import com.unitri.comp.ecommerce.model.factory.ConnectionFactory;
import com.unitri.comp.ecommerce.model.dao.OrderDao;
import com.unitri.comp.ecommerce.model.entity.Order;
import com.unitri.comp.ecommerce.model.enums.OrderStatusEnum;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDaoImpl implements OrderDao {

    private final Connection connection =  new ConnectionFactory().getConnection();

    public OrderDaoImpl() {
    }

    @Override
    public Order findById(Long id) {

        Order order = null;

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select *from order where id = "+id);

            while(resultSet.next()) {
                order = new Order(resultSet.getInt("id"),
                        resultSet.getInt("client_id"),
                        (OrderStatusEnum) resultSet.getObject("status"));
            }
            statement.close();
            return order;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return order;

    }

    @Override
    public void create(Order order) {
        try {
            PreparedStatement statement = connection.prepareStatement("insert into order values(?,?,?)");
            statement.setInt(1, order.getId());
            statement.setInt(2, order.getClientId());
            statement.setObject(3, order.getStatus());
            statement.execute();
            statement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public Order update(Order order) {
        return null;
    }

    @Override
    public void deleteById(int id) {

        try {
            PreparedStatement statement = connection.prepareStatement("delete from order where id=?");
            statement.setInt(1, id);
            statement.execute();
            statement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public List<Order> findAll() {
        List<Order> orders = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String sql = "select *from ´order´";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                Order order = new Order(resultSet.getInt("id"),
                        resultSet.getInt("client_id"),
                        (OrderStatusEnum) resultSet.getObject("status"));
                orders.add(order);
            }
            statement.close();
            return orders;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

}
