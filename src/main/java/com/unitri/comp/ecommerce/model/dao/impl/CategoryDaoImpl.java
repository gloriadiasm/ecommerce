package com.unitri.comp.ecommerce.model.dao.impl;

import com.unitri.comp.ecommerce.model.factory.ConnectionFactory;
import com.unitri.comp.ecommerce.model.dao.OrderDao;
import com.unitri.comp.ecommerce.model.enums.OrderStatusEnum;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDaoImpl implements CategoryDao {

    private final Connection connection =  new ConnectionFactory().getConnection();

    public CategoryDaoImpl() {
    }

    @Override
    public Category findById(Long id) {

        Category category = null;

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select *from category where id = "+id);

            while(resultSet.next()) {
                category = new Category(resultSet.getInt("id"),
                        resultSet.getString("nome"),
                        resultSet.getObject("description"));
            }
            statement.close();
            return category;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return category;

    }

    @Override
    public void create(Category ategory) {
        try {
            PreparedStatement statement = connection.prepareStatement("insert into category values(?,?,?)");
            statement.setInt(1, category.getId());
            statement.setInt(2, category.getClientId());
            statement.setObject(3, category.getStatus());
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
